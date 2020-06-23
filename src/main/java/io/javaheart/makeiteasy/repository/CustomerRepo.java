package io.javaheart.makeiteasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.javaheart.makeiteasy.model.Customer;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {

	public Customer findByUserIdAndPassword(String userId,String Password);
}
