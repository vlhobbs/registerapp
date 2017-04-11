package edu.uark.uarkregisterapp.models.api.enums;

import java.util.HashMap;
import java.util.Map;

import edu.uark.uarkregisterapp.models.api.interfaces.PathElementInterface;

public enum ApiLevel implements PathElementInterface {
	NONE(""),
	ONE("apiv0");

	@Override
	public String getPathValue() {
		return value;
	}

	public static ApiLevel map(String key) {
		if (valueMap == null) {
			valueMap = new HashMap<>();

			for (ApiLevel value : ApiLevel.values()) {
				valueMap.put(value.getPathValue(), value);
			}
		}

		return (valueMap.containsKey(key) ? valueMap.get(key) : ApiLevel.NONE);
	}

	private String value;

	private static Map<String, ApiLevel> valueMap = null;

	ApiLevel(String value) {
		this.value = value;
	}
}
