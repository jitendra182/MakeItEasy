package io.javaheart.makeiteasy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import io.javaheart.makeiteasy.exception.ServiceProviderNotFound;
import io.javaheart.makeiteasy.exception.UserNotFound;
import io.javaheart.makeiteasy.model.Address;
import io.javaheart.makeiteasy.model.Admin;
import io.javaheart.makeiteasy.model.ConfirmedOrderDetails;
import io.javaheart.makeiteasy.model.ContactUs;
import io.javaheart.makeiteasy.model.ContactUsReply;
import io.javaheart.makeiteasy.model.Customer;
import io.javaheart.makeiteasy.model.ItemList;
import io.javaheart.makeiteasy.model.ServiceProvider;
import io.javaheart.makeiteasy.model.TempOrderDetails;
import io.javaheart.makeiteasy.repository.AddressRepo;
import io.javaheart.makeiteasy.repository.AdminRepo;
import io.javaheart.makeiteasy.repository.ConfirmedOrderDetailsRepo;
import io.javaheart.makeiteasy.repository.ContactUsReplyRepo;
import io.javaheart.makeiteasy.repository.ContactUsRepo;
import io.javaheart.makeiteasy.repository.CustomerRepo;
import io.javaheart.makeiteasy.repository.ItemListRepo;
import io.javaheart.makeiteasy.repository.ServiceProviderRepo;
import io.javaheart.makeiteasy.repository.TempOrderDetailsRepo;

@Service
public class AdminService {

	@Autowired
	private AdminRepo adminRepo;
	@Autowired
	private ContactUsRepo contactUsRepo;
	@Autowired
	private ServiceProviderRepo serviceProviderRepo;
	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private TempOrderDetailsRepo tempOrderDetailsRepo;
	@Autowired
	private ConfirmedOrderDetailsRepo confirmedOrderDetailsRepo;
	@Autowired 
	private AddressRepo  addressRepo;
	@Autowired
	private ItemListRepo itemListRepo;
	@Autowired
	private ContactUsReplyRepo contactUsReplyRepo; 

	// This is for verify Login
	public Admin verifyLogin(String userId, String password) 
	{
		Admin adm=adminRepo.findByUserIdAndPassword(userId, password);
		return adm;
	}
	 		 
	 
	//This is for get all the ServiceProvider List
	@Cacheable("service-provider-List")
	public List<ServiceProvider> getAllServiceProvider()
	{
		return serviceProviderRepo.findAll();
	}
	
	// This is to  get all the list of customer
	@Cacheable("customer-list")
	public List<Customer> getAllCustomer()
	{
		return customerRepo.findAll();
	}
	
	//This is to get contact us messages
	@Cacheable("contact-messages")
	public List<ContactUs> getContactMessage() 
	{
		return contactUsRepo.findAll();
	}
	
	//This is to get one Service Provider
	public ServiceProvider getOneServiceProvider(String id)
	{
		Optional<ServiceProvider> found = serviceProviderRepo.findById(id);
//		ServiceProvider sp = found.orElseGet(() -> new ServiceProvider());
		ServiceProvider sp = found.orElseThrow(()-> new ServiceProviderNotFound("No Service Provider Found"));
		return sp;
	}
	
	//This is to get one Customer
	public Customer getOneCustomer(String id)
	{
		Optional<Customer> found = customerRepo.findById(id);
	    Customer cu = found.orElseThrow(() -> new UserNotFound("No User Found"));
	    return cu;
	}
	
	//This is to get all order request
	public List<TempOrderDetails> getOrderRequest()
	{
		return tempOrderDetailsRepo.findAll();
	}
	
	//This is to get all confirmed order
	public List<ConfirmedOrderDetails> getServiceCompleted()
	{
		return confirmedOrderDetailsRepo.findAll();
	}
	
	//This is to get address
	public Address getAddress(String houseno)
	{
		Optional<Address> found = addressRepo.findById(houseno);
		Address address = found.orElseGet(() -> new Address());
		return address;
	}
	
	//This is to get Item List
	public List<ItemList> getItemList(Long orderId)
	{
	  return itemListRepo.findAllByOrderId(orderId);
	}
	
	//This is to save reply
	public void saveReply(ContactUsReply cr)
	{
		contactUsReplyRepo.save(cr);
	}
	
}
