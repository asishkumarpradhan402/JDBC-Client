package com.main.exception;

public class UserNotExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public UserNotExistsException(Integer id) {
		super();
		this.message = id +" is not Exists";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
