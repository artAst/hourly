package org.hourly.core.dto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.hourly.common.constants.Operation;
import org.hourly.common.constants.Status;

public class BaseDTO implements Serializable {
	
	private static final long serialVersionUID = -5061191450465103459L;
	private Status status = Status.SUCCESS;
    private String message = "";
    private String userName;
    private String responseCode;
    private List<ValidationResponseObject> validationResultList = new LinkedList<ValidationResponseObject>();
    private Operation crudOperation = Operation.QUERY;

    public BaseDTO() {
        super();
    }

    public BaseDTO(Status status, String message) {
        super();

        this.status = status;
        this.message = message;
    }

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public List<ValidationResponseObject> getValidationResultList() {
		return validationResultList;
	}

	public void setValidationResultList(List<ValidationResponseObject> validationResultList) {
		this.validationResultList = validationResultList;
	}

	public Operation getCrudOperation() {
		return crudOperation;
	}

	public void setCrudOperation(Operation crudOperation) {
		this.crudOperation = crudOperation;
	}
	
	public void setStatusAndMessage(Status status, String message) {
        this.status = status;
        this.message = message;
    }
}
