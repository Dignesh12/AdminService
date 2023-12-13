package com.example.exceptionhandler;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleInvalidException(MethodArgumentNotValidException ex)
	{
		Map<String, String> errormap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> 
		{
			errormap.put(error.getField(), error.getDefaultMessage());
		});
		
		return new ResponseEntity<>(errormap,HttpStatus.BAD_REQUEST);
	}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value=IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex)
	{
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
