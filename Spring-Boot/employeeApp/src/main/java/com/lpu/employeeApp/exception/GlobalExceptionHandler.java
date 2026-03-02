package com.lpu.employeeApp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ArithmeticException.class)
	public Map<String, String> getArithmeticEx(ArithmeticException ex) {
		Map<String,String> map = new HashMap<>();
		map.put("Error", ex.getMessage());
		return map;
	}
	@ExceptionHandler(CompanyNotFoundException.class)
	public ResponseEntity<Map<String,String>> getCompanyNotFound(CompanyNotFoundException ex){
		Map<String,String> map = new HashMap<>();
		map.put("Error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Map<String,String>> getEmployeeNotFound(EmployeeNotFoundException ex){
		Map<String,String> map = new HashMap<>();
		map.put("Error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> getMethodValidationException(MethodArgumentNotValidException ex){
		Map<String,String> map = new HashMap<>();
		ex.getBindingResult()
		.getFieldErrors()
		.forEach(error -> map.put(error.getField(), error.getDefaultMessage()));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	//it will handle all the exception above not mentioned
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String,String>> getException(Exception ex){
		Map<String,String> map = new HashMap<>();
		map.put("Error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
	}
}
