package edu.uark.uarkregisterapp.models.api.fields;

import edu.uark.uarkregisterapp.models.api.interfaces.FieldNameInterface;

public enum EmployeeFieldName implements FieldNameInterface {
<<<<<<< HEAD
    ID("id"),
    EMPLOYEE_ID("employeeId"),
    FIRST_NAME("firstName"),
    LAST_NAME("lastName"),
    PASSWORD("password"),
    ACTIVE("active"),
    CLASSIFICATION("classification"),
    MANAGER_ID("managerId"),
    API_REQUEST_STATUS("apiRequestStatus"),
    API_REQUEST_MESSAGE("apiRequestMessage"),
    CREATED_ON("createdOn");

    private String fieldName;
    public String getFieldName() {
        return this.fieldName;
    }

    EmployeeFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
=======
	ID("id"),
	EMPLOYEE_ID("employeeId"),
	FIRST_NAME("firstName"),
	LAST_NAME("lastName"),
	PASSWORD("password"),
	ACTIVE("active"),
	CLASSIFICATION("classification"),
	MANAGER_ID("managerId"),
	API_REQUEST_STATUS("apiRequestStatus"),
	API_REQUEST_MESSAGE("apiRequestMessage"),
	CREATED_ON("createdOn");

	private String fieldName;
	public String getFieldName() {
		return this.fieldName;
	}

	EmployeeFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
}
>>>>>>> 5b92bb214e1bd6e090485885d560de061873af4b
