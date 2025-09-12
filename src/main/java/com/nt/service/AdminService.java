package com.nt.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nt.Entity.Brands;
import com.nt.Entity.Categories;


public interface AdminService  {
void addcategory(String category_name, MultipartFile imageFile);

	void addBrand(Brands brands);

}
