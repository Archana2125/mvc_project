package com.nt.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nt.Entity.Products;
@Repository
public interface ProductDao extends CrudRepository<Products, Long> {

}
