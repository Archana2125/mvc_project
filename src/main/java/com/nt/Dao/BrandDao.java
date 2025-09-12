package com.nt.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nt.Entity.Brands;

@Repository
public interface BrandDao extends CrudRepository<Brands, Long> {

}
