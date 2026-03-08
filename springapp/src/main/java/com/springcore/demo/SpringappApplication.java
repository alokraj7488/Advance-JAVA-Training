package com.springcore.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringappApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(SpringappApplication.class, args);
//		Car car1 = context.getBean(Car.class);
//		Car car2 = context.getBean(Car.class);	
//		System.out.println(car1);
//		System.out.println(car2);
		
//		Vehicle vehicle = context.getBean(Car.class);
//		vehicle.run();

		Vehicle vehicle = context.getBean(Vehicle.class);
		vehicle.run();
	}
}
