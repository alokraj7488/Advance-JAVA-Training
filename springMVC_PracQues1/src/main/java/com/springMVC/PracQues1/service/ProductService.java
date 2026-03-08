package com.springMVC.PracQues1.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.springMVC.PracQues1.dao.ProductDAO;
import com.springMVC.PracQues1.model.Product;


@Service
public class ProductService {
	ProductDAO productDAO;
	
	public ProductService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	public List<Product> fetchProducts() {
		return productDAO.getAllProduct();
	}
}
