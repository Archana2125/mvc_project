package com.nt.Dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.Entity.Address;
import com.nt.Entity.User;
@Repository
public interface UserDao extends CrudRepository<User, Long>  {
	

	User findByUserNameAndPassword(String userName,String password);
	@Modifying
	@Transactional
	@Query("UPDATE  User  u set u.password = :password where u.userName = :userName")
	int updatePasswordByUsername(@Param("userName") String userName,@Param("password") String password);

	

	
}
