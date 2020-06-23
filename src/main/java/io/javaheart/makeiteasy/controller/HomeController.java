package io.javaheart.makeiteasy.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import io.javaheart.makeiteasy.model.ContactUs;
import io.javaheart.makeiteasy.service.ContactUsService;
import io.javaheart.makeiteasy.service.ServiceProviderService;


@Controller
@RequestMapping("/")
public class HomeController { //implements ErrorController{
	
	@Autowired
	private ContactUsService contactUsService;
	@Autowired
	private ServiceProviderService serviceProviderService;
	
	@GetMapping("")
	public String index()
	{
		return "index";
	}
	
	@GetMapping("/aboutUs")
	public String aboutUs()
	{
		return "aboutUs";
	}
	
	@GetMapping("/contactUs")
	public String contactUs()
	{
		return "contactUs";
	}
	
	
	@PostMapping("/contact")
	public RedirectView contact(@ModelAttribute("ContactUs") ContactUs cu,RedirectAttributes attr)
	{
		LocalDate date =LocalDate.now();
		cu.setDate(date.toString());
		contactUsService.save(cu);
		//ModelAndView mv=new ModelAndView("contactUs");
		//mv.addObject("msg","Message Sent");
		String data="Message Sent";
		attr.addFlashAttribute("msg", data);
		return new RedirectView("/contactUs");
		
	}

	@GetMapping("/error")
	public String handleError(Model m )
	{
		m.addAttribute("errorCode",404);
		m.addAttribute("errorMsg","Page Not Found");
		return "myError";
	}	
	
//	@Override
//	public String getErrorPath() {
//		return "/error";
//	}
	
//	@GetMapping("/error")
//	public String errorPage()
//	{
//		return "myError";
//	}
	
//	@PostMapping("/contact")
//	public String contact(@ModelAttribute("ContactUs") ContactUs cu,Model m)
//	{
//		LocalDate date =LocalDate.now();
//		cu.setDate(date.toString());
//		contactUsService.save(cu);
//		m.addAttribute("msg","Message Sent");
//		return "redirect:/contactUs";
//		
//	}
	
//	@GetMapping("/task/{id}")
//	public ModelAndView task(@PathVariable String id)
//	{
//		ModelAndView mv=new ModelAndView("admin/myList");
//		ServiceProvider serviceProviders= serviceProviderService.getServiceProvider(id);
//		mv.addObject("sp",serviceProviders);
//		return mv;
//		
//	}

	
}
