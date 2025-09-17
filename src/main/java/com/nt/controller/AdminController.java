package com.nt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.Dao.BrandDao;
import com.nt.Dao.CategoryDao;
import com.nt.Entity.Brands;
import com.nt.Entity.Categories;
import com.nt.Entity.Products;
import com.nt.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	BrandDao brandDao;

	/************************ admindashboard Page ***********************/
	@RequestMapping("/adminpage")
	public String registerUserpage() {
		return "admin-Dashboard";
	}

	/************************ addproduct ***********************/

	@RequestMapping("/productpage")
	public String addproductpage(Model model) {
		model.addAttribute("categories", categoryDao.findAll());
		model.addAttribute("brands", brandDao.findAll());

		return "addproduct";
	}

	@RequestMapping("/addProduct")
	public String addproduct(@ModelAttribute("products") Products products,
			BindingResult bindingResult,
			@RequestParam(name = "category_id", required = false) long category_id,
			@RequestParam(name = "brand_id", required = false) long brand_id,
			@RequestParam(name = "image", required = false) MultipartFile imageFile, 
			RedirectAttributes redirectAttrs,
			HttpServletRequest request) {
		try {
  
			Categories categories = categoryDao.findById(category_id).orElseThrow();
			products.setCategory(categories);
			    
			 
			 Brands brands = brandDao.findById(brand_id).orElseThrow();
			 products.setBrand(brands);
			  
			 
			  products.setBrand(brands);
			  products.setImage(imageFile.getBytes()); 
			  
			  // save
			  adminService.addproduct(products, imageFile);

			redirectAttrs.addFlashAttribute("success", "Product added successfully!");
			return "redirect:/adminpage";

		} catch (Exception e) {
			e.printStackTrace();
			redirectAttrs.addFlashAttribute("error", "Error adding product!");
			return "redirect:/productpage";
		}
	}

	/************************ categories ***********************/
	@RequestMapping("/addcategory")
	public String addcategoriespage() {
		return "categories";
	}

	@RequestMapping("/addCategory")
	public String addcategory(@RequestParam("category_name") String category_name,
			@RequestParam("image") MultipartFile file, RedirectAttributes model, HttpServletRequest request) {

		System.out.println(file.getOriginalFilename());

		Categories categories = new Categories();
		categories.setCategory_name(category_name);

		adminService.addcategory(category_name, file);
		model.addFlashAttribute("categoryadd", "added sucessfully");

		return "redirect:/adminpage";

	}

	/************************ Brands ***********************/

	@RequestMapping("/brand")
	public String addBrandpage() {
		return "Brands";
	}

	@RequestMapping("/addBrand")
	public String addBrand(@ModelAttribute Brands brands, RedirectAttributes model) {
		adminService.addBrand(brands);
		System.out.println(brands);
		model.addFlashAttribute("addbrand", "Brand is added");

		return "redirect:/adminpage";

	}
}
