package io.javaheart.makeiteasy.exception;

public class AddressNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String message;
	public AddressNotFound(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
