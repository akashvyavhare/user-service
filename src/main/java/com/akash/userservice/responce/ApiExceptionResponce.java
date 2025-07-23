package com.akash.userservice.responce;

import org.springframework.http.HttpStatus;


public class ApiExceptionResponce {
	
	private String message;
	
	private boolean success;
	
	private HttpStatus status;

	
	private ApiExceptionResponce(){
		
	}
	
	private ApiExceptionResponce(ApiExceptionResponceBuilder builder)
	{
		this.message=builder.message;
		this.success=builder.success;
		this.status=builder.status;
	}
	
	
	public String getMessage() {
		return message;
	}

	public boolean isSuccess() {
		return success;
	}

	public HttpStatus getStatus() {
		return status;
	}
	
	
	
	public static  class ApiExceptionResponceBuilder{
		
		private String message;
		
		private boolean success;
		
		private HttpStatus status;
		
		

		public ApiExceptionResponceBuilder setMessage(String message) {
			this.message = message;
			return this;
		}

		public ApiExceptionResponceBuilder setSuccess(boolean success) {
			this.success = success;
			return this;
		}

		public ApiExceptionResponceBuilder setStatus(HttpStatus status) {
			this.status = status;
			return this;
		}
		
		public ApiExceptionResponce build() {
			return new ApiExceptionResponce(this);
		}
		
	}
	
	
	
	
}
