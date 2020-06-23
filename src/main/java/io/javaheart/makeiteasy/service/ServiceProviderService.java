package io.javaheart.makeiteasy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import io.javaheart.makeiteasy.exception.AddressNotFound;
import io.javaheart.makeiteasy.model.Address;
import io.javaheart.makeiteasy.model.ConfirmedOrderDetails;
import io.javaheart.makeiteasy.model.ItemList;
import io.javaheart.makeiteasy.model.Price;
import io.javaheart.makeiteasy.model.SecurityQuestion;
import io.javaheart.makeiteasy.model.ServiceProvider;
import io.javaheart.makeiteasy.model.TempOrderDetails;
import io.javaheart.makeiteasy.repository.AddressRepo;
import io.javaheart.makeiteasy.repository.ConfirmedOrderDetailsRepo;
import io.javaheart.makeiteasy.repository.ItemListRepo;
import io.javaheart.makeiteasy.repository.PriceRepo;
import io.javaheart.makeiteasy.repository.SecurityQuestionRepo;
import io.javaheart.makeiteasy.repository.ServiceProviderRepo;
import io.javaheart.makeiteasy.repository.TempOrderDetailsRepo;

@Service
public class ServiceProviderService {
	
	@Autowired
	private ServiceProviderRepo serviceProviderRepo;
	@Autowired
	private SecurityQuestionRepo securityQuestionRepo;
	@Autowired
	private TempOrderDetailsRepo tempOrderDetailsRepo;
	@Autowired
	private AddressRepo addressRepo;
	@Autowired
	private ItemListRepo itemListRepo;
	@Autowired
	private PriceRepo priceRepo;
	@Autowired
	private ConfirmedOrderDetailsRepo confirmedOrderDetailsRepo;
	
	//Register a service provider
	
	public boolean registerServiceProvider(ServiceProvider serviceProvider)
	{
		//return spRepo.registerServiceProvider(serviceProvider);

		Optional<ServiceProvider> found=serviceProviderRepo.findById(serviceProvider.getUserId());
		ServiceProvider sp=found.orElseGet(() -> new ServiceProvider());
		if(sp.getUserId() !=null)
		{
			return false;
		}
		else
		{
			serviceProviderRepo.save(serviceProvider);
			return true;
		}
	}	
	
	// verify Login process
	public ServiceProvider verifyLogin(String userId, String passwd)
	{
		ServiceProvider sp = serviceProviderRepo.findByUserIdAndPassword(userId, passwd);
		return sp;
	}

	//Get One ServiceProvider
	public ServiceProvider getServiceProvider(String id)
	{
		Optional<ServiceProvider> found=serviceProviderRepo.findById(id);
		ServiceProvider sp=found.orElseGet(() -> new ServiceProvider());
		return sp;
	}
	
	//Set Security Question
	public void saveSecurity(SecurityQuestion security)
	{
		securityQuestionRepo.save(security);
		
	}

	//Update Password
	public void updatePassword(ServiceProvider sp)
	{
		serviceProviderRepo.save(sp);
		
	}
	//this is to verify security question
	public boolean checkSecurityAns(String userId, String question, String ans)
	{
		
		Optional<SecurityQuestion> found=securityQuestionRepo.findById(userId);
		SecurityQuestion seq = found.orElseGet(() -> new SecurityQuestion());
		if(seq.getQuestion().equalsIgnoreCase(question) && seq.getAns().equalsIgnoreCase(ans))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//This is to get service request
	//@Cacheable("temp-orders")
	public List<TempOrderDetails> getServiceRequest(String sType)
	{
		return tempOrderDetailsRepo.findAllByServiceType(sType);
	}

	//This is to get service request
	public Address getAddress(String houseno)
	{
		Optional <Address> found= addressRepo.findById(houseno);
		Address address=found.orElseThrow(() -> new AddressNotFound("Address Not Found"));
		return address;
	}

	//This is to get service request
	//@Cacheable("item-list")
	public List<ItemList> getItemList(Long orderId)
	{
		return itemListRepo.findAllByOrderId(orderId);
	}

	//This is to get set price for the order
	public void setPrice(Price myPrice)
	{
		
		Price exPrice=priceRepo.findByOrderIdAndSpId(myPrice.getOrderId(), myPrice.getSpId());
		if(exPrice !=null)
		{
			myPrice.setSlNo(exPrice.getSlNo());
			priceRepo.save(myPrice);
		}
		else
		{
			priceRepo.save(myPrice);
		}
	}

	//This is to update service provider profile
	public boolean updateProfile(ServiceProvider sp) {
		ServiceProvider data=serviceProviderRepo.save(sp);
		if(data!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	//This is get Service History
	//@Cacheable("confirmed-orders")
	public List<ConfirmedOrderDetails> getServiceHistory(String id) {
		return confirmedOrderDetailsRepo.findAllByServiceProviderId(id);
	}

}
