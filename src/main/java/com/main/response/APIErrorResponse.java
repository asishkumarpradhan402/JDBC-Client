package com.main.response;

import org.springframework.http.HttpStatus;

public class APIErrorResponse {

	private String errorMessage;
	
	private HttpStatus httpStatus;

	public APIErrorResponse() {
		super();
	}

	public APIErrorResponse(String errorMessage, HttpStatus httpStatus) {
		super();
		this.errorMessage = errorMessage;
		this.httpStatus = httpStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
}
