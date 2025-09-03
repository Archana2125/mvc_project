package com.nt.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.Dto.UserDto;

import com.nt.Entity.Address;
import com.nt.Entity.User;
import com.nt.service.UserService;

@Controller
public class UserController {
	
		@Autowired
		UserService userService;

		/************************ Landing Page ***********************/
		@RequestMapping("/")
		public String showlandingpage() {
			return "index";
		}
		
		 /************************ Register Page ***********************/
		@RequestMapping("/registerpage")
		public  String registerUserpage() {
			return "registeruser";
			
		}
		@PostMapping("/registerUser")
		public  ResponseEntity<String> registerUser(@ModelAttribute @Valid UserDto userDto)
		{
			User user=userDto.getUser();
			System.out.println(user);
			
			Address address = userDto.getAddress();
			System.out.println(address);
			
			address.setUser(user);
			userService.registerUser(user,address);
			return ResponseEntity.ok("User added");
		}
		
		/************************ Login ***********************/
		
		@RequestMapping("/loginpage")
		public String showloginPage() {
			return "login";
		}
		
		@RequestMapping("/login")
		public String login(@RequestParam String userName,@RequestParam String password , HttpSession httpSession,Model model)
		{
			User user = userService.login(userName, password);
			// boolean isvalid=userService.login(userName,password);
			 if(user!=null)
			 {
				
				 httpSession.setAttribute("user", user);
				 
				 String role = user.getRole();
				 
				 if("admin".equalsIgnoreCase(role))
				 {
					return "admin-Dashboard"; 
				 }
				 
				 else if ("user".equalsIgnoreCase(role)) {
					return"user-Dashboard";
				}
				 
				 else {
					 return"registeruser";
				 }
			 }
			model.addAttribute("errormsg", "invalid userName or password");
			return "login";
			
		}

	


}
