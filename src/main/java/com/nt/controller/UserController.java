package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.Dto.UserDto;

import com.nt.Entity.Address;
import com.nt.Entity.User;
import com.nt.service.UserService;

@Controller
public class UserController {
	
		@Autowired
		UserService userService;
		
		@RequestMapping("/")
		public String showlandingpage() {
			return "index";
		}
		@RequestMapping("/registerpage")
		public  String registerUserpage() {
			return "registeruser";
			
		}
		@PostMapping("/registerUser")
		public  ResponseEntity<String> registerUser(@ModelAttribute UserDto userDto)
		{
			User user=userDto.getUser();
			Address address = userDto.getAddress();
			userService.registerUser(user,address);
			return ResponseEntity.ok("User added");
		}
		
		

	


}
