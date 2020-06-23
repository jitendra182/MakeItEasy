package io.javaheart.makeiteasy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.javaheart.makeiteasy.model.ContactUs;
import io.javaheart.makeiteasy.repository.CURepo;

@Service
public class ContactUsService {

	@Autowired
	private CURepo cURepo;

	//This is to save message
	@Transactional
	public void save(ContactUs contactUs) {
		
		cURepo.save(contactUs);
		
	}

	//This is to get Message
	@Transactional
	public List<ContactUs> getMessages() {
		return cURepo.getAllMessage();
	}
}
