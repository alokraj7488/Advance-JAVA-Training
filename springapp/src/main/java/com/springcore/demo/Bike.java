package com.springcore.demo;

import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
//@Primary
public class Bike implements Vehicle{
	public Bike() {
		System.out.println("Bike bean created by Spring!");
	}
	
	@Override
	public void run() {
		System.out.println("Bike Running...");
	}
}
