package io.javaheart.makeiteasy.exception;

public class ServiceProviderNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public ServiceProviderNotFound(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
