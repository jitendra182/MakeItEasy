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
@Table(name="service_provider_details")
//Lombok
@Data
public class ServiceProvider {
	
	@Id
	@Column(name="userid")
	private String userId;
	

	@Column(name="passwd")
	@NotNull
	//@Size(min=8,max=35)
	private String password;
	
	@Column(name="emailid")
	@NotNull
	private String emailId;
	
	
	@Column(name="companyname")
	@NotNull
	private String companyName;

	
	@Column(name="phoneno")
	@NotNull
	private long phoneNo;
	
	@Column(name="service_type")
	@NotNull
	private String serviceProviderType;
	
	//@Column(name="address")
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="houseno")//,referencedColumnName="houseno")
    private Address address;
}
