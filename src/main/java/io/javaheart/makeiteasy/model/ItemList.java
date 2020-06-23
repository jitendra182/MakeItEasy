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
@Table(name="item_list")
@Data
public class ItemList {
	
	@Id
	@Column(name="slno")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long slNo;
	
	@Column(name="item_name")
	@NotNull
	private String itemName;
	
	@Column(name="item_des")
	private String itemDescription;
	
//	@Column(name="user")
//	@NotNull
//	private String user;
	
	@Column(name="order_id")
	@NotNull
	private Long orderId;
}
