package io.javaheart.makeiteasy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.javaheart.makeiteasy.model.ItemList;

public interface ItemListRepo extends JpaRepository<ItemList, Long> {

	public List<ItemList> findAllByOrderId(Long orderId);
	
	@Query("Select max(orderId) from ItemList")
	public Long getMaxOrderId();
	
}
