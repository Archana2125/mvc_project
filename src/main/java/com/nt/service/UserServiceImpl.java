package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Dao.CategoryDao;
import com.nt.Dao.ProductDao;
import com.nt.Dao.UserDao;
import com.nt.Entity.Address;
import com.nt.Entity.Products;
import com.nt.Entity.User;
@Service
public class UserServiceImpl implements UserService {

		@Autowired
		private UserDao userDao;
		
		@Autowired
		private ProductDao productDao;
		
		
		@Override
		public void registerUser(User user,Address address) {
			
			List<Address> addList=new ArrayList();
			addList.add(address);
			
			user.setAddresses(addList);
			userDao.save(user);
		}

	@Override
	public User login(String userName, String password) {
		User user=userDao.findByUserNameAndPassword(userName, password);
		
		if(user!=null&& user.getPassword().equals(password))
		{
			return user ;
			
		}
		return null;
		
	}

	@Override
	public String ForgotPassword(String userName, String password) {
		int rows=	userDao.updatePasswordByUsername(userName, password);
		return rows>0?"success":"failure";
	}

	 @Override
	    public Iterable<Products> getAllProducts() {
	        return productDao.findAll(); 
	    }

	

}