package com.bornfire.xbrl.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bornfire.xbrl.dto.CounterpartyMaintenanceDto;
import com.bornfire.xbrl.entities.CounterpartyMaintenanceEntity;
import com.bornfire.xbrl.entities.CounterpartyMaintenanceRepository;

@Service
public class CounterpartyMaintenanceService {

	private static final Logger logger = LoggerFactory.getLogger(CounterpartyMaintenanceService.class);

	@Autowired
	private CounterpartyMaintenanceRepository counterpartyMaintenanceRepository;

	public List<CounterpartyMaintenanceDto> getAllMaintained() {
		List<CounterpartyMaintenanceDto> list = new ArrayList<CounterpartyMaintenanceDto>();
		List<CounterpartyMaintenanceEntity> rows = counterpartyMaintenanceRepository.getAllMaintained();
		if (rows == null) {
			return list;
		}
		for (CounterpartyMaintenanceEntity entity : rows) {
			CounterpartyMaintenanceDto dto = toDto(entity);
			dto.setPresentInMaintenance(true);
			list.add(dto);
		}
		return list;
	}

	public List<CounterpartyMaintenanceDto> getOutstanding(String reportDate) {
		List<CounterpartyMaintenanceDto> list = new ArrayList<CounterpartyMaintenanceDto>();
		Date parsedDate = parseReportDate(reportDate);
		if (parsedDate == null) {
			return list;
		}

		List<String> codes = counterpartyMaintenanceRepository.findOutstandingCounterparties(parsedDate);
		Map<String, CounterpartyMaintenanceEntity> maintained = loadMaintainedMap();

		if (codes == null) {
			return list;
		}

		for (String code : codes) {
			if (isBlank(code)) {
				continue;
			}
			CounterpartyMaintenanceDto row = new CounterpartyMaintenanceDto();
			row.setCounterpartyCode(code.trim());
			row.setReportDate(reportDate);
			CounterpartyMaintenanceEntity saved = maintained.get(normalize(code));
			boolean inList = saved != null;
			row.setPresentInMaintenance(inList);
			if (inList) {
				applyEntity(row, saved);
			}
			list.add(row);
		}
		return list;
	}

	public CounterpartyMaintenanceDto getByCode(String counterpartyCode) {
		CounterpartyMaintenanceEntity entity = counterpartyMaintenanceRepository.getByCounterpartyCode(counterpartyCode);
		if (entity == null) {
			return null;
		}
		CounterpartyMaintenanceDto dto = toDto(entity);
		dto.setPresentInMaintenance(true);
		return dto;
	}

	public CounterpartyMaintenanceDto getOutstandingByCode(String counterpartyCode, String reportDate) {
		if (isBlank(counterpartyCode)) {
			return null;
		}
		CounterpartyMaintenanceDto saved = getByCode(counterpartyCode);
		if (saved != null) {
			if (!isBlank(reportDate)) {
				saved.setReportDate(reportDate);
			}
			return saved;
		}

		CounterpartyMaintenanceDto row = new CounterpartyMaintenanceDto();
		row.setCounterpartyCode(counterpartyCode.trim());
		row.setReportDate(reportDate);
		row.setPresentInMaintenance(false);
		return row;
	}

	public boolean isMaintained(String counterpartyCode) {
		return counterpartyMaintenanceRepository.getByCounterpartyCode(counterpartyCode) != null;
	}

	public String save(CounterpartyMaintenanceDto dto, String userid) {
		if (dto == null || isBlank(dto.getCounterpartyCode())) {
			return "Counterparty Code is required";
		}
		/*
		 * if (isBlank(dto.getAliasCounterCode())) { return
		 * "Alias Counter Code is required"; } if (isBlank(dto.getCounterpartyName())) {
		 * return "Counterparty Name is required"; }
		 */
		if (isBlank(dto.getAslBankName())) {
			return "ASL Bank Name is required";
		}

		Date now = new Date();
		CounterpartyMaintenanceEntity existing = counterpartyMaintenanceRepository
				.getByCounterpartyCode(dto.getCounterpartyCode());
		CounterpartyMaintenanceEntity stored = existing == null ? new CounterpartyMaintenanceEntity() : existing;

		stored.setCounterpartyCode(dto.getCounterpartyCode().trim());
		stored.setAliasCounterCode(trimToNull(dto.getAliasCounterCode()));
		stored.setCounterpartyName(trimToNull(dto.getCounterpartyName()));
		stored.setAslBankName(trimToNull(dto.getAslBankName()));
		stored.setCounterpartyRating(trimToNull(dto.getCounterpartyRating()));
		stored.setCountryRisk(trimToNull(dto.getCountryRisk()));
		stored.setCbuaeGeographicalZone(trimToNull(dto.getCbuaeGeographicalZone()));
		stored.setCounterpartyType(trimToNull(dto.getCounterpartyType()));

		Date reportToDate = parseReportDate(dto.getReportDate());
		if (reportToDate != null) {
			stored.setReportToDate(reportToDate);
		}

		if (existing == null) {
			stored.setCreateUser(userid);
			stored.setCreateTime(now);
			stored.setEntityFlg("Y");
			stored.setModifyFlg("N");
			counterpartyMaintenanceRepository.save(stored);
			return "Counterparty saved successfully";
		}

		stored.setModifyUser(userid);
		stored.setModifyTime(now);
		stored.setModifyFlg("Y");
		counterpartyMaintenanceRepository.save(stored);
		return "Counterparty updated successfully";
	}

	private Map<String, CounterpartyMaintenanceEntity> loadMaintainedMap() {
		Map<String, CounterpartyMaintenanceEntity> map = new HashMap<String, CounterpartyMaintenanceEntity>();
		List<CounterpartyMaintenanceEntity> rows = counterpartyMaintenanceRepository.getAllMaintained();
		if (rows == null) {
			return map;
		}
		for (CounterpartyMaintenanceEntity entity : rows) {
			if (entity != null && !isBlank(entity.getCounterpartyCode())) {
				map.put(normalize(entity.getCounterpartyCode()), entity);
			}
		}
		return map;
	}

	private CounterpartyMaintenanceDto toDto(CounterpartyMaintenanceEntity entity) {
		CounterpartyMaintenanceDto dto = new CounterpartyMaintenanceDto();
		applyEntity(dto, entity);
		if (entity.getReportToDate() != null) {
			dto.setReportDate(new SimpleDateFormat("yyyy-MM-dd").format(entity.getReportToDate()));
		}
		return dto;
	}

	private void applyEntity(CounterpartyMaintenanceDto dto, CounterpartyMaintenanceEntity entity) {
		dto.setCounterpartyCode(entity.getCounterpartyCode());
		dto.setAliasCounterCode(entity.getAliasCounterCode());
		dto.setCounterpartyName(entity.getCounterpartyName());
		dto.setAslBankName(entity.getAslBankName());
		dto.setCounterpartyRating(entity.getCounterpartyRating());
		dto.setCountryRisk(entity.getCountryRisk());
		dto.setCbuaeGeographicalZone(entity.getCbuaeGeographicalZone());
		dto.setCounterpartyType(entity.getCounterpartyType());
		dto.setCreateUser(entity.getCreateUser());
		dto.setCreateTime(entity.getCreateTime());
		dto.setModifyUser(entity.getModifyUser());
		dto.setModifyTime(entity.getModifyTime());
	}

	private Date parseReportDate(String reportDate) {
		if (isBlank(reportDate)) {
			return null;
		}
		String[] patterns = { "yyyy-MM-dd", "dd-MM-yyyy", "dd/MM/yyyy" };
		for (String pattern : patterns) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				sdf.setLenient(false);
				return sdf.parse(reportDate.trim());
			} catch (ParseException ignored) {
			}
		}
		logger.warn("Unable to parse report date: {}", reportDate);
		return null;
	}

	private String normalize(String value) {
		return value == null ? "" : value.trim().toUpperCase(Locale.ENGLISH);
	}

	private boolean isBlank(String value) {
		return value == null || value.trim().isEmpty();
	}

	private String trimToNull(String value) {
		if (isBlank(value)) {
			return null;
		}
		return value.trim();
	}
}
