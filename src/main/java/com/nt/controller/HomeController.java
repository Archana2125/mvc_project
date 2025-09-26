package com.nt.controller;

import java.io.ByteArrayInputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.Dto.ForgotPassDto;
import com.nt.Dto.GetProductDto;
import com.nt.Dto.UserDto;

import com.nt.Entity.Address;
import com.nt.Entity.Products;
import com.nt.Entity.User;
import com.nt.service.UserService;

@Controller
public class HomeController {
	
		@Autowired
		UserService userService;
		

		/************************ Landing Page ***********************/
		@RequestMapping("/")
		public String showlandingpage(Model model) {
			
			List<Products> products = (List<Products>) userService.getAllProducts();
			 List<GetProductDto> dtos=new ArrayList<>();
			 
			 for (Products p : products) {
			        GetProductDto dto = new GetProductDto();
			        dto.setId(p.getProduct_id());
			        dto.setName(p.getProduct_name());
			        dto.setPrice(p.getPrice());

			        if (p.getImage() != null) {
			            try {
			                byte[] imageBytes = p.getImage();
			                String base64 = Base64.getEncoder().encodeToString(imageBytes);
			                String mimeType = URLConnection.guessContentTypeFromStream( new ByteArrayInputStream(imageBytes));
			                if (mimeType == null) mimeType = "image/jpeg";
			                dto.setBase64Image("data:" + mimeType + ";base64," + base64);
			            } catch (Exception e) {
			                e.printStackTrace();
			                dto.setBase64Image(null);
			            }
			        }

			        dtos.add(dto); 
			    }

		        model.addAttribute("products", dtos);
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
		
		@RequestMapping(value ="/login", method = RequestMethod.POST)
		public String login(@RequestParam String userName,@RequestParam String password , HttpSession httpSession,RedirectAttributes model)
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
					return "redirect:/adminpage"; 
				 }
				 
				 else if ("user".equalsIgnoreCase(role)) {
					 httpSession.setAttribute("userName", user.getUser_name()); 
					 return "redirect:/userDashborad";
				}
				 
				 
			 }
			model.addFlashAttribute("errormsg", "invalid userName or password");
			return "redirect:/loginpage";
			
		}
		
		/************************ Forgot Password ***********************/

		@RequestMapping("/forgotpass")
		public String ForgotPasswordPage() {
			return "forgotPass";
		}
		@RequestMapping("/forgot")
		public String ForgotPassword(@ModelAttribute ForgotPassDto forgotPassDto ,RedirectAttributes model) {
			String username=forgotPassDto.getUserName();
			String pass=forgotPassDto.getPassword();
			String conformpass=forgotPassDto.getConfirmPassword();
			
			if(username==null||pass == null || conformpass == null || !pass.equals(conformpass)){
				model.addFlashAttribute("error", " username or password not match ");
				return"redirect:/forgotpass";
			}
			String result=	userService.ForgotPassword(username,pass);
			if ("failure".equals(result)) {
		        model.addFlashAttribute("error", "User not found or update failed");
		        return "redirect:/forgotpass";
		    }
			model.addFlashAttribute("success", "pasword update sucessfull");
			return "redirect:/loginpage";
			
		}
		/************************ Logout ***********************/
		@RequestMapping("/logout")
		public String logout(HttpSession httpSession,RedirectAttributes model)
		{
			httpSession.invalidate();
			model.addFlashAttribute("logout","logout sucess");
			return "redirect:/";
			
		}

}