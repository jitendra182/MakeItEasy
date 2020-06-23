package io.javaheart.makeiteasy.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import io.javaheart.makeiteasy.model.Address;
import lombok.Data;

@Entity
@Table(name="customer_details")
//Lombok
@Data
public class Customer {

	@Id
	@Column(name="userid")
	@NotNull
	private String userId;
	
	@Column(name="firstname")
	@NotNull
	private String firstName;
	
	@Column(name="lastname")
	@NotNull
	private String lastName;
	
	@Column(name="emailid")
	@NotNull
	private String emailId;
	
	@Column(name="passwd")
	@NotNull
	private String password;
	
	@Column(name="phoneno")
	@NotNull
	private Long phoneNo;
	
	//@Column(name="address")
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="houseno")//,referencedColumnName="houseno")
    private Address address;

}
