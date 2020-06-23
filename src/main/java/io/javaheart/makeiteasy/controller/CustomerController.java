package io.javaheart.makeiteasy.controller;

import java.util.ArrayList;
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
import io.javaheart.makeiteasy.model.ConfirmedOrderDetails;
import io.javaheart.makeiteasy.model.Customer;
import io.javaheart.makeiteasy.model.ItemList;
import io.javaheart.makeiteasy.model.Price;
import io.javaheart.makeiteasy.model.SecurityQuestion;
import io.javaheart.makeiteasy.model.TempOrderDetails;
import io.javaheart.makeiteasy.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	List<ItemList> il=new ArrayList<>();
	Long orderId=(long) 0;

	// This is for Homepage
	@GetMapping("")
	public ModelAndView home(HttpSession sess) 
	{
		ModelAndView mv=new ModelAndView("customer/customerHome");
		Customer cus=(Customer) sess.getAttribute("customer");
		if (cus == null) 
		{
			mv.setViewName("customer/customer");
		}
		else
		{
			mv.addObject("itemList",il);
		}
		return mv;
	}

	// To get Registration Form
	@GetMapping("/registration")
	public String GetRegistrationForm() 
	{

		return "customer/customerRegister";
	}

	// This is for Registration page
	@PostMapping("/registration")
	public RedirectView registration(@ModelAttribute("Customer") Customer customer, HttpSession sess, RedirectAttributes attr) 
	{
		boolean data=customerService.registerUser(customer);
		if(data)
		{
			sess.setAttribute("customer", customer);
			String msg="Register Successfull";
			attr.addFlashAttribute("registerStatus", msg);
			return new RedirectView("/customer");
		}
		else
		{
			attr.addFlashAttribute("registerStatus", "UserId alreday exist");
			return new RedirectView("registration");
		}
	}
	
	// This is for login
	@PostMapping("/login")
	public RedirectView login(HttpSession sess, @RequestParam("userId") String userid,
			@RequestParam("passwd") String passwd, RedirectAttributes attr) 
	{
		Customer customer = customerService.verifyLogin(userid, passwd);
		if (customer != null)
		{
			sess.setAttribute("customer", customer);
			sess.setMaxInactiveInterval(0);
		}
		else
		{
			String message = "Invalid Id or Password";
			attr.addFlashAttribute("msg", message);//m.addAttribute("msg", message);
		}
		return new RedirectView("/customer");
	}


	// This is for Logout
	@GetMapping("/logout")
	public String logout(HttpSession sess) {
		sess.invalidate();
		il=null;
		return "redirect:/customer";

	}

	// This is for getting profile page
	@GetMapping("/profile")
	public ModelAndView profile(HttpSession sess) {
		ModelAndView mv = new ModelAndView("customer/customerProfile");
		Customer cus=(Customer) sess.getAttribute("customer");
		if (cus == null) 
		{
			mv.setViewName("customer/customer");
			return mv;
		}
		else
		{
			mv.setViewName("customer/customerProfile");
		}
		return mv;
	}
	
	//This is to get Edit Profile page
	@GetMapping("/edit-profile")
	public String editProfile(HttpSession sess) 
	{
		Customer cus=(Customer) sess.getAttribute("customer");
		if (cus == null) 
		{
			return "redirect:/customer";			
		}
		else
		{
			return "/customer/profileEdit";
		}
	}
	//This is for update profile
	@PostMapping("/update-profile")
	public RedirectView updateProfile(@ModelAttribute("Customer") Customer cu,HttpSession sess,RedirectAttributes attr) 
	{
		Customer cus=(Customer) sess.getAttribute("customer");
		if (cus == null) 
		{
			return new RedirectView("/customer");			
		}
		else
		{
			boolean updated=customerService.updateProfile(cu);
			String msg=null;
			if(updated)
			{
				sess.setAttribute("customer", cu);
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
	
	// This is for getting order history
	@GetMapping("/customer-order-request")
	public ModelAndView orderRequest(HttpSession sess) {
		ModelAndView mv = new ModelAndView("customer/customerOrderHistory");
		Customer cus=(Customer) sess.getAttribute("customer");
		if (cus == null) 
		{
			mv.setViewName("customer/customer");
		}
		else
		{
			Customer customer=(Customer) sess.getAttribute("customer");
			String id=customer.getUserId();
			List<TempOrderDetails> orders=customerService.myOrders(id);
			mv.addObject("myOrders", orders);
		}
		return mv;
	}
	
	// This is for getting order history
	@GetMapping("/customer-order-history")
	public ModelAndView orderHistory(HttpSession sess) {
		ModelAndView mv = new ModelAndView("customer/myOrderCompleted");
		Customer cus=(Customer) sess.getAttribute("customer");
		if (cus == null) 
		{
			mv.setViewName("customer/customer");
		}
		else
		{
			String id=cus.getUserId();
			List<ConfirmedOrderDetails> orders=customerService.myConfirmOrders(id);
			mv.addObject("myOrders", orders);
		}
		return mv;
	}

	// This is for get the Security Question page
	@GetMapping("/security-qus")
	public ModelAndView getSecurityQues(HttpSession sess) {
		ModelAndView mv = new ModelAndView("customer/securityQuestion");
		Customer cus=(Customer) sess.getAttribute("customer");
		if (cus == null)
		{
			mv.setViewName("customer/customer");
			return mv;
		}
		else
		{
			return mv;
		}
	}

	// This is for Save/Update security Question
	@PostMapping("/security-qus")
	public RedirectView saveSecurityQues(@ModelAttribute("SecurityQuestion") SecurityQuestion security,HttpSession sess, RedirectAttributes attr) 
	{
		Customer cus=(Customer) sess.getAttribute("customer");
		if (cus == null)
		{
			return new RedirectView("/customer");
		}
		else
		{
			customerService.saveSecurity(security);
			String msg="Security Question Update";
			attr.addFlashAttribute("status", msg);
			return new RedirectView("security-qus");
		}
	}

	// This is to get Change Password page
	@GetMapping("/change-pass")
	public ModelAndView getChangePass(HttpSession sess) {
		ModelAndView mv = new ModelAndView("customer/changePass");
		Customer cus=(Customer) sess.getAttribute("customer");
		if (cus == null)
		{
			mv.setViewName("customer/customer");
			return mv;
		}
		else
		{
			return mv;
		}
	}

	// This is for save Change Password
	@PostMapping("/change-pass")
	public RedirectView saveChangePass(@RequestParam("myid") String userId,@RequestParam("pass") String pass,HttpSession sess, RedirectAttributes attr)
	{
		Customer cus=(Customer) sess.getAttribute("customer");
		if (cus == null)
		{
			return new RedirectView("/customer");
		}
		else
		{
			
			Customer cu=customerService.getCustomer(userId);
			cu.setPassword(pass);
			customerService.updatePass(cu);
			String msg ="Password Change Successfully";
			attr.addFlashAttribute("status", msg);
			return new RedirectView("change-pass");
		}
	}
	
	//This is for forgot password page
	@GetMapping("/forgot-pass")
	public String forgotPass() 
	{
		return "/customer/forgotPassword";
	}
	
	//This is to reset password
	@PostMapping("/valid-security-pass")
	public ModelAndView checkValid(@RequestParam("userId") String userId,@RequestParam("question") String question,@RequestParam("ans") String ans,
			@RequestParam("pass") String pass,HttpSession sess) 
	{
		try {
		ModelAndView mv=new ModelAndView("/customer/forgotPassword");
		boolean val=customerService.checkSecurityAns(userId,question,ans);
		String msg;
		if(val)
		{
			Customer cu=customerService.getCustomer(userId);
			cu.setPassword(pass);
			customerService.updatePass(cu);
			msg ="Password Change Successfully please login";
			mv.setViewName("/customer/customer");
		}
		else
		{
			msg="Invalid data";
		}
		
		mv.addObject("status", msg);	
		return mv;
		}
		catch(RuntimeException ex) {
			return new ModelAndView("customer/error");
		}
	}
	
	//This is for add orderItem list
	@PostMapping("/add-item")
	public RedirectView addItem(@ModelAttribute("ItemList") ItemList itmList,Model m,HttpSession sess)
	{
		Customer cus=(Customer) sess.getAttribute("customer");
		if (cus == null) 
		{
			return new RedirectView("/customer");
		}
		else
		{	
			Long val=customerService.getMaxOrderId();
			if(val == null) {
				orderId=(long) 1;
			}
			else 
			{
			    System.out.print(orderId);
				orderId=val+1;
			}
			itmList.setOrderId(orderId);
			
			il.add(itmList);
			m.addAttribute("itemList", il);
			return new RedirectView("/customer");
			
		}
	}
	
	@GetMapping("delete-item/{id}")
	public String deleteItem(@PathVariable String id,Model m,HttpSession sess)
	{
		Customer cus=(Customer) sess.getAttribute("customer");
		if (cus == null) 
		{
			return "redirect:customer/customer";
		}
		else
		{	
			int idd=Integer.parseInt(id);
			il.remove(idd);
			m.addAttribute("itemList",il);
			return "redirect:/customer";
			
		}
	}
	
	@PostMapping("/submit-order")
	public RedirectView submitOrder(@ModelAttribute("Address") Address address,Model m,@RequestParam("serviceType") String serviceType,
			@RequestParam("dateOfService") String dateOfService,@RequestParam("addressHouseNo") String addressHouseNo,
			@RequestParam("userId") String userId,@RequestParam("dhouseNo") String dhouseNo,
			@RequestParam("dapartmentOrHomeName") String daddressHouseNo,@RequestParam("ddistrict") String ddistrict,
			@RequestParam("dstate") String dstate,@RequestParam("dcityName") String dcityName,
			@RequestParam("dpoliceStation")String dpoliceStation,@RequestParam("dlandmark")String dlandMark,
			@RequestParam("dpin")int dpin, HttpSession sess,RedirectAttributes attr)
	{
		Customer cus=(Customer) sess.getAttribute("customer");
		if (cus == null) 
		{
			return new RedirectView("customer");
		}
		else
		{	
			for(int i=0;i<il.size();i++)
			{
				customerService.addItem(il.get(i));
			}
			Address dadd=new Address();
			dadd.setHouseNo(dhouseNo);
			dadd.setApartmentOrHomeName(daddressHouseNo);
			dadd.setDistrict(ddistrict);
			dadd.setState(dstate);
			dadd.setCityName(dcityName);
			dadd.setPoliceStation(dpoliceStation);
			dadd.setLandMark(dlandMark);
			dadd.setPin(dpin);
			
			customerService.saveAddress(address);
			customerService.saveAddress(dadd);
			
			TempOrderDetails tdo=new TempOrderDetails();
			tdo.setOrderId(orderId);
			tdo.setServiceType(serviceType);
			tdo.setSourceAddHouseNo(address.getHouseNo());
			tdo.setDestAddHouseNo(dhouseNo);
			tdo.setUserId(userId);
			tdo.setDateOfService(dateOfService);
			String msg=customerService.saveOrderRequest(tdo);
			attr.addFlashAttribute("status", msg);
			il.clear();
			return new RedirectView("/customer");
			
		}
		
	}
	//This is to get address
	@GetMapping("/address")
	public String getAddress(@RequestParam String shno,@RequestParam String dhno,Model m,HttpSession sess)
	{
		Customer cus=(Customer) sess.getAttribute("customer");
		if (cus == null) 
		{
			return "redirect:/customer";
		}
		else
		{
			Address source=customerService.getAddress(shno);
			Address destination=customerService.getAddress(dhno);
			m.addAttribute("source", source);
			m.addAttribute("dest", destination);
			
			return "customer/address";
		}
	}
	
	//This is to get Item List
	@GetMapping("/itemlist/{orderid}")
	public String getItemList(@PathVariable Long orderid,Model m,HttpSession sess)
	{
		Customer cus=(Customer) sess.getAttribute("customer");
		if (cus == null) 
		{
			return "redirect:/customer";
		}
		else
		{
			List<ItemList> itmList=customerService.getItemList(orderid);
			m.addAttribute("itemList", itmList);
			return "customer/itemList";
		}
	}
	
	//This is to get Price List
	@GetMapping("/priceList/{orderId}")
	public String getPrices(@PathVariable Long orderId,Model m,HttpSession sess)
	{
		Customer cus=(Customer) sess.getAttribute("customer");
		if (cus == null) 
		{
			return "redirect:/customer";
		}
		else
		{
			List<Price> priceList=customerService.getPriceList(orderId);
			m.addAttribute("priceList", priceList);
			boolean exist=customerService.checkSubmit(orderId,cus.getUserId());
			if(exist)
			{
				m.addAttribute("exist", "disabled");
			}
			else
			{
				m.addAttribute("exist", "");
			}
			return "customer/priceList";
		}
	}
	
	//This is to get accept order
	@PostMapping("/acceptOrder")
	public RedirectView acceptOrder(@RequestParam("spId") String spId,@RequestParam("price") Double price,
			@RequestParam("orderId") Long orderId,Model m,HttpSession sess)
	{
		Customer cus=(Customer) sess.getAttribute("customer");
		if (cus == null) 
		{
			return new RedirectView("/customer");
		}
		else
		{
			String cid=cus.getUserId();
			String serviceType=customerService.getServiceProviderType(spId);
			//LocalDate date =LocalDate.now();
			
			
			TempOrderDetails td= customerService.findOrderById(orderId);
			
			ConfirmedOrderDetails cos=new ConfirmedOrderDetails();
			cos.setOrderId(orderId);
			cos.setServiceType(serviceType);
			cos.setPrice(price);
			cos.setServiceProviderId(spId);
			cos.setCustomerId(cid);
			cos.setSourceAddHouseNo(td.getSourceAddHouseNo());
			cos.setDestAddHouseNo(td.getSourceAddHouseNo());
			cos.setServiceDate(td.getDateOfService());
			
			customerService.acceptOrder(cos);
			return new RedirectView("customer-order-history");
			
		}
	}
	
	//This is to Delete Request
	@GetMapping("/delete/{orderId}")
	public RedirectView deleteRequest(@PathVariable Long orderId,Model m,HttpSession sess, RedirectAttributes attr)
	{
		Customer cus=(Customer) sess.getAttribute("customer");
		if (cus == null) 
		{
			return new RedirectView("redirect:/customer");
		}
		else
		{
			TempOrderDetails data=customerService.findOrderById(orderId);
			if(data.getOrderId()==null)
			{
				attr.addFlashAttribute("errorCode", "500");
				attr.addFlashAttribute("errorMsg","Order Not Found");
				return new RedirectView("/error");
			}
			else {
				customerService.deleteOrderReq(data);
				
//				Customer customer=(Customer) sess.getAttribute("customer");
//				String id=customer.getUserId();
//				List<TempOrderDetails> orders=customerService.myOrders(id);
//				attr.addFlashAttribute("myOrders", orders);
				return new RedirectView("/customer/customer-order-request");
			}
		}
	}
}
