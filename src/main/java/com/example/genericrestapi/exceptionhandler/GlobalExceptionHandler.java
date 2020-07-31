package com.example.genericrestapi.exceptionhandler;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.genericrestapi.error.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public ErrorResponse handleException(Exception ex) {
		return new ErrorResponse("Server not responding", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = IllegalArgumentException.class)
	public ErrorResponse handleIllegalArgumentException(IllegalArgumentException ex) {
		return new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = DatatypeConfigurationException.class)
	public ErrorResponse handleDatatypeConfigurationException(DatatypeConfigurationException ex) {
		return new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
