package io.javaheart.makeiteasy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="admin_details")
//Lombok
@Data
public class Admin {
	
	@Id
	@Column(name="userid")
	@NotNull
	private String userId;
	

	@Column(name="passwd")
	@NotNull
	private String password;
	
	@Column(name="firstname")
	@NotNull
	private String firstName;
	
	@Column(name="lastname")
	@NotNull
	private String lastName;

	
}
