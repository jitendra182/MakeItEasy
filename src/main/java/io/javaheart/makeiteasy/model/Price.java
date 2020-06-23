package io.javaheart.makeiteasy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import lombok.Data;

@Entity
@Table(name="Price")
@Data
public class Price {
	
	@Id
	@Column(name="sl_no")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer slNo;
	
	@Column(name="order_id")
	@NotNull
	private Long orderId;
	
	@Column(name="price")
	@NotNull
	private Double price;
	
	@NotNull
	@Column(name="sp_id")
	private String spId;

}
