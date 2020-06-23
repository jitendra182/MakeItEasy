package io.javaheart.makeiteasy.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="temporary_order_details")
@Data
public class TempOrderDetails {

	@Id
	@Column(name="order_id")
	private Long orderId;
	
	@Column(name="service_type")
	@NotNull
	private String serviceType;
	
	@Column(name="source_address_house_no")
	@NotNull
	private String sourceAddHouseNo;
	
	@Column(name="dest_address_house_no")
	@NotNull
	private String destAddHouseNo;
	
	@Column(name="user_id")
	@NotNull
	private String userId;
	
	@Column(name="date_of_service")
	@NotNull
	private String dateOfService;
	
}
