package com.insurance.policy.management.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler({ CustomerNotFoundException.class, PolicyNotFoundException.class })
	public ResponseEntity<Map<String, Object>> handleNotFound(RuntimeException ex, HttpServletRequest request) { 
																												
																												
		return buildErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex,
			HttpServletRequest request) { // [cite: 130]
		String errorMsg = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
		return buildErrorResponse(HttpStatus.BAD_REQUEST, errorMsg, request.getRequestURI());
	}

	private ResponseEntity<Map<String, Object>> buildErrorResponse(HttpStatus status, String error, String path) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("status", status.value());
		body.put("error", error);
		body.put("path", path);
		return new ResponseEntity<>(body, status);
	}
}
