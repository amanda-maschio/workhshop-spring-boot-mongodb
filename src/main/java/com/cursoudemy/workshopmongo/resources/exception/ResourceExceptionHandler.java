package com.cursoudemy.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cursoudemy.workshopmongo.services.exception.ObjectNotFoundException;

//Indica que a classe é responsável por tratar possíveis erros em requisições HTTP
@ControllerAdvice
public class ResourceExceptionHandler {
	
	/**
	 * Tratamento personalizado para Resource not found (404)
	 * @param e
	 * @param request
	 * @return
	 */
	//Anotação para que o método seja capaz de interceptar a requisição com exceção
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
}
