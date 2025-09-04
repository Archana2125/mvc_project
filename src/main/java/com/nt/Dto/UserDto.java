package com.nt.Dto;

import com.nt.Entity.Address;
import com.nt.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserDto 
{
	private User user;
	private Address address;
	private String password;
	private String confirmPassword;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "UserDto [user=" + user + ", address=" + address + ", password=" + password + ", confirmPassword="
				+ confirmPassword + "]";
	}
	
	
	
	
	
	
}
