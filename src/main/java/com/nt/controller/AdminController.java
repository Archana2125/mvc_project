package com.nt.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import com.nt.Dto.UserDto;
import com.nt.Entity.Brands;
import com.nt.Entity.Categories;
import com.nt.Entity.Products;
import com.nt.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	/************************ admindashboard Page ***********************/
	@RequestMapping("/adminpage")
	public  String registerUserpage() {
		return "admin-Dashboard";	
	}
	/************************ addproduct ***********************/
	@RequestMapping("/productpage")
	public String addproductpage() {
		return"addproduct";
	}
	
	
	@RequestMapping("/addProduct")
	public  String addproduct(@ModelAttribute @Valid Products products,Model model)
	{
		
		return"";
	}
	
	/************************ categories ***********************/
	@RequestMapping("/addcategory")
	public String addcategoriespage()
	{
		return"categories";
	}
	@RequestMapping("/addCategory")
	public String addcategory(@RequestParam("category_name") String category_name,@RequestParam("image") CommonsMultipartFile file ,Model model,HttpServletRequest request)
	{
		
		System.out.println(file.getOriginalFilename());
		
		Categories categories=new Categories();
		categories.setCategory_name(category_name);

		adminService.addcategory(category_name,file);
		
		return "admin-Dashboard";
		
	}
	
	/************************ Brands ***********************/
	
	@RequestMapping("/brand")
	public String addBrandpage()
	{
		return"Brands";
	}
	
	@RequestMapping("/addBrand")
	public String addBrand(@ModelAttribute Brands brands,Model model)
	{
		adminService.addBrand(brands);
		System.out.println(brands);
		model.addAttribute("addbrand","Brand is added");
		
		return "admin-Dashboard";
		
	}
}
