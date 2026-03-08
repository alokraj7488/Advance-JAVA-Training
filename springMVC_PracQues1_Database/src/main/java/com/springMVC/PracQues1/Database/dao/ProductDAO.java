package com.springMVC.PracQues1.Database.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springMVC.PracQues1.Database.model.Product;



@Repository
public interface ProductDAO extends JpaRepository<Product, Long>{
	
	
}
