package com.bornfire.xbrl.services;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.CellStyle;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bornfire.xbrl.dto.AnalyticalPivotColumnDto;
import com.bornfire.xbrl.dto.AnalyticalPivotDimensionDto;
import com.bornfire.xbrl.dto.AnalyticalPivotLayoutDto;
import com.bornfire.xbrl.dto.AnalyticalPivotRequestDto;
import com.bornfire.xbrl.dto.AnalyticalPivotRunResponseDto;
import com.bornfire.xbrl.dto.AnalyticalPivotTableDto;
import com.bornfire.xbrl.entities.RT_Analytical_Pivot_Layout_Entity;
import com.bornfire.xbrl.entities.RT_Analytical_Pivot_Layout_Repo;

@Service
public class AnalyticalPivotService {

	private static final Pattern SAFE_IDENTIFIER = Pattern.compile("^[A-Z][A-Z0-9_$#]*$");
	private static final Set<String> NUMERIC_TYPES = new LinkedHashSet<String>(
			Arrays.asList("NUMBER", "BINARY_FLOAT", "BINARY_DOUBLE", "FLOAT", "DECIMAL", "INTEGER"));

	private static final Set<String> DATE_TYPES = new LinkedHashSet<String>(Arrays.asList("DATE", "TIMESTAMP",
			"TIMESTAMP WITH TIME ZONE", "TIMESTAMP WITH LOCAL TIME ZONE"));

	private static final ObjectMapper OM = new ObjectMapper();

	private static final int MAX_RESULT_ROWS = 5000;

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	private RT_Analytical_Pivot_Layout_Repo layoutRepo;

	@Value("${analytical.pivot.allowedTables:RT_SLS,RT_SLS_REPORT,RT_IRS,RT_IRS2,RT_MID_FX_DEAL,RT_MATRIX_MONITORING,RT_NOOP_NET_POSITION,RT_NOOP_NET_POSITION_SUMM,RT_RWA_FUND_BASE_DATA,ELAR_SUMMARY_REPORT,RT_OVERNIGHT_FOREIGN_CCY_DATA}")
	private String configuredTables;

	@Autowired
	public AnalyticalPivotService(@Qualifier("srcdataSource") DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<AnalyticalPivotTableDto> getAllowedTables() {
		List<AnalyticalPivotTableDto> out = new ArrayList<AnalyticalPivotTableDto>();
		for (String table : getAllowedTablesInternal()) {
			AnalyticalPivotTableDto dto = new AnalyticalPivotTableDto();
			dto.setTableName(table);
			dto.setDisplayName(table.replace("_", " "));
			out.add(dto);
		}
		return out;
	}

	public List<AnalyticalPivotColumnDto> getColumnsForTable(String tableName) {
		String safeTable = normalizeAndValidateTable(tableName);
		String sql = "SELECT COLUMN_NAME, DATA_TYPE FROM USER_TAB_COLUMNS WHERE TABLE_NAME = ? ORDER BY COLUMN_ID";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, safeTable);
		List<AnalyticalPivotColumnDto> out = new ArrayList<AnalyticalPivotColumnDto>();
		for (Map<String, Object> row : rows) {
			String colName = safeUpper(row.get("COLUMN_NAME"));
			String dataType = safeUpper(row.get("DATA_TYPE"));
			AnalyticalPivotColumnDto dto = new AnalyticalPivotColumnDto();
			dto.setColumnName(colName);
			dto.setDataType(dataType);
			dto.setNumeric(NUMERIC_TYPES.contains(dataType));
			out.add(dto);
		}
		return out;
	}

	@Transactional(transactionManager = "datasrcTransactionManager", readOnly = true)
	public List<String> getDistinctColumnValues(String tableName, String columnName, int limit) {
		String safeTable = normalizeAndValidateTable(tableName);
		List<AnalyticalPivotColumnDto> metaList = getColumnsForTable(safeTable);
		Map<String, AnalyticalPivotColumnDto> metaByName = new LinkedHashMap<String, AnalyticalPivotColumnDto>();
		for (AnalyticalPivotColumnDto c : metaList) {
			metaByName.put(c.getColumnName(), c);
		}
		String col = safeUpper(columnName);
		if (!SAFE_IDENTIFIER.matcher(col).matches() || !metaByName.containsKey(col)) {
			throw new IllegalArgumentException("Unknown column: " + col);
		}
		int lim = Math.min(500, Math.max(1, limit));
		String sql = "SELECT DISTINCT " + col + " AS V FROM " + safeTable + " WHERE " + col + " IS NOT NULL FETCH FIRST "
				+ lim + " ROWS ONLY";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		AnalyticalPivotColumnDto colMeta = metaByName.get(col);
		List<String> out = new ArrayList<String>();
		for (Map<String, Object> r : rows) {
			Object v = r.get("V");
			if (v == null) {
				for (Object o : r.values()) {
					v = o;
					break;
				}
			}
			if (v != null) {
				if (colMeta != null && isDateType(colMeta.getDataType())) {
					out.add(formatDateDisplay(v));
				} else {
					out.add(v.toString());
				}
			}
		}
		return out;
	}

	@Transactional(transactionManager = "datasrcTransactionManager", readOnly = true)
	public AnalyticalPivotRunResponseDto runPivot(AnalyticalPivotRequestDto request) {
		ValidatedRequest validated = validateRequest(request);

		List<String> dimensions = new ArrayList<String>();
		for (DimensionDef d : validated.rowDims) {
			dimensions.add(d.columnName);
		}
		for (DimensionDef d : validated.colDims) {
			dimensions.add(d.columnName);
		}

		String aggExpr;
		if ("COUNT".equals(validated.aggregation)) {
			aggExpr = "COUNT(*) AS MEASURE_VALUE";
		} else {
			List<String> aggParts = new ArrayList<String>();
			boolean singleMeasure = validated.valueColumns.size() == 1;
			for (String col : validated.valueColumns) {
				String alias = sqlMeasureAlias(col, singleMeasure);
				aggParts.add("SUM(" + col + ") AS " + alias);
			}
			aggExpr = String.join(", ", aggParts);
		}

		List<Object> args = new ArrayList<Object>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		if (!dimensions.isEmpty()) {
			sql.append(String.join(", ", dimensions)).append(", ");
		}
		sql.append(aggExpr).append(" ");
		sql.append("FROM ").append(validated.tableName).append(" ");
		appendWhereClause(sql, args, validated.rowDims, validated.colDims, validated.filterDims);
		if (!dimensions.isEmpty()) {
			sql.append("GROUP BY ").append(String.join(", ", dimensions)).append(" ");
			sql.append("ORDER BY ").append(String.join(", ", dimensions)).append(" ");
		}
		sql.append("FETCH FIRST ").append(MAX_RESULT_ROWS).append(" ROWS ONLY");

		final List<Object> bindArgs = args;
		List<Map<String, Object>> dataRows;
		if (bindArgs.isEmpty()) {
			dataRows = jdbcTemplate.queryForList(sql.toString());
		} else {
			dataRows = jdbcTemplate.query(sql.toString(), ps -> {
				int i = 1;
				for (Object o : bindArgs) {
					ps.setObject(i++, o);
				}
			}, new ColumnMapRowMapper());
		}

		postProcessResultRows(dataRows, validated);

		AnalyticalPivotRunResponseDto response = new AnalyticalPivotRunResponseDto();
		response.setTableName(validated.tableName);
		response.setRowColumns(dimensionNames(validated.rowDims));
		response.setColumnColumns(dimensionNames(validated.colDims));
		response.setAggregation(validated.aggregation);
		response.setValueColumn(validated.valueColumns.isEmpty() ? null : validated.valueColumns.get(0));
		response.setValueColumns(new ArrayList<String>(validated.valueColumns));
		response.setData(dataRows);
		response.setRowCount(dataRows.size());
		return response;
	}

	@Transactional(transactionManager = "datasrcTransactionManager")
	public AnalyticalPivotLayoutDto saveLayout(String userId, AnalyticalPivotLayoutDto request) {
		if (userId == null || userId.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid user");
		}
		if (request == null || request.getLayoutName() == null || request.getLayoutName().trim().isEmpty()) {
			throw new IllegalArgumentException("Layout name is required");
		}

		AnalyticalPivotRequestDto validateReq = new AnalyticalPivotRequestDto();
		validateReq.setTableName(request.getTableName());
		if (request.getRowDimensions() != null && !request.getRowDimensions().isEmpty()) {
			validateReq.setRowDimensions(request.getRowDimensions());
		} else {
			validateReq.setRowColumns(request.getRowColumns());
		}
		if (request.getColumnDimensions() != null && !request.getColumnDimensions().isEmpty()) {
			validateReq.setColumnDimensions(request.getColumnDimensions());
		} else {
			validateReq.setColumnColumns(request.getColumnColumns());
		}
		validateReq.setAggregation(request.getAggregation());
		validateReq.setValueColumn(request.getValueColumn());
		validateReq.setValueColumns(request.getValueColumns());
		validateReq.setAggregateTransform(request.getAggregateTransform());
		validateReq.setAggregateTransformOperand(request.getAggregateTransformOperand());

		ValidatedRequest validated = validateRequest(validateReq);
		String cleanUser = userId.trim();
		String layoutName = request.getLayoutName().trim();
		Date now = new Date();

		Optional<RT_Analytical_Pivot_Layout_Entity> existing = layoutRepo.findByUserIdAndLayoutName(cleanUser, layoutName);
		RT_Analytical_Pivot_Layout_Entity entity = existing.isPresent() ? existing.get()
				: new RT_Analytical_Pivot_Layout_Entity();

		if (!existing.isPresent()) {
			entity.setCreatedTime(now);
		}
		entity.setUserId(cleanUser);
		entity.setLayoutName(layoutName);
		entity.setTableName(validated.tableName);
		try {
			entity.setRowColumns(dimensionsToJsonNamesOnly(validated.rowDims));
			entity.setColumnColumns(dimensionsToJsonNamesOnly(validated.colDims));
		} catch (JsonProcessingException e) {
			throw new IllegalArgumentException("Could not save layout payload");
		}
		entity.setAggregationType(validated.aggregation);
		entity.setValueColumn(joinValueColumns(validated.valueColumns));
		entity.setAggregateTransform(validated.aggregateTransform);
		entity.setAggregateOperand(validated.aggregateOperand != null ? validated.aggregateOperand.toPlainString() : null);
		entity.setUpdatedTime(now);
		entity = layoutRepo.save(entity);

		return toLayoutDto(entity);
	}

	@Transactional(transactionManager = "datasrcTransactionManager", readOnly = true)
	public List<AnalyticalPivotLayoutDto> loadLayouts(String userId) {
		if (userId == null || userId.trim().isEmpty()) {
			return Collections.emptyList();
		}
		List<RT_Analytical_Pivot_Layout_Entity> rows = layoutRepo.findByUserIdOrderByUpdatedTimeDesc(userId.trim());
		List<AnalyticalPivotLayoutDto> out = new ArrayList<AnalyticalPivotLayoutDto>();
		for (RT_Analytical_Pivot_Layout_Entity row : rows) {
			out.add(toLayoutDto(row));
		}
		return out;
	}

	@Transactional(transactionManager = "datasrcTransactionManager", readOnly = true)
	public byte[] exportPivotExcel(AnalyticalPivotRequestDto request) throws Exception {
		AnalyticalPivotRunResponseDto result = runPivot(request);
		Map<String, Object> matrix = buildPivotMatrix(result);
		@SuppressWarnings("unchecked")
		List<String> rowHeaders = (List<String>) matrix.get("rowHeaders");
		@SuppressWarnings("unchecked")
		List<String> columnHeaders = (List<String>) matrix.get("columnHeaders");
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> rows = (List<Map<String, Object>>) matrix.get("rows");

		Workbook workbook = new XSSFWorkbook();
		CellStyle numberStyle = workbook.createCellStyle();
		short numFmt = workbook.getCreationHelper().createDataFormat().getFormat("#,##0.00");
		numberStyle.setDataFormat(numFmt);
		Sheet sheet = workbook.createSheet("Analytical Pivot");
		int rowNum = 0;

		Row header = sheet.createRow(rowNum++);
		int colIdx = 0;
		for (String rowCol : rowHeaders) {
			Cell cell = header.createCell(colIdx++);
			cell.setCellValue(rowCol);
		}
		for (String colHeader : columnHeaders) {
			Cell cell = header.createCell(colIdx++);
			cell.setCellValue(colHeader);
		}

		for (Map<String, Object> record : rows) {
			Row excelRow = sheet.createRow(rowNum++);
			colIdx = 0;
			for (String rowCol : rowHeaders) {
				writeCell(excelRow.createCell(colIdx++), record.get(rowCol), null);
			}
			for (String colHeader : columnHeaders) {
				writeCell(excelRow.createCell(colIdx++), record.get(colHeader), numberStyle);
			}
		}

		for (int i = 0; i < rowHeaders.size() + columnHeaders.size(); i++) {
			sheet.autoSizeColumn(i);
		}

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		workbook.write(bos);
		workbook.close();
		return bos.toByteArray();
	}

	private void writeCell(Cell cell, Object value, CellStyle numberStyle) {
		if (value == null) {
			cell.setCellValue("");
		} else if (value instanceof BigDecimal) {
			cell.setCellValue(((BigDecimal) value).doubleValue());
			if (numberStyle != null) {
				cell.setCellStyle(numberStyle);
			}
		} else if (value instanceof Number) {
			cell.setCellValue(((Number) value).doubleValue());
			if (numberStyle != null) {
				cell.setCellStyle(numberStyle);
			}
		} else if (value instanceof Date) {
			cell.setCellValue(formatDateDisplay(value));
		} else {
			cell.setCellValue(value.toString());
		}
	}

	private Map<String, Object> buildPivotMatrix(AnalyticalPivotRunResponseDto result) {
		List<String> rowColumns = result.getRowColumns() == null ? Collections.<String>emptyList() : result.getRowColumns();
		List<String> colColumns = result.getColumnColumns() == null ? Collections.<String>emptyList() : result.getColumnColumns();
		List<Map<String, Object>> data = result.getData() == null ? Collections.<Map<String, Object>>emptyList() : result.getData();

		Set<String> dynamicColumnHeaders = new LinkedHashSet<String>();
		Map<String, Map<String, Object>> rowMap = new LinkedHashMap<String, Map<String, Object>>();

		for (Map<String, Object> row : data) {
			String rowKey = joinKey(rowColumns, row);
			List<MeasureDef> measures = resolveMeasuresForResult(result);
			for (MeasureDef measure : measures) {
				String baseColKey = colColumns.isEmpty() ? measure.displayLabel
						: joinKey(colColumns, row);
				String colKey = measures.size() > 1 && !colColumns.isEmpty()
						? baseColKey + " | " + measure.displayLabel
						: baseColKey;
				dynamicColumnHeaders.add(colKey);
				Map<String, Object> record = rowMap.get(rowKey);
				if (record == null) {
					record = new LinkedHashMap<String, Object>();
					for (String rowCol : rowColumns) {
						record.put(rowCol, getMapValueIgnoreCase(row, rowCol));
					}
					rowMap.put(rowKey, record);
				}
				record.put(colKey, getMapValueIgnoreCase(row, measure.sqlAlias));
			}
		}

		Map<String, Object> out = new LinkedHashMap<String, Object>();
		out.put("rowHeaders", rowColumns);
		out.put("columnHeaders", new ArrayList<String>(dynamicColumnHeaders));
		out.put("rows", new ArrayList<Map<String, Object>>(rowMap.values()));
		return out;
	}

	private String joinKey(List<String> cols, Map<String, Object> row) {
		List<String> vals = new ArrayList<String>();
		for (String col : cols) {
			Object v = getMapValueIgnoreCase(row, col);
			vals.add(v == null ? "" : String.valueOf(v));
		}
		return String.join(" | ", vals);
	}

	private void appendWhereClause(StringBuilder sql, List<Object> args, List<DimensionDef> rowDims,
			List<DimensionDef> colDims, List<DimensionDef> filterDims) {
		boolean first = true;
		for (DimensionDef d : concatDims(rowDims, colDims, filterDims)) {
			if (d.filterValues == null || d.filterValues.isEmpty()) {
				continue;
			}
			if (first) {
				sql.append("WHERE ");
				first = false;
			} else {
				sql.append("AND ");
			}
			String col = d.columnName;
			AnalyticalPivotColumnDto meta = d.meta;
			if (meta == null) {
				throw new IllegalArgumentException("Unknown column metadata for filter: " + col);
			}
			String dt = meta.getDataType();
			List<String> vals = d.filterValues;
			if (vals.size() == 1) {
				String fv = vals.get(0);
				if (isDateType(dt)) {
					sql.append("TRUNC(").append(col).append(") = TO_DATE(?, 'YYYY-MM-DD') ");
					args.add(normalizeIsoDate(fv));
				} else if (NUMERIC_TYPES.contains(dt)) {
					sql.append(col).append(" = ? ");
					try {
						args.add(new BigDecimal(fv));
					} catch (NumberFormatException e) {
						throw new IllegalArgumentException("Invalid numeric filter for " + col);
					}
				} else {
					sql.append(col).append(" = ? ");
					args.add(fv);
				}
			} else {
				if (isDateType(dt)) {
					sql.append("TRUNC(").append(col).append(") IN (");
					for (int i = 0; i < vals.size(); i++) {
						if (i > 0) {
							sql.append(", ");
						}
						sql.append("TO_DATE(?, 'YYYY-MM-DD')");
					}
					sql.append(") ");
					for (String fv : vals) {
						args.add(normalizeIsoDate(fv));
					}
				} else if (NUMERIC_TYPES.contains(dt)) {
					sql.append(col).append(" IN (");
					for (int i = 0; i < vals.size(); i++) {
						if (i > 0) {
							sql.append(", ");
						}
						sql.append("?");
					}
					sql.append(") ");
					for (String fv : vals) {
						try {
							args.add(new BigDecimal(fv));
						} catch (NumberFormatException e) {
							throw new IllegalArgumentException("Invalid numeric filter for " + col);
						}
					}
				} else {
					sql.append(col).append(" IN (");
					for (int i = 0; i < vals.size(); i++) {
						if (i > 0) {
							sql.append(", ");
						}
						sql.append("?");
					}
					sql.append(") ");
					for (String fv : vals) {
						args.add(fv);
					}
				}
			}
		}
	}

	private List<DimensionDef> concatDims(List<DimensionDef> rowDims, List<DimensionDef> colDims,
			List<DimensionDef> filterDims) {
		List<DimensionDef> all = new ArrayList<DimensionDef>();
		all.addAll(rowDims);
		all.addAll(colDims);
		all.addAll(filterDims);
		return all;
	}

	private List<String> dimensionNames(List<DimensionDef> dims) {
		List<String> names = new ArrayList<String>();
		for (DimensionDef d : dims) {
			names.add(d.columnName);
		}
		return names;
	}

	/** Saved layouts store row/column names only; filters change per run and are not persisted. */
	private String dimensionsToJsonNamesOnly(List<DimensionDef> dims) throws JsonProcessingException {
		List<AnalyticalPivotDimensionDto> list = new ArrayList<AnalyticalPivotDimensionDto>();
		for (DimensionDef d : dims) {
			AnalyticalPivotDimensionDto x = new AnalyticalPivotDimensionDto();
			x.setColumnName(d.columnName);
			list.add(x);
		}
		return OM.writeValueAsString(list);
	}

	private String normalizeIsoDate(String input) {
		if (input == null || input.trim().isEmpty()) {
			throw new IllegalArgumentException("Empty date filter");
		}
		String s = input.trim();
		try {
			LocalDate.parse(s, DateTimeFormatter.ISO_LOCAL_DATE);
			return s;
		} catch (DateTimeParseException ignored) {
		}
		try {
			SimpleDateFormat in = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
			in.setLenient(false);
			Date d = in.parse(s);
			return new SimpleDateFormat("yyyy-MM-dd").format(d);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Could not parse date as yyyy-MM-dd or dd-MMM-yyyy: " + s);
		}
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

	private void postProcessResultRows(List<Map<String, Object>> rows, ValidatedRequest v) {
		if (rows == null || rows.isEmpty()) {
			return;
		}
		Set<String> dimNames = new LinkedHashSet<String>();
		for (DimensionDef d : v.rowDims) {
			dimNames.add(d.columnName);
		}
		for (DimensionDef d : v.colDims) {
			dimNames.add(d.columnName);
		}
		for (Map<String, Object> row : rows) {
			for (String dim : dimNames) {
				Object val = getMapValueIgnoreCase(row, dim);
				if (val == null) {
					continue;
				}
				AnalyticalPivotColumnDto meta = v.metadataByName != null ? v.metadataByName.get(dim) : null;
				if (meta != null && isDateType(meta.getDataType())) {
					putMapValueIgnoreCase(row, dim, formatDateDisplay(val));
				}
			}
			for (MeasureDef measure : resolveMeasuresForRequest(v)) {
				Object mv = getMapValueIgnoreCase(row, measure.sqlAlias);
				if (mv == null) {
					continue;
				}
				try {
					BigDecimal bd = toBigDecimal(mv);
					if ("SUM".equals(v.aggregation)) {
						bd = applyMeasureTransform(bd, v.aggregateTransform, v.aggregateOperand);
						putMapValueIgnoreCase(row, measure.sqlAlias, bd.setScale(2, RoundingMode.HALF_UP));
					} else if ("COUNT".equals(v.aggregation)) {
						putMapValueIgnoreCase(row, measure.sqlAlias, bd.setScale(2, RoundingMode.HALF_UP));
					}
				} catch (Exception ignored) {
					// leave raw value
				}
			}
		}
	}

	private static Object getMapValueIgnoreCase(Map<String, Object> row, String key) {
		if (row == null || key == null) {
			return null;
		}
		Object v = row.get(key);
		if (v != null) {
			return v;
		}
		for (Map.Entry<String, Object> e : row.entrySet()) {
			if (e.getKey() != null && e.getKey().equalsIgnoreCase(key)) {
				return e.getValue();
			}
		}
		return null;
	}

	private static void putMapValueIgnoreCase(Map<String, Object> row, String key, Object value) {
		if (row == null || key == null) {
			return;
		}
		if (row.containsKey(key)) {
			row.put(key, value);
			return;
		}
		for (String k : row.keySet()) {
			if (k != null && k.equalsIgnoreCase(key)) {
				row.put(k, value);
				return;
			}
		}
		row.put(key, value);
	}

	private String formatDateDisplay(Object val) {
		Date d;
		if (val instanceof Timestamp) {
			d = new Date(((Timestamp) val).getTime());
		} else if (val instanceof java.sql.Date) {
			d = new Date(((java.sql.Date) val).getTime());
		} else if (val instanceof Date) {
			d = (Date) val;
		} else {
			return String.valueOf(val);
		}
		return new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(d).toUpperCase(Locale.ENGLISH);
	}

	private BigDecimal toBigDecimal(Object o) {
		if (o instanceof BigDecimal) {
			return (BigDecimal) o;
		}
		if (o instanceof Number) {
			return new BigDecimal(((Number) o).toString());
		}
		return new BigDecimal(String.valueOf(o));
	}

	private BigDecimal applyMeasureTransform(BigDecimal value, String transform, BigDecimal operand) {
		if (value == null) {
			return null;
		}
		String t = transform == null ? "NONE" : transform.trim().toUpperCase(Locale.ENGLISH);
		if ("NONE".equals(t) || operand == null) {
			return value;
		}
		if ("DIVIDE".equals(t)) {
			return value.divide(operand, 10, RoundingMode.HALF_UP);
		}
		if ("MULTIPLY".equals(t)) {
			return value.multiply(operand);
		}
		if ("PERCENT_OF".equals(t)) {
			return value.multiply(new BigDecimal("100")).divide(operand, 10, RoundingMode.HALF_UP);
		}
		return value;
	}

	private ValidatedRequest validateRequest(AnalyticalPivotRequestDto request) {
		if (request == null) {
			throw new IllegalArgumentException("Request is required");
		}
		String tableName = normalizeAndValidateTable(request.getTableName());
		List<AnalyticalPivotColumnDto> metadata = getColumnsForTable(tableName);
		Map<String, AnalyticalPivotColumnDto> metadataByName = new LinkedHashMap<String, AnalyticalPivotColumnDto>();
		for (AnalyticalPivotColumnDto c : metadata) {
			metadataByName.put(c.getColumnName(), c);
		}

		List<AnalyticalPivotDimensionDto> rowIn = request.getRowDimensions();
		if (rowIn == null || rowIn.isEmpty()) {
			rowIn = fromLegacyColumnNames(request.getRowColumns());
		}
		List<AnalyticalPivotDimensionDto> colIn = request.getColumnDimensions();
		if (colIn == null || colIn.isEmpty()) {
			colIn = fromLegacyColumnNames(request.getColumnColumns());
		}
		List<AnalyticalPivotDimensionDto> filterIn = request.getFilterDimensions();

		List<DimensionDef> rowDims = resolveDimensions(rowIn, metadataByName);
		List<DimensionDef> colDims = resolveDimensions(colIn, metadataByName);
		List<DimensionDef> filterDims = resolveDimensions(filterIn, metadataByName);

		Set<String> duplicates = new LinkedHashSet<String>(dimensionNames(rowDims));
		duplicates.retainAll(new LinkedHashSet<String>(dimensionNames(colDims)));
		if (!duplicates.isEmpty()) {
			throw new IllegalArgumentException("Same column cannot be used in both Rows and Columns: " + duplicates);
		}

		Set<String> rowAndCol = new LinkedHashSet<String>(dimensionNames(rowDims));
		rowAndCol.addAll(dimensionNames(colDims));
		Set<String> filterDuplicates = new LinkedHashSet<String>(dimensionNames(filterDims));
		filterDuplicates.retainAll(rowAndCol);
		if (!filterDuplicates.isEmpty()) {
			throw new IllegalArgumentException("Same column cannot be used in Filters and Rows/Columns: " + filterDuplicates);
		}

		for (DimensionDef d : concatDims(rowDims, colDims, filterDims)) {
			if (d.filterValues != null && !d.filterValues.isEmpty()) {
				validateDimensionFilters(d);
			}
		}

		String aggregation = safeUpper(request.getAggregation());
		if (!"SUM".equals(aggregation) && !"COUNT".equals(aggregation)) {
			throw new IllegalArgumentException("Aggregation must be SUM or COUNT");
		}

		List<String> valueColumns = resolveValueColumns(request);
		if ("SUM".equals(aggregation)) {
			if (valueColumns.isEmpty()) {
				throw new IllegalArgumentException("At least one measure column is required for SUM");
			}
			for (String vc : valueColumns) {
				AnalyticalPivotColumnDto metricMeta = metadataByName.get(vc);
				if (metricMeta == null) {
					throw new IllegalArgumentException("Unknown value column: " + vc);
				}
				if (!metricMeta.isNumeric()) {
					throw new IllegalArgumentException("SUM is allowed only on numeric columns: " + vc);
				}
			}
		}

		String aggTrans = safeUpper(request.getAggregateTransform());
		if (aggTrans.isEmpty()) {
			aggTrans = "NONE";
		}
		if (!"NONE".equals(aggTrans) && !"DIVIDE".equals(aggTrans) && !"MULTIPLY".equals(aggTrans)
				&& !"PERCENT_OF".equals(aggTrans)) {
			throw new IllegalArgumentException("Invalid aggregate transform");
		}
		BigDecimal aggOp = null;
		if (!"NONE".equals(aggTrans)) {
			if (!"SUM".equals(aggregation)) {
				throw new IllegalArgumentException("Divide / multiply / percentage applies only to SUM");
			}
			String opStr = request.getAggregateTransformOperand();
			if (opStr == null || opStr.trim().isEmpty()) {
				throw new IllegalArgumentException("Operand is required for transform");
			}
			try {
				aggOp = new BigDecimal(opStr.trim());
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("Invalid operand number");
			}
			if (aggOp.compareTo(BigDecimal.ZERO) == 0) {
				throw new IllegalArgumentException("Operand cannot be zero");
			}
		} else {
			aggTrans = "NONE";
			aggOp = null;
		}

		ValidatedRequest out = new ValidatedRequest();
		out.tableName = tableName;
		out.rowDims = rowDims;
		out.colDims = colDims;
		out.filterDims = filterDims;
		out.aggregation = aggregation;
		out.valueColumns = valueColumns;
		out.metadataByName = metadataByName;
		out.aggregateTransform = aggTrans;
		out.aggregateOperand = aggOp;
		return out;
	}

	private void validateDimensionFilters(DimensionDef d) {
		AnalyticalPivotColumnDto meta = d.meta;
		if (meta == null) {
			throw new IllegalArgumentException("Unknown column: " + d.columnName);
		}
		String dt = meta.getDataType();
		for (String fv : d.filterValues) {
			if (fv == null || fv.trim().isEmpty()) {
				continue;
			}
			String t = fv.trim();
			if (isDateType(dt)) {
				normalizeIsoDate(t);
			} else if (meta.isNumeric()) {
				try {
					new BigDecimal(t);
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException("Invalid numeric filter for " + d.columnName);
				}
			}
		}
	}

	private List<AnalyticalPivotDimensionDto> fromLegacyColumnNames(List<String> cols) {
		if (cols == null || cols.isEmpty()) {
			return Collections.emptyList();
		}
		List<AnalyticalPivotDimensionDto> out = new ArrayList<AnalyticalPivotDimensionDto>();
		for (String c : cols) {
			if (c == null || c.trim().isEmpty()) {
				continue;
			}
			AnalyticalPivotDimensionDto d = new AnalyticalPivotDimensionDto();
			d.setColumnName(c.trim());
			d.setFilterValue(null);
			out.add(d);
		}
		return out;
	}

	private List<DimensionDef> resolveDimensions(List<AnalyticalPivotDimensionDto> incoming,
			Map<String, AnalyticalPivotColumnDto> metadataByName) {
		if (incoming == null || incoming.isEmpty()) {
			return new ArrayList<DimensionDef>();
		}
		List<DimensionDef> out = new ArrayList<DimensionDef>();
		Set<String> seen = new LinkedHashSet<String>();
		for (AnalyticalPivotDimensionDto dto : incoming) {
			if (dto == null || dto.getColumnName() == null) {
				continue;
			}
			String clean = safeUpper(dto.getColumnName());
			if (clean.isEmpty()) {
				continue;
			}
			if (!SAFE_IDENTIFIER.matcher(clean).matches()) {
				throw new IllegalArgumentException("Invalid column name: " + clean);
			}
			if (!metadataByName.containsKey(clean)) {
				throw new IllegalArgumentException("Unknown column: " + clean);
			}
			if (!seen.add(clean)) {
				throw new IllegalArgumentException("Duplicate column in dimension list: " + clean);
			}
			DimensionDef d = new DimensionDef();
			d.columnName = clean;
			d.meta = metadataByName.get(clean);
			List<String> filters = new ArrayList<String>();
			if (dto.getFilterValues() != null) {
				for (String s : dto.getFilterValues()) {
					if (s != null && !s.trim().isEmpty()) {
						filters.add(s.trim());
					}
				}
			}
			if (filters.isEmpty() && dto.getFilterValue() != null && !dto.getFilterValue().trim().isEmpty()) {
				filters.add(dto.getFilterValue().trim());
			}
			d.filterValues = filters.isEmpty() ? null : filters;
			out.add(d);
		}
		return out;
	}

	private String normalizeAndValidateTable(String tableName) {
		String clean = safeUpper(tableName);
		if (!SAFE_IDENTIFIER.matcher(clean).matches()) {
			throw new IllegalArgumentException("Invalid table name");
		}
		if (!getAllowedTablesInternal().contains(clean)) {
			throw new IllegalArgumentException("Table is not allowed for analytics");
		}
		return clean;
	}

	private Set<String> getAllowedTablesInternal() {
		return Arrays.stream(configuredTables.split(",")).map(String::trim).filter(s -> !s.isEmpty()).map(String::toUpperCase)
				.collect(Collectors.toCollection(LinkedHashSet::new));
	}

	private String safeUpper(Object value) {
		return value == null ? "" : String.valueOf(value).trim().toUpperCase(Locale.ENGLISH);
	}

	private List<String> splitColumns(String raw) {
		if (raw == null || raw.trim().isEmpty()) {
			return Collections.emptyList();
		}
		return Arrays.stream(raw.split(",")).map(String::trim).filter(s -> !s.isEmpty()).collect(Collectors.toList());
	}

	private AnalyticalPivotLayoutDto toLayoutDto(RT_Analytical_Pivot_Layout_Entity row) {
		AnalyticalPivotLayoutDto dto = new AnalyticalPivotLayoutDto();
		dto.setLayoutId(row.getLayoutId());
		dto.setLayoutName(row.getLayoutName());
		dto.setTableName(row.getTableName());
		dto.setAggregation(row.getAggregationType());
		List<String> valueCols = splitColumns(row.getValueColumn());
		dto.setValueColumns(valueCols);
		dto.setValueColumn(valueCols.isEmpty() ? row.getValueColumn() : valueCols.get(0));
		try {
			List<AnalyticalPivotDimensionDto> rowDims = parseStoredDimensions(row.getRowColumns());
			List<AnalyticalPivotDimensionDto> colDims = parseStoredDimensions(row.getColumnColumns());
			dto.setRowDimensions(rowDims);
			dto.setColumnDimensions(colDims);
			dto.setRowColumns(dimensionDtoNames(rowDims));
			dto.setColumnColumns(dimensionDtoNames(colDims));
		} catch (Exception e) {
			dto.setRowColumns(splitColumns(row.getRowColumns()));
			dto.setColumnColumns(splitColumns(row.getColumnColumns()));
		}
		dto.setAggregateTransform(row.getAggregateTransform());
		dto.setAggregateTransformOperand(row.getAggregateOperand());
		return dto;
	}

	private List<String> dimensionDtoNames(List<AnalyticalPivotDimensionDto> dims) {
		List<String> names = new ArrayList<String>();
		for (AnalyticalPivotDimensionDto d : dims) {
			if (d != null && d.getColumnName() != null) {
				names.add(safeUpper(d.getColumnName()));
			}
		}
		return names;
	}

	private List<AnalyticalPivotDimensionDto> parseStoredDimensions(String raw) throws java.io.IOException {
		if (raw == null || raw.trim().isEmpty()) {
			return Collections.emptyList();
		}
		String s = raw.trim();
		if (s.startsWith("[")) {
			return OM.readValue(s, new TypeReference<List<AnalyticalPivotDimensionDto>>() {
			});
		}
		List<AnalyticalPivotDimensionDto> out = new ArrayList<AnalyticalPivotDimensionDto>();
		for (String c : splitColumns(s)) {
			AnalyticalPivotDimensionDto d = new AnalyticalPivotDimensionDto();
			d.setColumnName(c);
			d.setFilterValue(null);
			out.add(d);
		}
		return out;
	}

	private List<String> resolveValueColumns(AnalyticalPivotRequestDto request) {
		List<String> out = new ArrayList<String>();
		if (request.getValueColumns() != null) {
			for (String c : request.getValueColumns()) {
				if (c == null || c.trim().isEmpty()) {
					continue;
				}
				String u = safeUpper(c);
				if (!out.contains(u)) {
					out.add(u);
				}
			}
		}
		if (out.isEmpty()) {
			String single = safeUpper(request.getValueColumn());
			if (!single.isEmpty()) {
				out.add(single);
			}
		}
		return out;
	}

	private String joinValueColumns(List<String> valueColumns) {
		if (valueColumns == null || valueColumns.isEmpty()) {
			return null;
		}
		return String.join(",", valueColumns);
	}

	private String sqlMeasureAlias(String columnName, boolean singleMeasure) {
		return singleMeasure ? "MEASURE_VALUE" : ("M_" + columnName);
	}

	private String measureDisplayLabel(String aggregation, String columnName) {
		if ("COUNT".equals(aggregation)) {
			return "COUNT(*)";
		}
		return "SUM(" + columnName + ")";
	}

	private List<MeasureDef> resolveMeasuresForRequest(ValidatedRequest v) {
		List<MeasureDef> out = new ArrayList<MeasureDef>();
		if ("COUNT".equals(v.aggregation)) {
			MeasureDef m = new MeasureDef();
			m.columnName = null;
			m.sqlAlias = "MEASURE_VALUE";
			m.displayLabel = "COUNT(*)";
			out.add(m);
			return out;
		}
		boolean single = v.valueColumns.size() == 1;
		for (String col : v.valueColumns) {
			MeasureDef m = new MeasureDef();
			m.columnName = col;
			m.sqlAlias = sqlMeasureAlias(col, single);
			m.displayLabel = measureDisplayLabel(v.aggregation, col);
			out.add(m);
		}
		return out;
	}

	private List<MeasureDef> resolveMeasuresForResult(AnalyticalPivotRunResponseDto result) {
		List<MeasureDef> out = new ArrayList<MeasureDef>();
		if ("COUNT".equals(result.getAggregation())) {
			MeasureDef m = new MeasureDef();
			m.columnName = null;
			m.sqlAlias = "MEASURE_VALUE";
			m.displayLabel = "COUNT(*)";
			out.add(m);
			return out;
		}
		List<String> cols = result.getValueColumns();
		if (cols == null || cols.isEmpty()) {
			String single = safeUpper(result.getValueColumn());
			cols = single.isEmpty() ? Collections.<String>emptyList() : Collections.singletonList(single);
		}
		boolean single = cols.size() == 1;
		for (String col : cols) {
			MeasureDef m = new MeasureDef();
			m.columnName = col;
			m.sqlAlias = sqlMeasureAlias(col, single);
			m.displayLabel = measureDisplayLabel(result.getAggregation(), col);
			out.add(m);
		}
		return out;
	}

	private static class ValidatedRequest {
		private String tableName;
		private List<DimensionDef> rowDims;
		private List<DimensionDef> colDims;
		private List<DimensionDef> filterDims;
		private String aggregation;
		private List<String> valueColumns;
		private Map<String, AnalyticalPivotColumnDto> metadataByName;
		private String aggregateTransform;
		private BigDecimal aggregateOperand;
	}

	private static class MeasureDef {
		private String columnName;
		private String sqlAlias;
		private String displayLabel;
	}

	private static class DimensionDef {
		private String columnName;
		private List<String> filterValues;
		private AnalyticalPivotColumnDto meta;
	}
}
