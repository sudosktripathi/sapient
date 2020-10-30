package com.sap.micro.sapMicro.exception;

import org.springframework.http.HttpStatus;

public class ValidationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4696357844792584590L;

	private String errorMessage;

	private HttpStatus code;

	private int statusCode;

	public ValidationException() {
		super();
	}

	public ValidationException(String errorMessage, HttpStatus code, int statusCode) {
		super();
		this.errorMessage = errorMessage;
		this.code = code;
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
}
