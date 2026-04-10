package com.pedro.picpaychallenge.configuration;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pedro.picpaychallenge.dtos.ExceptionDTO;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ExceptionDTO> threatDuplicateEntry(DataIntegrityViolationException exception) {
		ExceptionDTO exceptionDto = new ExceptionDTO("User already inserted", "400");
		return ResponseEntity.badRequest().body(exceptionDto);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ExceptionDTO> threat404(EntityNotFoundException exception) {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDTO> threatGeneralExceptions(Exception exception) {
		ExceptionDTO exceptionDto = new ExceptionDTO(exception.getMessage(), "500");
		return ResponseEntity.internalServerError().body(exceptionDto);
	}
}
