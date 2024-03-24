package com.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.main.response.APIErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotExistsException.class)
	public ResponseEntity<APIErrorResponse> userNotExistsCall(UserNotExistsException userNotExistsException) {
		return new ResponseEntity<APIErrorResponse>(new APIErrorResponse(userNotExistsException.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
	}
}
