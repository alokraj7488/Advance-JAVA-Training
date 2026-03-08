package com.springMVC.PracQues2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.springMVC.PracQues2.dao.CustomerDAO;
import com.springMVC.PracQues2.model.Customer;
import com.springMVC.PracQues2.service.CustomerService;

@Controller
public class CustomerController {
	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/customers")
	public String service(Model model) {
		List<Customer> customersList = customerService.getAllCustomers();
		model.addAttribute("customers", customersList);
		return "customers";
	}
	
	@GetMapping("/customer")
	public ModelAndView getCustomerDetails() {
		List<Customer> customers = customerService.getAllCustomers();
		ModelAndView mv = new ModelAndView();
		mv.addObject("customers", customers);
		mv.setViewName("customer");
		return mv;
	}
	
	@GetMapping("/addCustomer")
	public String showAddForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "addCustomer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute ("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customers";
	}	
	
	@GetMapping("/editCustomer/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		Customer customer = customerService.getCustomerById(id);
		model.addAttribute("customer", customer);
		return "addCustomer";
	}
	
	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return "redirect:/customers";
	}
	
}
