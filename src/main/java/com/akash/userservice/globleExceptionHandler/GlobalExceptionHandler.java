package com.akash.userservice.globleExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.akash.userservice.Exceptions.UserNotFound;
import com.akash.userservice.responce.ApiExceptionResponce;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<ApiExceptionResponce> userNotFoundException(UserNotFound ex)
	{
		ApiExceptionResponce apiExceptionResponce = new ApiExceptionResponce.ApiExceptionResponceBuilder()
																			.setMessage(ex.getMessage())
																			.setStatus(HttpStatus.NOT_FOUND)
																			.setSuccess(true)
																			.build();
		
		return new  ResponseEntity<ApiExceptionResponce>(apiExceptionResponce,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler()
	public ResponseEntity<ApiExceptionResponce> nullPointerException(NullPointerException ex)
	{
		ApiExceptionResponce responce = new ApiExceptionResponce.ApiExceptionResponceBuilder()
										.setMessage(ex.getMessage())
										.setSuccess(true)
										.setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
										.build();
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responce);
				
	}
	

}
