package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Dao.UserDao;
import com.nt.Entity.Address;
import com.nt.Entity.User;
@Service
public class UserServiceImpl implements UserService {

		@Autowired
		UserDao userDao;
	
	@Override
	public void registerUser(User user,Address address) {
		
		List<Address> addList=new ArrayList();
		addList.add(address);
		
		user.setAddresses(addList);
		userDao.save(user);
	}

}
