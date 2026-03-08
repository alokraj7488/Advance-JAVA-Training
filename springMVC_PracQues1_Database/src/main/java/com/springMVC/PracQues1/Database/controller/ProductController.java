package com.springMVC.PracQues1.Database.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springMVC.PracQues1.Database.model.Product;
import com.springMVC.PracQues1.Database.service.ProductService;

import jakarta.annotation.PostConstruct;


@Controller
public class ProductController {
	ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/products")
	public String service(Model model) {
		List<Product> productsList = productService.getAllProducts();
		model.addAttribute("products", productsList);
		return "products";
	}

	@GetMapping("/product")
	public ModelAndView getProductDetails() {
		List<Product> products = productService.getAllProducts();
		ModelAndView mv = new ModelAndView();
		mv.addObject("products", products);
		mv.setViewName("product");
		return mv;
	}

	@GetMapping("/addProduct")
	public String showAddForm(Model model) {
		model.addAttribute("product", new Product());
		return "addProduct";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product")Product product) {
		productService.saveProduct(product);
		return "redirect:/product";
	}
}