package com.pedro.nubankchallenge.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExeptionHandler {
	
	//validation:
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException e){
		Map<String, String> errors = new HashMap<>();
		e.getBindingResult().getFieldErrors().forEach(error->{
			errors.put(error.getField(), error.getDefaultMessage());
		});
        ErrorResponse response = ErrorResponse.builder().status(HttpStatus.BAD_REQUEST.value()).message("Validation error").timestamp(LocalDateTime.now()).errors(errors).build();
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	//not found:
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException e) {
	    ErrorResponse response = ErrorResponse.builder().status(404).message(e.getMessage()).timestamp(LocalDateTime.now()).build();
	    return ResponseEntity.status(404).body(response);
	}
}
