package io.javaheart.makeiteasy.service; 

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import io.javaheart.makeiteasy.exception.AddressNotFound;
import io.javaheart.makeiteasy.model.Address;
import io.javaheart.makeiteasy.model.ConfirmedOrderDetails;
import io.javaheart.makeiteasy.model.Customer;
import io.javaheart.makeiteasy.model.ItemList;
import io.javaheart.makeiteasy.model.Price;
import io.javaheart.makeiteasy.model.SecurityQuestion;
import io.javaheart.makeiteasy.model.ServiceProvider;
import io.javaheart.makeiteasy.model.TempOrderDetails;
import io.javaheart.makeiteasy.repository.AddressRepo;
import io.javaheart.makeiteasy.repository.ConfirmedOrderDetailsRepo;
import io.javaheart.makeiteasy.repository.CustomerRepo;
import io.javaheart.makeiteasy.repository.ItemListRepo;
import io.javaheart.makeiteasy.repository.PriceRepo;
import io.javaheart.makeiteasy.repository.SecurityQuestionRepo;
import io.javaheart.makeiteasy.repository.ServiceProviderRepo;
import io.javaheart.makeiteasy.repository.TempOrderDetailsRepo;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepo customerRepo;
	@Autowired 
	private TempOrderDetailsRepo tempOrderDetailsRepo;
	@Autowired
	private SecurityQuestionRepo securityQuestionRepo;
	@Autowired
	private ItemListRepo itemListRepo;
	@Autowired
	private AddressRepo addressRepo;
	@Autowired
	private PriceRepo priceRepo;
	@Autowired
	private ServiceProviderRepo serviceProviderRepo;
	@Autowired
	private ConfirmedOrderDetailsRepo confirmedOrderDetailsRepo;

	
	//This is for verify The user
	public Customer verifyLogin(String userid, String passwd)
	{
		Customer customer = customerRepo.findByUserIdAndPassword(userid, passwd);
		return customer;
	}
	
	//This is for register the user
	public boolean registerUser(Customer customer) {
		Optional<Customer> found=customerRepo.findById(customer.getUserId());
		Customer cu=found.orElseGet(() -> new Customer());
		if(cu.getUserId() !=null)
		{
			return false;
		}
		else
		{
			customerRepo.save(customer);
			return true;
		}
	}
	
	//To get a particular customer all details
	public Customer getCustomer(String id)
	{
		Optional<Customer> found = customerRepo.findById(id);
		Customer cus = found.orElseGet(() -> new Customer());
		return cus;
	}

	//To get order request for a particular customer
	//@Cacheable("temp-orders")
	public List<TempOrderDetails> myOrders(String id)
	{
		return tempOrderDetailsRepo.findAllByUserId(id);
	}

	//To set security question
	public void saveSecurity(SecurityQuestion security) {
		securityQuestionRepo.save(security);
	}
	
	// To update Password
	public void updatePass(Customer customer)
	{
		customerRepo.save(customer);
	}

	//To get requested service Item List
//	@Transactional
//	public List<ItemList> getAllItemById(String user)
//	{
//		return itemListRepo.findAllByOrderId(user)//getAllItemsById(user);
//	}
	
	//This is to verify secustomerRepoity question and answer for forget password
	public boolean checkSecurityAns(String userId,String question, String ans)
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
	
	//This is to add item to the service request
	public void addItem(ItemList itmList)
	{
		itemListRepo.save(itmList);
		
	}
	
	//This is to get Maximum orderId
	public Long getMaxOrderId()
	{
		return itemListRepo.getMaxOrderId();
	}
	
	//This is to save orderRequest
	public String saveOrderRequest(TempOrderDetails tod)
	{
		TempOrderDetails data= tempOrderDetailsRepo.save(tod);
		if(data!= null)
		{
			return "Order successfully Placed";
		}
		else
		{
			return "Sorry something went wrong order failed";
		}
		
	}

	//This is to get The Address
	@Cacheable("get-address")
	public Address getAddress(String houseno)
	{
		Optional<Address> found = addressRepo.findById(houseno);
		Address address = found.orElseThrow(() -> new AddressNotFound("Address Not Found"));
		return address;
	}

	//This is to get item List
	public List<ItemList> getItemList(Long orderId)
	{
		return itemListRepo.findAllByOrderId(orderId);
	}

	//This is to get Price List
	public List<Price> getPriceList(Long orderId)
	{
		return priceRepo.findAllByOrderId(orderId);
	}

	//This is to get Service Type
	public String getServiceProviderType(String spId)
	{
		Optional<ServiceProvider> found= serviceProviderRepo.findById(spId);
		ServiceProvider sp = found.orElseGet(() -> new ServiceProvider());
		return sp.getServiceProviderType();
	}

	//This is to save confirm order
	public void acceptOrder(ConfirmedOrderDetails cus)
	{
		confirmedOrderDetailsRepo.save(cus);
		tempOrderDetailsRepo.deleteById(cus.getOrderId());
	}

	//This is to save address
	public void saveAddress(Address address)
	{
		addressRepo.save(address);
		
	}

	//This is Update Full profile
	public boolean updateProfile(Customer cu)
	{
		Customer data=customerRepo.save(cu);
		if(data!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// This is to get Order History
	public List<ConfirmedOrderDetails> myConfirmOrders(String customerId)
	{
		return confirmedOrderDetailsRepo.findAllByCustomerId(customerId);
	}

	//This is to get Order
	public TempOrderDetails findOrderById(Long orderId)
	{
		Optional<TempOrderDetails> found= tempOrderDetailsRepo.findById(orderId);
		TempOrderDetails tod=found.orElseGet(() -> new TempOrderDetails());
		return tod;
		
	}
	
	//This is to get data whether  a order accepted by a user or not
	public boolean checkSubmit(Long orderId, String userId)
	{
		ConfirmedOrderDetails cod= confirmedOrderDetailsRepo.findByOrderIdAndCustomerId(orderId, userId);
		if(cod!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	//This is to delete request
	public void deleteOrderReq(TempOrderDetails data) {
		tempOrderDetailsRepo.delete(data);
	}

	
	
}
