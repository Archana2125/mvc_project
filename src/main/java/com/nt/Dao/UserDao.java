package com.nt.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nt.Entity.Address;
import com.nt.Entity.User;
@Repository
public interface UserDao extends CrudRepository<User, Long>  {
	

	User findByUserNameAndPassword(String userName,String password);

	

	
}
