package io.javaheart.makeiteasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.javaheart.makeiteasy.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, String>{

	public Admin findByUserIdAndPassword(String userId,String password);
}
