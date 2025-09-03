package com.nt.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.web.JsonPath;

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
	@Column(nullable = false,unique = true)
	private String email;
	
	@Column(name = "user_name") 
	private String userName;    

	
	private String password;
	
	@Transient // Not stored in DB
	@NotBlank
	private String Conformpassword;
	
	private String role;
	
	private String contactno;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@NotNull
	 private List<Address> addresses = new ArrayList<>();

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_name() {
		return userName;
	}

	public void setUser_name(String user_name) {
		this.userName = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConformpassword() {
		return Conformpassword;
	}

	public void setConformpassword(String conformpassword) {
		Conformpassword = conformpassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", first_name=" + first_name + ", middle_name=" + middle_name
				+ ", last_name=" + last_name + ", email=" + email + ", user_name=" + userName + ", password="
				+ password + ", Conformpassword=" + Conformpassword + ", role=" + role + ", contactno=" + contactno
				+ ", addresses=" + addresses + "]";
	}

	


	
	
	
}
