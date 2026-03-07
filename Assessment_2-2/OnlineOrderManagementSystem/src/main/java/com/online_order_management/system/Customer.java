package com.online_order_management.system;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int customerId;
	String customerName;
	String email;
	
	@OneToMany
	List<Order> order;
	
	public Customer(String customerName, String email, List<Order> order) {
		this.customerName = customerName;
		this.email = email;
		this.order = order;
	}
}
