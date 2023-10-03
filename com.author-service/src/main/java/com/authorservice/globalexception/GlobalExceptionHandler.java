package com.authorservice.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.authorservice.errorrespose.Errors;
import com.authorservice.exception.AuthorNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AuthorNotFoundException.class)
	public ResponseEntity<Errors> handleAuthorNotFoundException(AuthorNotFoundException ex) {
		Errors errorResponse = new Errors(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

}
