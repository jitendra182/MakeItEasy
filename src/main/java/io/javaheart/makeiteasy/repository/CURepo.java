package io.javaheart.makeiteasy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import io.javaheart.makeiteasy.model.ContactUs;

@Repository
public class CURepo {

	@Autowired
	private EntityManager entityManager;

	//This is to save messages into DB
	@Transactional
	public void save(ContactUs contactUs) {
		
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.save(contactUs);
	}
	
	//This is to get Messages from DB
	@Transactional
	public List<ContactUs> getAllMessage() {
		
		Session currentSession=entityManager.unwrap(Session.class);
		Query<ContactUs> query=currentSession.createQuery("from ContactUs",ContactUs.class);
		List<ContactUs> data=query.getResultList();
		return data;
	}
}
