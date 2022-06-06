package com.naffal.ims.exception;

//Generic exception class for all RESTful services

public class ExceptionResponse {
	
	private String timeStamp; 
	private String message; 
	private String detail;
	
	public ExceptionResponse(String timeStamp, String message, String detail) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.detail = detail;
	} 
	
}
