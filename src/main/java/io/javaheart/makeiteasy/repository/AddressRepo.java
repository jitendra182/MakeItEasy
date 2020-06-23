package io.javaheart.makeiteasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.javaheart.makeiteasy.model.Address;

public interface AddressRepo extends JpaRepository<Address, String> {

}
