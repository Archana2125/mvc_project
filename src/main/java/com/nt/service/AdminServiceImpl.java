package com.nt.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nt.Dao.AdminDao;
import com.nt.Dao.BrandDao;
import com.nt.Dao.CategoryDao;
import com.nt.Entity.Brands;
import com.nt.Entity.Categories;

@Service
public class AdminServiceImpl  implements AdminService{

	@Autowired
	AdminDao adminDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	BrandDao brandDao;

	

	@Override
	public void addBrand(Brands brands) {
		
		brandDao.save(brands);
	}



	@Override
	public void addcategory(String category_name, MultipartFile imageFile) {
		try {
		Categories categories=new Categories();
		categories.setCategory_name(category_name);
		
			categories.setImage(imageFile.getBytes());
			
			categoryDao.save(categories);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}



	
	
}
