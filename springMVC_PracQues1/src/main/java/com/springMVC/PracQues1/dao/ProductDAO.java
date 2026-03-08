package com.springMVC.PracQues1.dao;

import com.springMVC.PracQues1.model.Product;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository
public class ProductDAO {
	
	public List<Product> getAllProduct() {
		List<Product> products = Arrays.asList(new Product(1, "T-Shirt", 1599.99),
										   	   new Product(2, "Jeans", 997.99),
										   	   new Product(3, "Shoes", 2789.89)
										   	   );
		return products;
	}
}
