package io.javaheart.makeiteasy.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
import io.javaheart.makeiteasy.model.ConfirmedOrderDetails;
import io.javaheart.makeiteasy.model.ItemList;
import io.javaheart.makeiteasy.model.Price;
import io.javaheart.makeiteasy.model.SecurityQuestion;
import io.javaheart.makeiteasy.model.ServiceProvider;
import io.javaheart.makeiteasy.model.TempOrderDetails;
import io.javaheart.makeiteasy.service.ServiceProviderService;


@Controller
@RequestMapping("/serviceprovider")
public class ServiceProviderController {
	
	@Autowired
	private ServiceProviderService serviceProviderService;
	
	//Service Provider Login Page
	@GetMapping("")
	public ModelAndView home(ModelMap model,HttpSession sess)
	{
		ModelAndView mv=new ModelAndView("serviceprovider/serviceProviderHome");
		ServiceProvider sp=(ServiceProvider) sess.getAttribute("serviceProvider");
		if(sp==null)
		{
			mv.setViewName("serviceprovider/serviceProvider");
		}
		else
		{
			String sType=sp.getServiceProviderType();
			List<TempOrderDetails> orderList=serviceProviderService.getServiceRequest(sType);
			mv.addObject("orders", orderList);
		}
		return mv;
	}
	
	//To get Registration Form
	@GetMapping("/registration")
	public String GetRegistrationForm()
	{
		return "serviceprovider/serviceProviderRegister";
	}
	
	
	//This is for Registration page
	@PostMapping("/registration")
	public RedirectView registration(@ModelAttribute("ServiceProvider") ServiceProvider serviceProvider,HttpSession sess,RedirectAttributes attr) 
	{
		boolean res=serviceProviderService.registerServiceProvider(serviceProvider);
		if(res)
		{
			sess.setAttribute("serviceProvider", serviceProvider);
			attr.addFlashAttribute("registerStatus", "Successfully Registered");
			return new RedirectView ("/serviceprovider");
			
		}
		else
		{
			attr.addFlashAttribute("registerStatus", "UserId alreday exist");
			return new RedirectView("registration");
		}
		
	}
	
	// This is for login
	@PostMapping("/login")
	public RedirectView login(HttpSession sess, @RequestParam("userId") String userid,@RequestParam("passwd") String passwd, RedirectAttributes attr)
	{
		ServiceProvider sp= serviceProviderService.verifyLogin(userid, passwd);
		if (sp != null) {
			sess.setAttribute("serviceProvider", sp);
			//return "redirect:/serviceprovider";
		}

		else {
			String message = "Invalid Id or Password";
			attr.addFlashAttribute("msg", message);
			//m.addAttribute("msg", message);
			//return "serviceprovider/serviceProvider";
		}
		return new RedirectView("/serviceprovider");
	}
	
	// This is for Logout
	@GetMapping("/logout")
	public String logout( HttpSession sess) {
		sess.invalidate();
		return "redirect:/serviceprovider";

	}
	
	//Service Provider profile page
	@GetMapping("/profile")
	public ModelAndView getProfile(HttpSession sess)
	{
		ModelAndView mv = new ModelAndView("serviceprovider/serviceProviderProfile");
		ServiceProvider sp=(ServiceProvider) sess.getAttribute("serviceProvider");
		if(sp==null)
		{
			mv.setViewName("serviceprovider/serviceProvider");
		}
		else 
		{
			mv.setViewName("/serviceprovider/serviceProviderProfile");
		}
		return mv;
	}
	
	//This is to get Edit Profile page
	@GetMapping("/edit-profile")
	public String editProfile(HttpSession sess) 
	{
		ServiceProvider sp=(ServiceProvider) sess.getAttribute("serviceProvider");
		if(sp==null)
		{
			return "redirect:/serviceprovider";			
		}
		else
		{
			return "/serviceprovider/profileEdit";
		}
	}
	//This is for update profile
	@PostMapping("/update-profile")
	public RedirectView saveEditProfile(@ModelAttribute("ServiceProvider") ServiceProvider spp,HttpSession sess,RedirectAttributes attr) 
	{
		ServiceProvider sp=(ServiceProvider) sess.getAttribute("serviceProvider");
		if(sp==null)
		{
			return new RedirectView("/serviceprovider");			
		}
		else
		{
			System.out.println(spp);
			boolean updated=serviceProviderService.updateProfile(spp);
			String msg=null;
			if(updated)
			{
				sess.setAttribute("serviceProvider", spp);
				msg="Profile Updated";
				attr.addFlashAttribute("updateStatus", msg);
				return new RedirectView("profile");
			}
			else
			{
				msg="Profile Not updated";
				attr.addFlashAttribute("updateStatus", msg);
				return new RedirectView("profile");
			}
		}
	}
	
	//History of services of Service Provider 
	@GetMapping("/service-history")
	public ModelAndView getServiceHistory(HttpSession sess)
	{
		ModelAndView mv=new ModelAndView("serviceprovider/serviceProviderServiceHistory");
		ServiceProvider sp=(ServiceProvider) sess.getAttribute("serviceProvider");
		if(sp==null)
		{
			mv.setViewName("serviceprovider/serviceProvider");
		}
		else 
		{
			String id=sp.getUserId();
			List<ConfirmedOrderDetails> cd=serviceProviderService.getServiceHistory(id);
			mv.addObject("myOrders", cd);
		}
		return mv;
	}
	
	//This is for get Security Question page
	@GetMapping("/security-qus")
	public ModelAndView securityQues(HttpSession sess) 
	{
		ModelAndView mv=new ModelAndView("serviceprovider/securityQuestion");
		ServiceProvider sp=(ServiceProvider) sess.getAttribute("serviceProvider");
		if(sp==null)
		{
			mv.setViewName("serviceprovider/serviceProvider");
			return mv;
		}
		else
		{
			return mv;
		}
	}
	
	// This is for Save/Set security Question
	@PostMapping("/security-qus")
	public ModelAndView saveSecurityQues(@ModelAttribute("SecurityQuestion") SecurityQuestion security,HttpSession sess) 
	{
		ModelAndView mv=new ModelAndView("serviceprovider/securityQuestion");
		ServiceProvider sp=(ServiceProvider) sess.getAttribute("serviceProvider");
		if(sp==null)
		{
			mv.setViewName("serviceprovider/serviceProvider");
			return mv;
		}
		else
		{
			serviceProviderService.saveSecurity(security);
			String msg="Security Question Update";
			mv.addObject("status", msg);
			return mv;
		}
	}
	
	//This is for get Change Password page
	@GetMapping("/change-pass")
	public ModelAndView changePass(HttpSession sess) 
	{
		ModelAndView mv=new ModelAndView("serviceprovider/changePass");
		ServiceProvider sp=(ServiceProvider) sess.getAttribute("serviceProvider");
		if(sp==null)
		{
			mv.setViewName("serviceprovider/serviceProvider");
			return mv;
		}
		else
		{
			return mv;
		}
	}
	
	//This is for change password
	@PostMapping("/change-pass")
	public ModelAndView UpdatePass(@RequestParam("myid") String userId,@RequestParam("pass") String pass,HttpSession sess) 
	{
		ModelAndView mv=new ModelAndView("serviceprovider/changePass");
		ServiceProvider sp=(ServiceProvider) sess.getAttribute("serviceProvider");
		if(sp==null)
		{
			mv.setViewName("serviceprovider/serviceProvider");
		}
		else
		{
			ServiceProvider spd=serviceProviderService.getServiceProvider(userId);
			spd.setPassword(pass);
			serviceProviderService.updatePassword(spd);
			String msg ="Password Change Successfully";
			mv.addObject("status", msg);
		}
		return mv;
	}
	
	//This is for forgot password page
	@GetMapping("/forgot-pass")
	public String forgotPass() 
	{
		return "/serviceprovider/forgotPassword";
	}
		
	//This is to reset password
	@PostMapping("/valid-security-pass")
	public ModelAndView checkValid(@RequestParam("userId") String userId,@RequestParam("question") String question,@RequestParam("ans") String ans,@RequestParam("pass") String pass) 
	{
		ModelAndView mv=new ModelAndView("/serviceprovider/forgotPassword");
		boolean val=serviceProviderService.checkSecurityAns(userId,question,ans);
		String msg;
		if(val)
		{
			ServiceProvider sp=serviceProviderService.getServiceProvider(userId);
			sp.setPassword(pass);
			serviceProviderService.updatePassword(sp);
			msg ="Password Change Successfully please login";
			mv.setViewName("/serviceprovider/serviceProvider");
		}
		else
		{
			msg="Invalid data";
		}		
		mv.addObject("status", msg);	
		return mv;
	}
	
	//This is to get address
	@GetMapping("/address")
	public String getAddress(@RequestParam String shno,@RequestParam String dhno,Model m,HttpSession sess)
	{
		ServiceProvider sp=(ServiceProvider) sess.getAttribute("serviceProvider");
		if(sp==null)
		{
			return "redirect:/serviceprovider";
		}
		else
		{
			Address source=serviceProviderService.getAddress(shno);
			Address destination=serviceProviderService.getAddress(dhno);
			m.addAttribute("source", source);
			m.addAttribute("dest", destination);
			return "serviceprovider/address";
		}

	}
	
	//This is to get Item List
	@GetMapping("/itemlist/{orderid}")
	public String getItemList(@PathVariable Long orderid,Model m,HttpSession sess)
	{
		ServiceProvider sp=(ServiceProvider) sess.getAttribute("serviceProvider");
		if(sp==null)
		{
			return "redirect:/serviceprovider";
		}
		else
		{
			List<ItemList> itmList=serviceProviderService.getItemList(orderid);
			m.addAttribute("itemList", itmList);
			return "serviceprovider/itemList";
		}

	}
	
	//This is to set price
	@PostMapping("/submit-price")
	public RedirectView setprice(@ModelAttribute("Price") Price myPrice,RedirectAttributes attr,HttpSession sess)
	{
		ServiceProvider sp=(ServiceProvider) sess.getAttribute("serviceProvider");
		if(sp==null)
		{
			return new RedirectView("/serviceprovider");
		}
		else
		{
			serviceProviderService.setPrice(myPrice);
			//m.addAttribute("priceSet","PriceSet Successfully for OrderId"+myPrice.getOrderId());
			String msg="PriceSet Successfully for OrderId "+myPrice.getOrderId();
			attr.addFlashAttribute("priceSet", msg);
			//List<Price> prices=serviceProviderService.getAllPrice();
			//m.addAttribute("priceList", prices);
			return new RedirectView("/serviceprovider");
		}
	}
}
