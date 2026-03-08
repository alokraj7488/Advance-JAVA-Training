package com.springMVC.PracQues1.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springMVC.PracQues1.model.Product;
import com.springMVC.PracQues1.service.ProductService;

@Controller
public class ProductController {
	ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping("/products")
	public String service(Model model) {
		List<Product> productsList = productService.fetchProducts();
		model.addAttribute("products", productsList);
		return "products";
	}

}
