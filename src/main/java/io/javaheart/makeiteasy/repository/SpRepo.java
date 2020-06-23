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
import io.javaheart.makeiteasy.model.ItemList;
import io.javaheart.makeiteasy.model.Price;
import io.javaheart.makeiteasy.model.SecurityQuestion;
import io.javaheart.makeiteasy.model.ServiceProvider;
import io.javaheart.makeiteasy.model.TempOrderDetails;

@Repository
public class SpRepo {
	
	@Autowired
	private EntityManager entityManager;

	//Function to Register/save the service provider 
	@Transactional
	public String registerServiceProvider(ServiceProvider serviceProvider) {
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.save(serviceProvider);
		return "Successfully Register";
	}
	
	// Function to verify for Login
	@Transactional
	public ServiceProvider verifyLogin(String userid, String passwd) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<ServiceProvider> query = currentSession.createQuery(
				"from ServiceProvider sp where sp.userId=:uname and sp.password=:pass", ServiceProvider.class);
		query.setParameter("uname", userid);
		query.setParameter("pass", passwd);
		query.setMaxResults(1);
		ServiceProvider sp = (ServiceProvider) query.uniqueResult();
		return sp;
	}

	//This is to get One ServiceProvider
	@Transactional
	public ServiceProvider getOneSp(String id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<ServiceProvider> query=currentSession.createQuery("from ServiceProvider sp where sp.userId=:uid",ServiceProvider.class);
		query.setParameter("uid",id);
		query.setMaxResults(1);
		ServiceProvider sp = (ServiceProvider) query.uniqueResult();
		return sp;
	}

	//This is to set or update Security Question
	@Transactional
	public void saveSecurity(SecurityQuestion security) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(security);
		
	}
	
	//This is to update password
	@Transactional
	public void updatePass(ServiceProvider sp) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(sp);
	}
	
	//This is to check security question and answer
	@Transactional
	public boolean checkSecurityAns(String userId, String question, String ans) {
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


	//This is to get Service Request
	@Transactional
	public List<TempOrderDetails> getServiceRequest(String sType) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<TempOrderDetails> query=currentSession.createQuery("from TempOrderDetails tod where tod.serviceType=:st",TempOrderDetails.class);
		query.setParameter("st",sType);
		return query.getResultList();
	}
	
	//This is to get Address
	@Transactional
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
	
	//This is to check exist or not
	public Price checkPriceExist(Price myPrice) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Price> query=currentSession.createQuery("from Price p where p.orderId=:oid and p.spId=:sid",Price.class);
		query.setParameter("oid",myPrice.getOrderId());
		query.setParameter("sid",myPrice.getSpId());
		Price price=query.getSingleResult();
		if(price!=null) 
		{
			return price;
		}
		else
		{
			return null;
		}
	}
	
	//This is to set or update price for a order request
	@Transactional
	public void setPrice(Price myPrice) {
		try 
		{
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.save(myPrice);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	//This is to set or update price for a order request
	@Transactional
	public void updatePrice(Price myPrice) {
		try 
		{
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.saveOrUpdate(myPrice);
		}
		catch(Exception e)
		{
			System.out.println("Error");
		}
	}
	
	//This is to set or update price for a order request
	@Transactional
	public List<Price> getAllPrice() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Price> query=currentSession.createQuery("from Price",Price.class);
		return query.getResultList();
		
	}

	//This is to update serviceprovider profile
	@Transactional
	public void updateProfile(ServiceProvider sp) {
		Session currentsession=entityManager.unwrap(Session.class);
		currentsession.update(sp);
	}
	
	//This is to get Service History
	@Transactional
	public List<ConfirmedOrderDetails> getServiceHistory(String id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<ConfirmedOrderDetails> query=currentSession.createQuery("from ConfirmedOrderDetails cos where cos.serviceProviderId=:cid",ConfirmedOrderDetails.class);
		query.setParameter("cid", id);
		return query.getResultList();
	}

}
