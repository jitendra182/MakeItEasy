package io.javaheart.makeiteasy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.javaheart.makeiteasy.model.TempOrderDetails;

public interface TempOrderDetailsRepo extends JpaRepository<TempOrderDetails ,Long> {
	
	public List<TempOrderDetails> findAllByUserId(String userId);
	public List<TempOrderDetails> findAllByServiceType(String serviceType);

}
