package com.nt.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long address_id;
	
	private String house_name;
	
	private String city;
	
	private String landmark;
	
	private Integer house_no;
	
	private Integer pincode;
	
	private String district;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
	
}
