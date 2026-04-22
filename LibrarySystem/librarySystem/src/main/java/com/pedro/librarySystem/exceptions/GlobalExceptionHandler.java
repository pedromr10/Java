package com.pedro.librarySystem.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> handleValidationErrors(MethodArgumentNotValidException e){
	    Map<String, String> errors = new HashMap<>();

	    e.getBindingResult().getFieldErrors().forEach(error -> {
	        errors.put(error.getField(), error.getDefaultMessage());
	    });

	    StandardError err = new StandardError();
	    err.setTimestamp(LocalDateTime.now());
	    err.setStatus(400);
	    err.setMessage("Validation error");
	    err.setErrors(errors);

	    return ResponseEntity.badRequest().body(err);
	}
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<StandardError> handleRuntime(RuntimeException e) {

	    StandardError err = new StandardError();
	    err.setTimestamp(LocalDateTime.now());
	    err.setStatus(404);
	    err.setMessage(e.getMessage());

	    return ResponseEntity.status(404).body(err);
	}
	
	
	
	
}
