package io.javaheart.makeiteasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.javaheart.makeiteasy.model.ServiceProvider;

public interface ServiceProviderRepo extends JpaRepository<ServiceProvider, String>{
	
	public ServiceProvider findByUserIdAndPassword(String userId,String password);
}
