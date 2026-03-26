package projetos.springBoot.taskList.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice //intercepta os erros do controller
public class ResourceExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class) //quando essa exception acontecer chama o metodo ResourceNotFoundException
	public ResponseEntity<Object> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND; //404
		return ResponseEntity.status(status).body(new ErrorResponse(System.currentTimeMillis(), status.value(), error, e.getMessage(), request.getRequestURI()));
	}
}