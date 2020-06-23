package io.javaheart.makeiteasy.exception;

public class UserNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public UserNotFound(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
