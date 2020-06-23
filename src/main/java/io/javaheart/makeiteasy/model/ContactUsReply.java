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
@Table(name="contact_us_reply")
@Data
public class ContactUsReply {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="slno")
	private Long slno;
	
	@Column
	@NotNull
	private String replyMessage;
	
	@Column(name="receiver_d")
	@NotNull
	private String receiverId;
	
	@Column(name="date")
	@NotNull
	private String date;
}