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
@Table(name="contact_us")

//Lombok
@Data
public class ContactUs {

	
	@Id
	@Column(name="sl_no")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int slNo; 
	
	@Column(name="email")
	@NotNull
	private String emailId;
	
	@Column(name="name")
	@NotNull
	private String name;
	
	@Column(name="message")
	@NotNull
	private String msg;
	
	@NotNull
	@Column(name="date")
	private String date;

}
