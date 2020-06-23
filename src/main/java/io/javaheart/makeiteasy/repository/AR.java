package io.javaheart.makeiteasy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.javaheart.makeiteasy.model.Address;
import io.javaheart.makeiteasy.model.Admin;
import io.javaheart.makeiteasy.model.ConfirmedOrderDetails;
import io.javaheart.makeiteasy.model.ContactUs;
import io.javaheart.makeiteasy.model.ContactUsReply;
import io.javaheart.makeiteasy.model.Customer;
import io.javaheart.makeiteasy.model.ItemList;
import io.javaheart.makeiteasy.model.ServiceProvider;
import io.javaheart.makeiteasy.model.TempOrderDetails;

@Repository
public class AR {
	
	@Autowired private EntityManager entityManager;
	
	//This is to verify login
	@Transactional
	public Admin verifyLogin(String userid, String passwd) {
		
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Admin> query=currentSession.createQuery("from Admin adm where adm.userId=:uname and adm.password=:pass",Admin.class);
		query.setParameter("uname", userid);
		query.setParameter("pass", passwd);
		query.setMaxResults(1);
		Admin adm=(Admin) query.uniqueResult();
		return adm;
	}

	//This is to get ServiceProvider List
	@Transactional
	public List<ServiceProvider> getServiceProviderList() {
		
		Session currentSession=entityManager.unwrap(Session.class);
		Query<ServiceProvider> query=currentSession.createQuery("from ServiceProvider",ServiceProvider.class);
		List<ServiceProvider> sp=query.getResultList();
		return sp;
	}
	
	//This is to get Customer List
	@Transactional
	public List<Customer> getCustomerList() {

		Session currentSession = entityManager.unwrap(Session.class);
		Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}


	//This is to get Contact us messages
	@Transactional
	public List<ContactUs> getAllMessage() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<ContactUs> query=currentSession.createQuery("from ContactUs",ContactUs.class);
		List<ContactUs> data=query.getResultList();
		return data;
	}


	//This is to get One ServiceProvider
	@Transactional
	public ServiceProvider getOneSp(String id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<ServiceProvider> query=currentSession.createQuery("from ServiceProvider sp where sp.userId=:uid",ServiceProvider.class);
		query.setParameter("uid", id);
		query.setMaxResults(1);
		ServiceProvider sp=query.uniqueResult();
		return sp;
	}


	//This is to get One Customer
	@Transactional
	public Customer getOneCustomer(String id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Customer> query=currentSession.createQuery("from Customer cu where cu.userId=:uid",Customer.class);
		query.setParameter("uid", id);
		query.setMaxResults(1);
		Customer cu=query.uniqueResult();
		return cu;
	}


	//This is to get All order request
	@Transactional
	public List<TempOrderDetails> getOrderReq() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<TempOrderDetails> query = currentSession.createQuery("from TempOrderDetails", TempOrderDetails.class);
		List<TempOrderDetails> orders = query.getResultList();
		return orders;
	}


	//This is to get all confirmed order
	@Transactional
	public List<ConfirmedOrderDetails> getServiceCmp() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<ConfirmedOrderDetails> query=currentSession.createQuery("from ConfirmedOrderDetails",ConfirmedOrderDetails.class);
		List<ConfirmedOrderDetails> result=query.getResultList();
		return result;
	}
	
	//This is to get address details
	@Transactional
	public Address getAddress(String houseno) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Address> query=currentSession.createQuery("from Address ads where ads.houseNo=:hs",Address.class);
		query.setParameter("hs",houseno);
		return query.getSingleResult();
	}
	
	//This is to get itemlist
	@Transactional
	public List<ItemList> getItemList(Long orderid) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<ItemList> query=currentSession.createQuery("from ItemList il where il.orderId=:id",ItemList.class);
		query.setParameter("id",orderid);
		return query.getResultList();
	}

	//This is to set Reply Message
	@Transactional
	public void saveReply(ContactUsReply cr) {
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.save(cr);
	}


}
