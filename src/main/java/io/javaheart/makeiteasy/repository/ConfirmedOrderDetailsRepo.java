package io.javaheart.makeiteasy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.javaheart.makeiteasy.model.ConfirmedOrderDetails;

public interface ConfirmedOrderDetailsRepo extends JpaRepository<ConfirmedOrderDetails, Long> {
	
	public List<ConfirmedOrderDetails> findAllByCustomerId(String customerId);
	
	public ConfirmedOrderDetails findByOrderIdAndCustomerId(Long orderId, String userId);
	
	public List<ConfirmedOrderDetails> findAllByServiceProviderId(String serviceProviderId);

}
