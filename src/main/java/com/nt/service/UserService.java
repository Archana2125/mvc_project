package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.Entity.Address;
import com.nt.Entity.Products;
import com.nt.Entity.User;

public interface UserService {

	

	void registerUser(User user, Address address);

	User login(String userName, String password);

	String ForgotPassword(String userName, String password);

	Iterable<Products> getAllProducts();

}
