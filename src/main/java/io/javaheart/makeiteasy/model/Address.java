package io.javaheart.makeiteasy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.Data;

@Entity
@Table(name="address")
//Lombok
@Data
public class Address {
	
	@Id
	@Column(name="houseno")
	private String houseNo;
	
	@Column(name="apartment_or_homename")
	@NotNull
	private String apartmentOrHomeName;
	
	@Column(name="state")
	@NotNull
	private String state;
	
	@Column(name="district")
	@NotNull
	private String district;
	
	@Column(name="cityname")
	@NotNull
	private String cityName;
	
	@Column(name="policestation")
	@NotNull
	private String policeStation;
	
	@Column(name="landmark")
	@Nullable
	private String landMark;
	
	@Column(name="pincode")
	@NotNull
	private int pin;
	
}
