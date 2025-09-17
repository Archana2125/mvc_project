package com.nt.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nt.Entity.Brands;
import com.nt.Entity.Categories;
import com.nt.Entity.Products;


public interface AdminService  {
void addcategory(String category_name, MultipartFile imageFile);

	void addBrand(Brands brands);

	void addproduct(Products products, MultipartFile imageFile);

}
