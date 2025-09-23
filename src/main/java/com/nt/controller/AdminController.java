
package com.nt.controller;

import java.io.ByteArrayInputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.Dao.BrandDao;
import com.nt.Dao.CategoryDao;
import com.nt.Dto.GetCategoryDto;
import com.nt.Dto.GetProductDto;
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
/**************** catagory select*************************/
	
	@RequestMapping("/showcat")
	public String showcategories(Model model) {
		List<Categories> categoriesList=adminService.getCategories();
		
		List<GetCategoryDto> categoryDtos=new ArrayList<GetCategoryDto>();
		for(Categories cat:categoriesList) {
			GetCategoryDto dto=new GetCategoryDto();
			dto.setId(cat.getCategory_id());
			dto.setName(cat.getCategory_name());
			
			
			if(cat.getImage() !=null) {
				byte[] imageBytes = cat.getImage();
				String base64=Base64.getEncoder().encodeToString(cat.getImage());
				
				String mimetype;
				
				
				try {
				mimetype=URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(imageBytes));
				} 
				catch (Exception e) {
	                mimetype = null;
	            }
				
				
				if(mimetype==null)
				{
					mimetype="image/jpeg";
				}
				String imageSrc="data:"+mimetype+";base64,"+base64;
				
				dto.setBase64Image(imageSrc);
			}
			categoryDtos.add(dto);
		}
		
		model.addAttribute("categories", categoryDtos);
		
		return "getCategories";
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
	
	/************************ viewproduct ***********************/
	@RequestMapping("/getProductById/{categoryId}")
	public String showProductsBycat(@PathVariable("categoryId") Long categoryId,Model model )
	{
		 List<Products> products =adminService.showProductsBycat(categoryId);
		 
		 List<GetProductDto> dtos=new ArrayList();
		 for(Products p:products)
		 {
			 GetProductDto productDto=new GetProductDto();
			productDto.setId(p.getProduct_id());
			productDto.setName(p.getProduct_name());
			productDto.setPrice(p.getPrice());
			
			
			if(p.getImage() !=null)
			{
				byte[] imageBytes=p.getImage();
				String base64=Base64.getEncoder().encodeToString(p.getImage());
				
				String mimetype;
				try {
					mimetype=URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(imageBytes));
				}
				catch (Exception e) {
					mimetype=null;
				}
				
				if(mimetype==null)
				{
					mimetype="image/jpeg";
				}
				String imageSrc="data:"+mimetype+";base64,"+base64;
				
				productDto.setBase64Image(imageSrc);			
				}
			 dtos.add(productDto);
		 }
		model.addAttribute("product", dtos);
	
		
		return"viewproduct";
	}

	
	
	}
