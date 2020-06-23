package io.javaheart.makeiteasy.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import io.javaheart.makeiteasy.model.Address;
import io.javaheart.makeiteasy.model.Admin;
import io.javaheart.makeiteasy.model.ConfirmedOrderDetails;
import io.javaheart.makeiteasy.model.ContactUs;
import io.javaheart.makeiteasy.model.ContactUsReply;
import io.javaheart.makeiteasy.model.Customer;
import io.javaheart.makeiteasy.model.ItemList;
import io.javaheart.makeiteasy.model.ServiceProvider;
import io.javaheart.makeiteasy.model.TempOrderDetails;
import io.javaheart.makeiteasy.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired
	private AdminService adminService;	
	
	
	//This is for home page of Admin
	@GetMapping("")
	public ModelAndView home(HttpSession sess)
	{
		ModelAndView mv=new ModelAndView("admin/admin");
		Admin adm=(Admin) sess.getAttribute("admin");
		if(adm==null)
		{
			return mv;
		}
		else
		{
			List<ContactUs> msg=adminService.getContactMessage();
			mv.addObject("contactUs",msg);
			mv.setViewName("admin/adminHome");
			return mv;
		}
	}
	
	
	//This is for login
//	@PostMapping("/login")
//	public ModelAndView login(HttpSession sess,@RequestParam("userId") String userid, @RequestParam("passwd") String passwd)
//	{
//		Admin adm=adminService.verifyLogin(userid,passwd);
//		ModelAndView mv=new ModelAndView("admin/adminHome");
//		if(adm!=null)
//		{
//			sess.setAttribute("admin", adm);
//			mv.addObject("admin", adm);
//			List<ContactUs> msg=adminService.getContactMessage();
//			mv.addObject("contactUs",msg);
//			
//		}
//		
//		else
//		{
//			 String message="Invalid Id or Password";
//			 mv.setViewName("admin/admin");
//			 mv.addObject("msg",message);
//		}
//		return mv;
//	}
	
	//This is for login
		@PostMapping("/login")
		public RedirectView login(HttpSession sess,@RequestParam("userId") String userid, @RequestParam("passwd") String passwd, Model m,RedirectAttributes attr)
		{
			Admin adm=adminService.verifyLogin(userid,passwd);
			//ModelAndView mv=new ModelAndView("redirect:/admin");
			if(adm!=null)
			{
				sess.setAttribute("admin", adm);
				m.addAttribute("admin", adm);//m.addAttribute("admin", adm);
				List<ContactUs> msg=adminService.getContactMessage();
				m.addAttribute("contactUs",msg);
				return new RedirectView("/admin");
				
			}
			
			else
			{
				 String message="Invalid Id or Password";
				 attr.addFlashAttribute("msg", message);//mv.setViewName("redirect:/admin");
				 //m.addAttribute("msg",message);
				 return new RedirectView("/admin");
			}
			//return mv;
		}
	
	//This is for Logout
	@GetMapping("/logout")
	public String logout(HttpSession sess)
	{
		sess.invalidate();
		return "redirect:/admin";
		
	}
		
	
	//This is to get all service provider list
	@GetMapping("/service-provider-list")
	public ModelAndView getServiceProviderList(HttpSession sess)
	{
		Admin adm=(Admin) sess.getAttribute("admin");
		if(adm==null)
		{
			ModelAndView mv=new ModelAndView("admin/admin");
			return mv;
		}
		else
		{
			ModelAndView mv=new ModelAndView("admin/serviceProviderList");
			List<ServiceProvider> sp= adminService.getAllServiceProvider();
			mv.addObject("sp",sp);
			return mv;
		}
	}
	
	
	//This is to get all users
	@GetMapping("/customers-list")
	public ModelAndView getCustomerData(HttpSession sess)
	{
		Admin adm=(Admin) sess.getAttribute("admin");
		if(adm==null)
		{
			ModelAndView mv=new ModelAndView("admin/admin");
			return mv;
		}
		ModelAndView mv=new ModelAndView("admin/customerList");
		List<Customer> customers=adminService.getAllCustomer();
		mv.addObject("customers", customers);
		return mv;
	}
	
	//This is to get all orders request
	@GetMapping("/order-request")
	public ModelAndView getOrderRequest(HttpSession sess)
	{
		ModelAndView mv=new ModelAndView("admin/orderRequest");
		Admin adm=(Admin) sess.getAttribute("admin");
		if(adm==null) 
		{
			mv.setViewName("admin/admin");
		}
		else
		{
			List<TempOrderDetails> orderList=adminService.getOrderRequest();
			mv.addObject("orders", orderList);
		}
		return mv;
	}
	
	//This is to get all service completed
	@GetMapping("/service-completed")
	public ModelAndView getServiceCompleted(HttpSession sess)
	{
		ModelAndView mv=new ModelAndView("admin/servicesCompleted");
		Admin adm=(Admin) sess.getAttribute("admin");
		if(adm==null)
		{
			mv.setViewName("admin/admin");
			return mv;
		}
		List<ConfirmedOrderDetails> cOrder=adminService.getServiceCompleted();
		mv.addObject("cnfOrder", cOrder);
		return mv;
	}
	 
	//View Profile of a particular Service Provider
	@GetMapping("/sp-details")
	public ModelAndView getSpDetails(@RequestParam String id,HttpSession sess)
	{
		Admin adm=(Admin) sess.getAttribute("admin");
		if(adm==null)
		{
			ModelAndView mv=new ModelAndView("admin/admin");
			return mv;
		}
		ModelAndView mv=new ModelAndView("admin/serviceProviderDetails");
		ServiceProvider sp=adminService.getOneServiceProvider(id);
		mv.addObject("spdata", sp);
		return mv;
	}
	
	//View Profile of a particular Customer
	@GetMapping("/cu-details")
	public ModelAndView getCuDetails(@RequestParam String id,HttpSession sess)
	{
		Admin adm=(Admin) sess.getAttribute("admin");
		if(adm==null)
		{
			ModelAndView mv=new ModelAndView("admin/admin");
			return mv;
		}
		ModelAndView mv=new ModelAndView("admin/customerDetails");
		Customer c=adminService.getOneCustomer(id);
		mv.addObject("cdata", c);
		return mv;
	}
	
	//This is to get address
	@GetMapping("/address")
	public String getAddress(@RequestParam String shno,@RequestParam String dhno,Model m,HttpSession sess)
	{
		Admin adm=(Admin) sess.getAttribute("admin");
		if(adm==null)
		{
			return "redirect:/admin";
		}
		else
		{
			Address source=adminService.getAddress(shno);
			Address destination=adminService.getAddress(dhno);
			m.addAttribute("source", source);
			m.addAttribute("dest", destination);
			return "admin/address";
		}
	}
		
	//This is to get Item List
	@GetMapping("/itemlist/{orderid}")
	public String getItemList(@PathVariable Long orderid,Model m,HttpSession sess)
	{
		Admin adm=(Admin) sess.getAttribute("admin");
		if(adm==null)
		{
			return "redirect:/admin";
		}
		else
		{
			List<ItemList> itmList=adminService.getItemList(orderid);
			m.addAttribute("itemList", itmList);
			return "admin/itemList";
		}
	}
	
	//This is to send Reply of contact us
	@PostMapping("/reply")
	public String replyContactus(@ModelAttribute("ContactUsReply") ContactUsReply cr,HttpSession sess)
	{
		Admin adm=(Admin) sess.getAttribute("admin");
		if(adm==null)
		{
			return "redirect:/admin";
		}
		else
		{
			adminService.saveReply(cr);
			//adminService.deleteContactUs();
			return "redirect:/admin";
		}
	}
}
