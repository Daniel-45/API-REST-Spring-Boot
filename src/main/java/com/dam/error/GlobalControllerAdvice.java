package com.dam.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * Clase GlobalControllerAdvice que extiende de ResponseEntityExceptionHandler.
 * Sirve para proporcionar un manejo centralizado de excepciones en todos los métodos .
 * 
 * @author Daniel Versión 1.0
 *
 */

@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductoNotFoundException.class)
	public ResponseEntity<ApiError> handleProductoNoEncontrado(ProductoNotFoundException ex) {

		ApiError error = new ApiError(HttpStatus.NOT_FOUND, LocalDateTime.now(), ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		ApiError error = new ApiError(status, LocalDateTime.now(), ex.getMessage());

		return ResponseEntity.status(status).headers(headers).body(error);
	}

}
