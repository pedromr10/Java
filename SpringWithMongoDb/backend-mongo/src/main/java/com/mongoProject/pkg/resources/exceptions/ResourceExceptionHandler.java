package com.mongoProject.pkg.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mongoProject.pkg.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND; //erro 404
		String error = "Nao encontrado";
		String message = e.getMessage();
		String path = request.getRequestURI();
		
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), error, message, path);
		
		return ResponseEntity.status(status).body(err);
		//obs: quando der o erro ObjectNotFoundException, vamos retornar um objeto StandardError
	}
}
