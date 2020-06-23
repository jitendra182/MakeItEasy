package io.javaheart.makeiteasy.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="confirmed_order_details")
@Data
public class ConfirmedOrderDetails {

	@Id
	@Column(name="order_id")
	private Long orderId;
	
	@Column(name="service_type")
	@NotNull
	private String serviceType;
	
	
	@Column(name="price")
	@NotNull
	private Double price;
	
	@Column(name="sp_id")
	@NotNull
	private String serviceProviderId;
	
	@Column(name="cus_id")
	@NotNull
	private String customerId;
	
	@Column(name="source_address_house_no")
	@NotNull
	private String sourceAddHouseNo;
	
	@Column(name="dest_address_house_no")
	@NotNull
	private String destAddHouseNo;
	
	@Column(name="service_date")
	@NotNull
	private String serviceDate;
	
}
