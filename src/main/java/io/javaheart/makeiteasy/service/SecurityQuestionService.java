package io.javaheart.makeiteasy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javaheart.makeiteasy.model.SecurityQuestion;
import io.javaheart.makeiteasy.repository.SecurityQuestionRepo;

@Service
public class SecurityQuestionService {

	@Autowired
	private SecurityQuestionRepo securityQuestionRepo;
	
	public Optional<SecurityQuestion> findByUserId(String userId)
	{
		return securityQuestionRepo.findById(userId);
	}
}
