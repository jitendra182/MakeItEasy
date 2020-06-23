package io.javaheart.makeiteasy.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomeExceptionController {

	@ExceptionHandler(ServiceProviderNotFound.class)
	public String serviceProviderNotFound(ServiceProviderNotFound ex,Model m) {
		m.addAttribute("notFound", ex.getMessage());
		m.addAttribute("link", "/admin/service-provider-list");
		return "notFound";
	}
	
	@ExceptionHandler(UserNotFound.class)
	public String userNotFound(UserNotFound ex,Model m) {
		m.addAttribute("notFound", ex.getMessage());
		m.addAttribute("link","/admin/customers-list");
		return "notFound";
	}
	
	@ExceptionHandler(AddressNotFound.class)
	public String addressNotFound(AddressNotFound ex,Model m) {
		m.addAttribute("notFound", ex.getMessage());
		m.addAttribute("link", "/customer/customer-order-request");
		return "notFound";
	}
	
	@ExceptionHandler(Exception.class)
	public String myException() {
		return null;
		
	}
}
