package io.javaheart.makeiteasy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.javaheart.makeiteasy.model.Price;

public interface PriceRepo extends JpaRepository<Price, Integer> {
	
	public List<Price> findAllByOrderId(Long id);
	
	public Price findByOrderIdAndSpId(Long orderId, String spId);

}
