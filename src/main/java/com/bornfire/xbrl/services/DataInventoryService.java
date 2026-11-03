package com.bornfire.xbrl.services;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bornfire.xbrl.dto.DataInventoryExportResultDto;
import com.bornfire.xbrl.dto.DataInventoryFixedFilterDto;
import com.bornfire.xbrl.dto.DataInventoryItemDto;
import com.bornfire.xbrl.dto.DataInventoryValidationConfigDto;
import com.bornfire.xbrl.entities.RT_Data_Inventory_Entity;
import com.bornfire.xbrl.entities.RT_Data_Inventory_Repo;
import com.bornfire.xbrl.util.DataInventoryExtraFiltersParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DataInventoryService {

	private static final Pattern SAFE_IDENTIFIER = Pattern.compile("^[A-Z][A-Z0-9_$#]*$");

	private static final Set<String> DATE_TYPES = new LinkedHashSet<String>(Arrays.asList("DATE", "TIMESTAMP",
			"TIMESTAMP WITH TIME ZONE", "TIMESTAMP WITH LOCAL TIME ZONE"));

	private static final SimpleDateFormat DISPLAY_DATE = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

	private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	private RT_Data_Inventory_Repo inventoryRepo;

	@Value("${data.inventory.maxExportRows:150000}")
	private int maxExportRows;

	@Autowired
	public DataInventoryService(@Qualifier("srcdataSource") DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<DataInventoryItemDto> listActiveInventory() {
		List<RT_Data_Inventory_Entity> rows = inventoryRepo.findByIsActiveOrderBySortOrderAscReportNameAsc("Y");
		List<DataInventoryItemDto> out = new ArrayList<DataInventoryItemDto>();
		for (RT_Data_Inventory_Entity row : rows) {
			DataInventoryItemDto dto = new DataInventoryItemDto();
			dto.setInventoryId(row.getInventoryId());
			dto.setReportName(row.getReportName());
			DataInventoryValidationConfigDto validationConfig = DataInventoryExtraFiltersParser
					.parse(row.getExtraFilters());
			dto.setDateNotFuture(validationConfig.isDateNotFuture());
			dto.setDateMaxDaysBack(validationConfig.getDateMaxDaysBack());
			out.add(dto);
		}
		return out;
	}

	@Transactional(transactionManager = "datasrcTransactionManager", readOnly = true)
	public DataInventoryExportResultDto exportByReportType(String reportType, LocalDate reportDate, String format)
			throws Exception {
		if (reportType == null || reportType.trim().isEmpty()) {
			throw new IllegalArgumentException("Report type is required");
		}
		RT_Data_Inventory_Entity config = inventoryRepo
				.findFirstByReportTypeCodeIgnoreCaseAndIsActive(reportType.trim(), "Y")
				.orElseThrow(() -> new IllegalArgumentException(
						"Export is not configured for report type: " + reportType
								+ ". Add a row in RT_DATA_INVENTORY with REPORT_TYPE_CODE."));
		return export(config.getInventoryId(), reportDate, format, null);
	}

	@Transactional(transactionManager = "datasrcTransactionManager", readOnly = true)
	public DataInventoryExportResultDto export(Long inventoryId, LocalDate reportDate, String format) throws Exception {
		return export(inventoryId, reportDate, format, null);
	}

	@Transactional(transactionManager = "datasrcTransactionManager", readOnly = true)
	public DataInventoryExportResultDto export(Long inventoryId, LocalDate reportDate, String format,
			Map<String, String> extraFilterValues) throws Exception {
		if (inventoryId == null) {
			throw new IllegalArgumentException("Inventory id is required");
		}
		if (reportDate == null) {
			throw new IllegalArgumentException("Report date is required");
		}
		String fmt = format != null ? format.trim().toLowerCase(Locale.ENGLISH) : "";
		if (!"text".equals(fmt) && !"excel".equals(fmt)) {
			throw new IllegalArgumentException("Format must be text or excel");
		}

		RT_Data_Inventory_Entity config = inventoryRepo.findById(inventoryId)
				.orElseThrow(() -> new IllegalArgumentException("Inventory entry not found"));
		if (config.getIsActive() == null || !"Y".equalsIgnoreCase(config.getIsActive().trim())) {
			throw new IllegalArgumentException("Inventory entry is not active");
		}

		DataInventoryValidationConfigDto validationConfig = DataInventoryExtraFiltersParser.parse(config.getExtraFilters());
		validateReportDateRules(reportDate, validationConfig);
		List<DataInventoryFixedFilterDto> fixedFilters = resolveFixedFiltersFromConfig(config, validationConfig);

		ValidatedExport validated = validateExportConfig(config, validationConfig);
		List<Map<String, Object>> rows = queryRows(validated, reportDate, fixedFilters);
		if (rows.isEmpty()) {
			throw new NoDataForExportException("No data found for the selected report date");
		}

		String safeReportName = sanitizeFileName(config.getReportName());
		String dateSuffix = reportDate.toString().replace("-", "");
		DataInventoryExportResultDto result = new DataInventoryExportResultDto();

		if ("excel".equals(fmt)) {
			result.setContent(buildExcel(validated.exportColumns, rows));
			result.setFileName(safeReportName + "_" + dateSuffix + ".xlsx");
			result.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		} else {
			result.setContent(buildText(validated.exportColumns, rows));
			result.setFileName(safeReportName + "_" + dateSuffix + ".txt");
			result.setContentType("text/plain; charset=UTF-8");
		}
		return result;
	}

	public Map<String, String> parseExtraFiltersParam(String filtersJson) {
		if (filtersJson == null || filtersJson.trim().isEmpty()) {
			return Collections.emptyMap();
		}
		try {
			Map<String, String> parsed = JSON_MAPPER.readValue(filtersJson.trim(),
					new TypeReference<Map<String, String>>() {
					});
			Map<String, String> out = new LinkedHashMap<String, String>();
			if (parsed != null) {
				for (Map.Entry<String, String> e : parsed.entrySet()) {
					if (e.getKey() != null && e.getValue() != null && !e.getValue().trim().isEmpty()) {
						out.put(e.getKey().trim(), e.getValue().trim());
					}
				}
			}
			return out;
		} catch (Exception ex) {
			throw new IllegalArgumentException("Invalid filters JSON");
		}
	}

	private void validateReportDateRules(LocalDate reportDate, DataInventoryValidationConfigDto validationConfig) {
		LocalDate today = LocalDate.now();
		if (validationConfig.isDateNotFuture() && reportDate.isAfter(today)) {
			throw new IllegalArgumentException("Report date cannot be in the future");
		}
		if (validationConfig.getDateMaxDaysBack() != null && validationConfig.getDateMaxDaysBack() > 0) {
			LocalDate earliest = today.minusDays(validationConfig.getDateMaxDaysBack());
			if (reportDate.isBefore(earliest)) {
				throw new IllegalArgumentException(
						"Report date cannot be earlier than " + earliest + " (max " + validationConfig.getDateMaxDaysBack()
								+ " days back)");
			}
		}
	}

	/**
	 * Fixed filters from EXTRA_FILTERS only (dashboard does not send filter values).
	 */
	private List<DataInventoryFixedFilterDto> resolveFixedFiltersFromConfig(RT_Data_Inventory_Entity config,
			DataInventoryValidationConfigDto validationConfig) {
		List<DataInventoryFixedFilterDto> fixed = validationConfig.getFixedFilters();
		if (fixed == null || fixed.isEmpty()) {
			return Collections.emptyList();
		}
		Map<String, String> columnTypes = loadColumnTypes(safeUpper(config.getTableName()));
		List<DataInventoryFixedFilterDto> out = new ArrayList<DataInventoryFixedFilterDto>();
		for (DataInventoryFixedFilterDto filter : fixed) {
			String col = safeUpper(filter.getColumn());
			if (!SAFE_IDENTIFIER.matcher(col).matches() || !columnTypes.containsKey(col)) {
				throw new IllegalArgumentException("Filter column not found on table: " + col);
			}
			List<String> values = new ArrayList<String>();
			if (filter.getValues() != null) {
				for (String v : filter.getValues()) {
					if (v != null && !v.trim().isEmpty()) {
						values.add(v.trim());
					}
				}
			}
			if (values.isEmpty()) {
				throw new IllegalArgumentException("Filter " + col + " has no values in configuration");
			}
			DataInventoryFixedFilterDto copy = new DataInventoryFixedFilterDto();
			copy.setColumn(col);
			copy.setValues(values);
			out.add(copy);
		}
		return out;
	}

	private ValidatedExport validateExportConfig(RT_Data_Inventory_Entity config,
			DataInventoryValidationConfigDto validationConfig) {
		String tableName = safeUpper(config.getTableName());
		if (!SAFE_IDENTIFIER.matcher(tableName).matches()) {
			throw new IllegalArgumentException("Invalid table name in configuration");
		}

		boolean registered = inventoryRepo.findByIsActiveOrderBySortOrderAscReportNameAsc("Y").stream()
				.anyMatch(e -> tableName.equals(safeUpper(e.getTableName())));
		if (!registered) {
			throw new IllegalArgumentException("Table is not registered in data inventory");
		}

		Map<String, String> columnTypes = loadColumnTypes(tableName);
		if (columnTypes.isEmpty()) {
			throw new IllegalArgumentException("Table not found or has no columns: " + tableName);
		}

		String dateColumn = safeUpper(config.getDateColumnName());
		if (!SAFE_IDENTIFIER.matcher(dateColumn).matches() || !columnTypes.containsKey(dateColumn)) {
			throw new IllegalArgumentException("Invalid date column in configuration");
		}
		if (!isDateType(columnTypes.get(dateColumn))) {
			throw new IllegalArgumentException("Date column must be a date or timestamp type");
		}

		List<String> exportColumns = parseExportColumns(config.getExportColumns());
		if (exportColumns.isEmpty()) {
			throw new IllegalArgumentException("Export columns are not configured");
		}
		for (String col : exportColumns) {
			if (!SAFE_IDENTIFIER.matcher(col).matches() || !columnTypes.containsKey(col)) {
				throw new IllegalArgumentException("Invalid export column: " + col);
			}
		}

		if (validationConfig != null && validationConfig.getFixedFilters() != null) {
			for (DataInventoryFixedFilterDto field : validationConfig.getFixedFilters()) {
				String col = safeUpper(field.getColumn());
				if (!columnTypes.containsKey(col)) {
					throw new IllegalArgumentException("Filter column not found on table: " + col);
				}
			}
		}

		ValidatedExport out = new ValidatedExport();
		out.tableName = tableName;
		out.dateColumn = dateColumn;
		out.exportColumns = exportColumns;
		return out;
	}

	private List<Map<String, Object>> queryRows(ValidatedExport validated, LocalDate reportDate,
			List<DataInventoryFixedFilterDto> fixedFilters) {
		String selectList = validated.exportColumns.stream().collect(Collectors.joining(", "));
		int rowLimit = Math.max(1, maxExportRows);
		StringBuilder sql = new StringBuilder("SELECT ").append(selectList).append(" FROM ").append(validated.tableName)
				.append(" WHERE TRUNC(").append(validated.dateColumn).append(") = TRUNC(?)");
		List<Object> params = new ArrayList<Object>();
		params.add(Date.valueOf(reportDate));
		if (fixedFilters != null) {
			for (DataInventoryFixedFilterDto filter : fixedFilters) {
				List<String> values = filter.getValues();
				if (values == null || values.isEmpty()) {
					continue;
				}
				if (values.size() == 1) {
					sql.append(" AND ").append(filter.getColumn()).append(" = ?");
					params.add(values.get(0));
				} else {
					sql.append(" AND ").append(filter.getColumn()).append(" IN (");
					for (int i = 0; i < values.size(); i++) {
						if (i > 0) {
							sql.append(",");
						}
						sql.append("?");
						params.add(values.get(i));
					}
					sql.append(")");
				}
			}
		}
		sql.append(" FETCH FIRST ").append(rowLimit).append(" ROWS ONLY");
		return jdbcTemplate.query(sql.toString(), new ColumnMapRowMapper(), params.toArray());
	}

	private Map<String, String> loadColumnTypes(String tableName) {
		String sql = "SELECT COLUMN_NAME, DATA_TYPE FROM USER_TAB_COLUMNS WHERE TABLE_NAME = ? ORDER BY COLUMN_ID";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, tableName);
		Map<String, String> out = new LinkedHashMap<String, String>();
		for (Map<String, Object> row : rows) {
			out.put(safeUpper(row.get("COLUMN_NAME")), safeUpper(row.get("DATA_TYPE")));
		}
		return out;
	}

	private byte[] buildText(List<String> columns, List<Map<String, Object>> rows) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.join("|", columns)).append("\r\n");
		for (Map<String, Object> row : rows) {
			List<String> values = new ArrayList<String>();
			for (String col : columns) {
				Object val = getMapValueIgnoreCase(row, col);
				values.add(formatCellValue(val));
			}
			sb.append(String.join("|", values)).append("\r\n");
		}
		return sb.toString().getBytes(StandardCharsets.UTF_8);
	}

	private byte[] buildExcel(List<String> columns, List<Map<String, Object>> rows) throws Exception {
		Workbook workbook = new XSSFWorkbook();
		try {
			Sheet sheet = workbook.createSheet("Data Export");
			int rowNum = 0;
			Row header = sheet.createRow(rowNum++);
			for (int i = 0; i < columns.size(); i++) {
				header.createCell(i).setCellValue(columns.get(i));
			}
			for (Map<String, Object> dataRow : rows) {
				Row excelRow = sheet.createRow(rowNum++);
				for (int i = 0; i < columns.size(); i++) {
					Cell cell = excelRow.createCell(i);
					setCellValue(cell, getMapValueIgnoreCase(dataRow, columns.get(i)));
				}
			}
			for (int i = 0; i < columns.size(); i++) {
				sheet.autoSizeColumn(i);
			}
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			return bos.toByteArray();
		} finally {
			workbook.close();
		}
	}

	private void setCellValue(Cell cell, Object value) {
		if (value == null) {
			cell.setCellValue("");
			return;
		}
		if (value instanceof Number) {
			cell.setCellValue(((Number) value).doubleValue());
			return;
		}
		if (value instanceof Date) {
			cell.setCellValue(DISPLAY_DATE.format((Date) value));
			return;
		}
		if (value instanceof Timestamp) {
			cell.setCellValue(DISPLAY_DATE.format(new Date(((Timestamp) value).getTime())));
			return;
		}
		if (value instanceof java.util.Date) {
			cell.setCellValue(DISPLAY_DATE.format((java.util.Date) value));
			return;
		}
		cell.setCellValue(formatCellValue(value));
	}

	private String formatCellValue(Object value) {
		if (value == null) {
			return "";
		}
		if (value instanceof Date) {
			return DISPLAY_DATE.format((Date) value);
		}
		if (value instanceof Timestamp) {
			return DISPLAY_DATE.format(new Date(((Timestamp) value).getTime()));
		}
		if (value instanceof java.util.Date) {
			return DISPLAY_DATE.format((java.util.Date) value);
		}
		return String.valueOf(value);
	}

	private Object getMapValueIgnoreCase(Map<String, Object> row, String columnName) {
		if (row == null || columnName == null) {
			return null;
		}
		if (row.containsKey(columnName)) {
			return row.get(columnName);
		}
		for (Map.Entry<String, Object> entry : row.entrySet()) {
			if (entry.getKey() != null && entry.getKey().equalsIgnoreCase(columnName)) {
				return entry.getValue();
			}
		}
		return null;
	}

	private List<String> parseExportColumns(String raw) {
		if (raw == null || raw.trim().isEmpty()) {
			return Collections.emptyList();
		}
		return Arrays.stream(raw.split(",")).map(String::trim).filter(s -> !s.isEmpty()).map(this::safeUpper)
				.collect(Collectors.toList());
	}

	private boolean isDateType(String dataTypeUpper) {
		if (dataTypeUpper == null) {
			return false;
		}
		String u = dataTypeUpper.trim().toUpperCase(Locale.ENGLISH);
		if (DATE_TYPES.contains(u)) {
			return true;
		}
		return u.startsWith("TIMESTAMP");
	}

	private String safeUpper(Object value) {
		return value == null ? "" : String.valueOf(value).trim().toUpperCase(Locale.ENGLISH);
	}

	private String sanitizeFileName(String name) {
		if (name == null || name.trim().isEmpty()) {
			return "DataExport";
		}
		return name.trim().replaceAll("[\\\\/:*?\"<>|]", "_").replaceAll("\\s+", "_");
	}

	public static class NoDataForExportException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public NoDataForExportException(String message) {
			super(message);
		}
	}

	private static class ValidatedExport {
		private String tableName;
		private String dateColumn;
		private List<String> exportColumns;
	}
}
