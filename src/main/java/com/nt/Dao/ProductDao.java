package com.nt.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nt.Entity.Products;
@Repository
public interface ProductDao extends CrudRepository<Products, Long> {

	List<Products> findByCategory_CategoryId(Long categoryId);

}
