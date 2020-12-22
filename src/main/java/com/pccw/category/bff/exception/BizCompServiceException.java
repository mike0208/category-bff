package com.pccw.category.bff.exception;


public class BizCompServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String code;
	private final String reason;
	private final String message;
	private final String status;
	private final String referenceError;
	private final String baseType;
	private final String schemaLocation;
	private final String type;

	/**
	 * This is parameterized constructor of BizCompServiceException class
	 * 
	 * @param message
	 * @param details
	 */
	public BizCompServiceException(String code, String reason, String message, String status, String referenceError,
			String baseType, String schemaLocation, String type) {
		super(message);
		this.code = code;
		this.reason = reason;
		this.message = message;
		this.status = status;
		this.referenceError = referenceError;
		this.baseType = baseType;
		this.schemaLocation = schemaLocation;
		this.type = type;
	}
	

	public String getCode() {
		return code;
	}

	public String getReason() {
		return reason;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public String getStatus() {
		return status;
	}

	public String getReferenceError() {
		return referenceError;
	}

	public String getBaseType() {
		return baseType;
	}

	public String getSchemaLocation() {
		return schemaLocation;
	}

	public String getType() {
		return type;
	}
}
