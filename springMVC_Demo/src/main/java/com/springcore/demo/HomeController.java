package com.springcore.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.service.annotation.GetExchange;


@Controller
public class HomeController {
	
	@RequestMapping("/home") 
	public String home(Model model) {
		User user = new User(101, "John", "L.A");
		model.addAttribute("user", user);
		return "home";
	}
	
	@GetMapping("login")
	public String loginMapper() {
		return "login";
	}
}
