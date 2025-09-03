package com.nt.service;

import org.springframework.stereotype.Service;

import com.nt.Entity.Address;
import com.nt.Entity.User;

public interface UserService {

	

	void registerUser(User user, Address address);

	User login(String userName, String password);

}
