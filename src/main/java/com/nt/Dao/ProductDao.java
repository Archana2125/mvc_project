package com.nt.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nt.Entity.Products;
@Repository
public interface ProductDao extends JpaRepository<Products, Long>  {

	List<Products> findByCategory_CategoryId(Long categoryId);

}
