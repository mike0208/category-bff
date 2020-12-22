package com.pccw.category.bff.exception;


public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String details;

	/**
	 * This is parameterized constructor of CustomExceprion class
	 * 
	 * @param message
	 * @param details
	 */
	public CustomException(String message, String details) {
		super(message);
		this.details = details;
	}

	/**
	 * This method returns the exception details
	 * 
	 * @return details
	 */
	public String getDetails() {
		return details;
	}

}
