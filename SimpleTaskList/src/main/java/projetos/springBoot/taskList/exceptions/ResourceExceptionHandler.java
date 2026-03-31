package projetos.springBoot.taskList.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice //intercepta os erros do controller
public class ResourceExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class) //quando essa exception acontecer chama o metodo ResourceNotFoundException
	public ResponseEntity<Object> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND; //404
		List<String> errors = List.of(e.getMessage());
		
		return ResponseEntity.status(status).body(new ErrorResponse(System.currentTimeMillis(), status.value(), error, errors, request.getRequestURI()));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> validationError(MethodArgumentNotValidException e, HttpServletRequest request){
		String error = "Erro de validacao";
		HttpStatus status = HttpStatus.BAD_REQUEST; //400
		List<String> errors = new ArrayList<>();
		e.getBindingResult().getFieldErrors().forEach(fieldError -> {
		    errors.add(fieldError.getDefaultMessage());
		});
		
		return ResponseEntity.status(status).body(new ErrorResponse(System.currentTimeMillis(), status.value(), error, errors, request.getRequestURI()));
	}
}