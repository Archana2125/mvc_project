package com.nt.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.nt.Entity.Categories;

@Repository
public interface CategoryDao extends CrudRepository<Categories, Long> {

	

}
