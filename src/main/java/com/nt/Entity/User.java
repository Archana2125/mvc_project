package com.nt.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	
	private String first_name;
	
	private String middle_name;
	
	private String last_name;
	
	@Email
	private String email;
	
	private String user_name;
	
	private String password;
	
	@Transient // Not stored in DB
	private String Conformpassword;
	
	private String role;
	
	private String contactno;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Address> addressList;


	
}
