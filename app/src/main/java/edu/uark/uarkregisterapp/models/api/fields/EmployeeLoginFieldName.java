package edu.uark.uarkregisterapp.models.api.fields;

import edu.uark.uarkregisterapp.models.api.interfaces.FieldNameInterface;

public enum EmployeeLoginFieldName implements FieldNameInterface {
<<<<<<< HEAD
    EMPLOYEE_ID("employeeId"),
    PASSWORD("password");

    private String fieldName;
    public String getFieldName() {
        return this.fieldName;
    }

    EmployeeLoginFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
=======
	EMPLOYEE_ID("employeeId"),
	PASSWORD("password");

	private String fieldName;
	public String getFieldName() {
		return this.fieldName;
	}

	EmployeeLoginFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
}
>>>>>>> 5b92bb214e1bd6e090485885d560de061873af4b
