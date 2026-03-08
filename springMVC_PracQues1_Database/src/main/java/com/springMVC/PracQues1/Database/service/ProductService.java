package com.springMVC.PracQues1.Database.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springMVC.PracQues1.Database.dao.ProductDAO;
import com.springMVC.PracQues1.Database.model.Product;



@Service
public class ProductService {
	public ProductDAO productDAO;
	
	public ProductService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	public List<Product> getAllProducts() {
		return productDAO.findAll();
	}

	public void saveProduct(Product product) {
		productDAO.save(product);
		
	}
}
