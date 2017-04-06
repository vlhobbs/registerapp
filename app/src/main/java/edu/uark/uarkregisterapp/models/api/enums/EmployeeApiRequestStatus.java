package edu.uark.uarkregisterapp.models.api.enums;

import android.util.SparseArray;

import java.util.HashMap;
import java.util.Map;

public enum EmployeeApiRequestStatus {
<<<<<<< HEAD
    OK(0),
    INVALID_INPUT(1),
    UNKNOWN_ERROR(2),
    NOT_FOUND(3),
    EMPLOYEE_ID_ALREADY_EXISTS(4),
    INVALID_EMPLOYEE_ID_CHANGE(5);

    public int getValue() {
        return value;
    }

    public static EmployeeApiRequestStatus mapValue(int key) {
        if (valueMap == null) {
            valueMap = new SparseArray<>();

            for (EmployeeApiRequestStatus status : EmployeeApiRequestStatus.values()) {
                valueMap.put(status.getValue(), status);
            }
        }

        return ((valueMap.indexOfKey(key) >= 0) ? valueMap.get(key) : EmployeeApiRequestStatus.UNKNOWN_ERROR);
    }

    public static EmployeeApiRequestStatus mapName(String name) {
        if (nameMap == null) {
            nameMap = new HashMap<>();

            for (EmployeeApiRequestStatus status : EmployeeApiRequestStatus.values()) {
                nameMap.put(status.name(), status);
            }
        }

        return (nameMap.containsKey(name) ? nameMap.get(name) : EmployeeApiRequestStatus.UNKNOWN_ERROR);
    }

    private int value;

    private static Map<String, EmployeeApiRequestStatus> nameMap = null;
    private static SparseArray<EmployeeApiRequestStatus> valueMap = null;

    private EmployeeApiRequestStatus(int value) {
        this.value = value;
    }
}
=======
	OK(0),
	INVALID_INPUT(1),
	UNKNOWN_ERROR(2),
	NOT_FOUND(3),
	EMPLOYEE_ID_ALREADY_EXISTS(4),
	INVALID_EMPLOYEE_ID_CHANGE(5);

	public int getValue() {
		return value;
	}

	public static EmployeeApiRequestStatus mapValue(int key) {
		if (valueMap == null) {
			valueMap = new SparseArray<>();

			for (EmployeeApiRequestStatus status : EmployeeApiRequestStatus.values()) {
				valueMap.put(status.getValue(), status);
			}
		}

		return ((valueMap.indexOfKey(key) >= 0) ? valueMap.get(key) : EmployeeApiRequestStatus.UNKNOWN_ERROR);
	}

	public static EmployeeApiRequestStatus mapName(String name) {
		if (nameMap == null) {
			nameMap = new HashMap<>();

			for (EmployeeApiRequestStatus status : EmployeeApiRequestStatus.values()) {
				nameMap.put(status.name(), status);
			}
		}

		return (nameMap.containsKey(name) ? nameMap.get(name) : EmployeeApiRequestStatus.UNKNOWN_ERROR);
	}

	private int value;

	private static Map<String, EmployeeApiRequestStatus> nameMap = null;
	private static SparseArray<EmployeeApiRequestStatus> valueMap = null;

	private EmployeeApiRequestStatus(int value) {
		this.value = value;
	}
}
>>>>>>> 5b92bb214e1bd6e090485885d560de061873af4b
