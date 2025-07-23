package com.akash.userservice.Exceptions;

public class UserNotFound extends RuntimeException{
	
	public UserNotFound(){
		super("User Not Found...!");
	}
	
	public UserNotFound(String massage)
	{
		super(massage);
	}

}
