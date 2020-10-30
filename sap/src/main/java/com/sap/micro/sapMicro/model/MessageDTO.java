package com.sap.micro.sapMicro.model;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4256607316610313143L;

	private String errorMessage;

	private HttpStatus code;

	private Integer statusCode;

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

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
}
