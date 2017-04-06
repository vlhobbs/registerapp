package edu.uark.uarkregisterapp.models.api.enums;

import java.util.HashMap;
import java.util.Map;

import edu.uark.uarkregisterapp.models.api.interfaces.PathElementInterface;

public enum EmployeeApiMethod implements PathElementInterface {
<<<<<<< HEAD
    NONE(""),
    EMPLOYEE("employee"),
    ACTIVE_COUNTS("activecounts"),
    LOGIN("login");

    @Override
    public String getPathValue() {
        return value;
    }

    public static EmployeeApiMethod map(String key) {
        if (valueMap == null) {
            valueMap = new HashMap<>();

            for (EmployeeApiMethod value : EmployeeApiMethod.values()) {
                valueMap.put(value.getPathValue(), value);
            }
        }

        return (valueMap.containsKey(key) ? valueMap.get(key) : EmployeeApiMethod.NONE);
    }

    private String value;

    private static Map<String, EmployeeApiMethod> valueMap = null;

    EmployeeApiMethod(String value) {
        this.value = value;
    }
}
=======
	NONE(""),
	EMPLOYEE("employee"),
	ACTIVE_COUNTS("activecounts"),
	LOGIN("login");

	@Override
	public String getPathValue() {
		return value;
	}

	public static EmployeeApiMethod map(String key) {
		if (valueMap == null) {
			valueMap = new HashMap<>();

			for (EmployeeApiMethod value : EmployeeApiMethod.values()) {
				valueMap.put(value.getPathValue(), value);
			}
		}

		return (valueMap.containsKey(key) ? valueMap.get(key) : EmployeeApiMethod.NONE);
	}

	private String value;

	private static Map<String, EmployeeApiMethod> valueMap = null;

	EmployeeApiMethod(String value) {
		this.value = value;
	}
}
>>>>>>> 5b92bb214e1bd6e090485885d560de061873af4b
