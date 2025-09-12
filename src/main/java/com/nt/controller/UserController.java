package com.nt.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.Dto.ForgotPassDto;
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
		@RequestMapping("/registerUser")
		public  String registerUser(@ModelAttribute @Valid UserDto userDto,Model model)
		{	
			String pass=userDto.getPassword();
			String conformpass=userDto.getConfirmPassword();
			
			if(pass == null || conformpass == null || !pass.equals(conformpass))
			{
				model.addAttribute("wrongpass", "password not match ");
				return"registeruser";
			}
			
			User user=userDto.getUser();
			user.setPassword(pass); 
		    user.setConformpassword(conformpass);
			System.out.println(user);
			
			Address address = userDto.getAddress();
			System.out.println(address);
			
			address.setUser(user);
			userService.registerUser(user,address);
			
			return "login";
			
			
			
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
					 httpSession.setAttribute("adminName", user.getUser_name()); 
					return "admin-Dashboard"; 
				 }
				 
				 else if ("user".equalsIgnoreCase(role)) {
					 httpSession.setAttribute("userName", user.getUser_name()); 
					return"user-Dashboard";
				}
				 
				 
			 }
			model.addAttribute("errormsg", "invalid userName or password");
			return "login";
			
		}
		
		/************************ Forgot Password ***********************/

		@RequestMapping("/forgotpass")
		public String ForgotPasswordPage() {
			return "forgotPass";
		}
		@RequestMapping("/forgot")
		public String ForgotPassword(@ModelAttribute ForgotPassDto forgotPassDto ,Model model) {
			String username=forgotPassDto.getUserName();
			String pass=forgotPassDto.getPassword();
			String conformpass=forgotPassDto.getConfirmPassword();
			
			if(username==null||pass == null || conformpass == null || !pass.equals(conformpass)){
				model.addAttribute("error", " username or password not match ");
				return"forgotPass";
			}
			String result=	userService.ForgotPassword(username,pass);
			if ("failure".equals(result)) {
		        model.addAttribute("error", "User not found or update failed");
		        return "forgotPass";
		    }
			model.addAttribute("success", "pasword update sucessfull");
			return "login";
			
		}
		/************************ Logout ***********************/
		@RequestMapping("/logout")
		public String logout(HttpSession httpSession,Model model)
		{
			httpSession.invalidate();
			model.addAttribute("logout","logout sucess");
			return "index";
			
		}

}
