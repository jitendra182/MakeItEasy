package io.javaheart.makeiteasy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.javaheart.makeiteasy.model.Address;
import io.javaheart.makeiteasy.model.ConfirmedOrderDetails;
import io.javaheart.makeiteasy.model.Customer;
import io.javaheart.makeiteasy.model.ItemList;
import io.javaheart.makeiteasy.model.Price;
import io.javaheart.makeiteasy.model.SecurityQuestion;
import io.javaheart.makeiteasy.model.ServiceProvider;
import io.javaheart.makeiteasy.model.TempOrderDetails;

@Repository
public class CuR {
	
	@Autowired
	private EntityManager entityManager;

	//This is for verify the user
	@Transactional
	public Customer verifyLogin(String userid, String passwd) {

		Session currentSession = entityManager.unwrap(Session.class);
		Query<Customer> query = currentSession
				.createQuery("from Customer ctmr where ctmr.userId=:uid and ctmr.password=:pass", Customer.class);
		query.setParameter("uid", userid);
		query.setParameter("pass", passwd);
		query.setMaxResults(1);
		Customer customer = (Customer) query.uniqueResult();
		return customer;
	}
	
	//This is for Register The user
	@Transactional
	public String registerUser(Customer customer) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(customer);
		return "Successfully Register";
	}
	

	//This is for get all customer
	@Transactional
	public List<Customer> getAllCustomer() {
		
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Customer> query=currentSession.createQuery("from Customer",Customer.class);
		List<Customer> customers=query.getResultList();
		return customers;
	}

	//This is to get One Customer
	@Transactional
	public Customer getCustomer(String id) {
		
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Customer> query=currentSession.createQuery("from Customer cu where cu.userId=:uid",Customer.class);
		query.setParameter("uid", id);
		query.setMaxResults(1);
		Customer customer=(Customer) query.uniqueResult();
		return customer;
	}

	//This is to set Security Question
	@Transactional
	public void saveSecurity(SecurityQuestion security) {

		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(security);
		
	}
	
	// To update Password
	@Transactional
	public void updatePass(Customer customer) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(customer);
	}
	


	//This is to get All the item list
	@Transactional
	public List<ItemList> getAllItemsById(String usr) {
		Session currentSession=entityManager.unwrap(Session.class);
		try {
		Query<ItemList> query=currentSession.createQuery("from ItemList itm where itm.slNo=jeet123",ItemList.class);
		//query.setParameter("us", usr);
		//query.setMaxResults(30);
		return query.getResultList();}
		catch(Exception e){
			System.out.print(e);
		}
		return null;
	}

	
	//This is to verify security answer for forgot password
	@Transactional
	public boolean checkSecurityAns(String userId,String question, String ans) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<SecurityQuestion> query=currentSession.createQuery("from SecurityQuestion sq where sq.userId=:uid", SecurityQuestion.class);
		query.setParameter("uid", userId);
		query.setMaxResults(1);
		SecurityQuestion sq = (SecurityQuestion) query.uniqueResult();
		
		if(sq.getQuestion().equalsIgnoreCase(question) && sq.getAns().equalsIgnoreCase(ans))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	//This is to add item order request
	@Transactional
	public void addItem(ItemList itmList) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(itmList);
		
	}	
	
	
	//This is to get Maximum orderid
	@Transactional
	public Long getMaxOrderId() {
		Session currentSession=entityManager.unwrap(Session.class);
		Long ordId=(Long) currentSession.createQuery("Select max(orderId) from ItemList").getSingleResult();
		return ordId;
	}
	
	
	//This is to get all order history
	@Transactional
	public List<TempOrderDetails> myOrderHistory(String id) {
		Session currentSession=entityManager.unwrap(Session.class);
			Query<TempOrderDetails> query=currentSession.createQuery("from TempOrderDetails tod where tod.userId=:cid",TempOrderDetails.class);
			query.setParameter("cid", id);
			return query.getResultList();
	}

	//This is to save the service order
	@Transactional
	public String saveOrder(TempOrderDetails tdo) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(tdo);
		String msg="Order successfully Posted";
		return msg;
	}

	//This is to get the address
	public Address getAddress(String houseno) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Address> query=currentSession.createQuery("from Address ads where ads.houseNo=:hs",Address.class);
		query.setParameter("hs",houseno);
		return query.getSingleResult();
	}
	
	//This is to get Item List
	@Transactional
	public List<ItemList> getItemList(Long orderId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<ItemList> query=currentSession.createQuery("from ItemList il where il.orderId=:id",ItemList.class);
		query.setParameter("id",orderId);
		return query.getResultList();
	}


	//This is to get Price List
	@Transactional
	public List<Price> getPriceList(Long orderId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Price> query=currentSession.createQuery("from Price p where p.orderId=:oid",Price.class);
		query.setParameter("oid",orderId);
		return query.getResultList();
	}


	//This is to get Service provider Type
	@Transactional
	public String getServiceProviderType(String spId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query query=currentSession.createQuery("select serviceProviderType from ServiceProvider sp where sp.userId=:uid");
		query.setParameter("uid",spId);
		return  (String) query.getSingleResult();
	}

	//This is to save confirm order
	@Transactional
	public void acceptOrder(ConfirmedOrderDetails cus) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(cus);
		String msg="Order successfully Posted";
		System.out.println(msg);
	}

	//This is to save address
	@Transactional
	public void saveAddress(Address address) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(address);
		
	}

	//This is to update Profile
	@Transactional
	public void updateProfile(Customer cu) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.update(cu);
	}

	//This is to get confirm orders
	@Transactional
	public List<ConfirmedOrderDetails> myConfirmOrders(String id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<ConfirmedOrderDetails> query=currentSession.createQuery("from ConfirmedOrderDetails cos where cos.customerId=:cid",ConfirmedOrderDetails.class);
		query.setParameter("cid", id);
		return query.getResultList();
	}
	
	//This is to get confirm orders
	@Transactional
	public TempOrderDetails findOrderById(Long orderId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<TempOrderDetails> query=currentSession.createQuery("from TempOrderDetails tod where tod.orderId=:oid",TempOrderDetails.class);
		query.setParameter("oid", orderId);
		return query.getSingleResult();
	}
	////This is to get data whether  a order accepted by a user or not
	@Transactional
	public boolean checkSubmit(Long orderId, String userId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<ConfirmedOrderDetails> query=currentSession.createQuery("from ConfirmedOrderDetails cf where cf.orderId=:oid and cf.customerId=:cid",ConfirmedOrderDetails.class);
		query.setParameter("oid", orderId);
		query.setParameter("cid", userId);
		ConfirmedOrderDetails data=query.getSingleResult();
		if(data!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
