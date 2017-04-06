package edu.uark.uarkregisterapp.models.api.fields;

import edu.uark.uarkregisterapp.models.api.interfaces.FieldNameInterface;

public enum ActiveEmployeeCountsFieldName implements FieldNameInterface {
<<<<<<< HEAD
    CASHIER_COUNT("activeCashierCount"),
    SHIFT_MANAGER_COUNT("activeShiftManagerCount"),
    GENERAL_MANAGER_COUNT("activeGeneralManagerCount");

    private String fieldName;
    public String getFieldName() {
        return this.fieldName;
    }

    ActiveEmployeeCountsFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
=======
	CASHIER_COUNT("activeCashierCount"),
	SHIFT_MANAGER_COUNT("activeShiftManagerCount"),
	GENERAL_MANAGER_COUNT("activeGeneralManagerCount");

	private String fieldName;
	public String getFieldName() {
		return this.fieldName;
	}

	ActiveEmployeeCountsFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
}
>>>>>>> 5b92bb214e1bd6e090485885d560de061873af4b
