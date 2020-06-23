package io.javaheart.makeiteasy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="security_question")
//Lombok
@Data
public class SecurityQuestion {

	@Id
	@Column(name="userId")
	private String userId;
	
	@Column(name="que")
	private String question;
	
	@Column(name="ans")
	private String ans;
}
