package com.spring.practice.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.practice.responce.ApiResponce;

    
@RestControllerAdvice
public class GlobalExceptionHandler {

		@ExceptionHandler(ResourceNotFoundException.class)
		public ResponseEntity<ApiResponce> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
			String message = ex.getMessage();	
			ApiResponce apiResponce = new ApiResponce(message, false);
			return new ResponseEntity<ApiResponce>(apiResponce, HttpStatus.NOT_FOUND);
		}
//		@ExceptionHandler(MethodArgumentNotValidException.class)
//		public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex) {
//			
//		}
}
