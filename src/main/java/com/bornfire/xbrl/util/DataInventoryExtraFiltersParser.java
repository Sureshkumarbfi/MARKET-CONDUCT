package com.bornfire.xbrl.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import com.bornfire.xbrl.dto.DataInventoryFixedFilterDto;
import com.bornfire.xbrl.dto.DataInventoryValidationConfigDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Parses RT_DATA_INVENTORY.EXTRA_FILTERS: backend fixed filters (not shown on dashboard) and date rules.
 */
public final class DataInventoryExtraFiltersParser {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	private DataInventoryExtraFiltersParser() {
	}

	public static DataInventoryValidationConfigDto parse(String raw) {
		DataInventoryValidationConfigDto config = new DataInventoryValidationConfigDto();
		if (raw == null || raw.trim().isEmpty()) {
			return config;
		}
		try {
			JsonNode root = MAPPER.readTree(raw.trim());
			if (root.isArray()) {
				parseFilterEntries(root, config);
				return config;
			}
			if (root.isObject()) {
				if (root.has("filters") && root.get("filters").isArray()) {
					parseFilterEntries(root.get("filters"), config);
				}
				if (root.has("fixedFilters") && root.get("fixedFilters").isArray()) {
					config.getFixedFilters().addAll(parseFixedFilterArray(root.get("fixedFilters")));
				}
				if (root.has("dateNotFuture")) {
					config.setDateNotFuture(root.get("dateNotFuture").asBoolean(false));
				}
				if (root.has("dateMaxDaysBack") && !root.get("dateMaxDaysBack").isNull()) {
					config.setDateMaxDaysBack(root.get("dateMaxDaysBack").asInt());
				}
			}
		} catch (Exception ex) {
			parseLegacyCsv(raw, config);
		}
		return config;
	}

	private static void parseFilterEntries(JsonNode array, DataInventoryValidationConfigDto config) {
		for (JsonNode node : array) {
			if (!node.isObject()) {
				continue;
			}
			String column = textOrEmpty(node, "column");
			if (column.isEmpty()) {
				continue;
			}
			List<String> values = parseFixedValuesFromNode(node);
			if (values.isEmpty() && node.has("options") && node.get("options").isArray()) {
				values = parseStringArray(node.get("options"));
			}
			if (values.isEmpty()) {
				String label = textOrEmpty(node, "label");
				if (label.contains(",")) {
					values = splitCommaValues(label);
				} else if (node.has("backend") && node.get("backend").asBoolean(false) && !label.isEmpty()) {
					values = splitCommaValues(label);
					if (values.isEmpty()) {
						values = new ArrayList<String>(Arrays.asList(label));
					}
				}
			}
			if (!values.isEmpty()) {
				DataInventoryFixedFilterDto fixed = new DataInventoryFixedFilterDto();
				fixed.setColumn(column);
				fixed.setValues(values);
				config.getFixedFilters().add(fixed);
			}
		}
	}

	private static List<DataInventoryFixedFilterDto> parseFixedFilterArray(JsonNode array) {
		List<DataInventoryFixedFilterDto> out = new ArrayList<DataInventoryFixedFilterDto>();
		for (JsonNode node : array) {
			if (!node.isObject()) {
				continue;
			}
			String column = textOrEmpty(node, "column");
			if (column.isEmpty()) {
				continue;
			}
			List<String> values = parseFixedValuesFromNode(node);
			if (values.isEmpty()) {
				continue;
			}
			DataInventoryFixedFilterDto fixed = new DataInventoryFixedFilterDto();
			fixed.setColumn(column);
			fixed.setValues(values);
			out.add(fixed);
		}
		return out;
	}

	private static List<String> parseFixedValuesFromNode(JsonNode node) {
		if (node.has("values") && node.get("values").isArray()) {
			return parseStringArray(node.get("values"));
		}
		if (node.has("value") && node.get("value").isTextual()) {
			String single = node.get("value").asText("").trim();
			if (!single.isEmpty()) {
				return new ArrayList<String>(Arrays.asList(single));
			}
		}
		return new ArrayList<String>();
	}

	private static List<String> parseStringArray(JsonNode array) {
		List<String> out = new ArrayList<String>();
		for (JsonNode opt : array) {
			if (opt.isTextual()) {
				String v = opt.asText().trim();
				if (!v.isEmpty()) {
					out.add(v);
				}
			}
		}
		return out;
	}

	private static List<String> splitCommaValues(String raw) {
		if (raw == null || raw.trim().isEmpty()) {
			return new ArrayList<String>();
		}
		return Arrays.stream(raw.split(",")).map(String::trim).filter(s -> !s.isEmpty())
				.collect(Collectors.toList());
	}

	/**
	 * Legacy CSV with fixed values: COLUMN:val1|val2,COLUMN2:val3
	 */
	private static void parseLegacyCsv(String raw, DataInventoryValidationConfigDto config) {
		for (String part : raw.split(",")) {
			String segment = part.trim();
			if (segment.isEmpty()) {
				continue;
			}
			String[] pieces = segment.split(":", 2);
			if (pieces.length < 2) {
				continue;
			}
			String column = pieces[0].trim();
			if (column.isEmpty()) {
				continue;
			}
			List<String> values = splitPipeOrSingle(pieces[1].trim());
			if (values.isEmpty()) {
				continue;
			}
			DataInventoryFixedFilterDto fixed = new DataInventoryFixedFilterDto();
			fixed.setColumn(column);
			fixed.setValues(values);
			config.getFixedFilters().add(fixed);
		}
	}

	private static List<String> splitPipeOrSingle(String raw) {
		if (raw.contains("|")) {
			return Arrays.stream(raw.split("\\|")).map(String::trim).filter(s -> !s.isEmpty())
					.collect(Collectors.toList());
		}
		if (raw.contains(",")) {
			return splitCommaValues(raw);
		}
		if (!raw.isEmpty()) {
			return new ArrayList<String>(Arrays.asList(raw));
		}
		return new ArrayList<String>();
	}

	private static String textOrEmpty(JsonNode node, String field) {
		if (!node.has(field) || node.get(field).isNull()) {
			return "";
		}
		return node.get(field).asText("").trim();
	}
}
