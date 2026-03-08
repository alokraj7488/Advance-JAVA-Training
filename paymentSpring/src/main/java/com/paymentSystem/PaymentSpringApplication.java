package com.paymentSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PaymentSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = 
				SpringApplication.run(PaymentSpringApplication.class, args);
		
		 PaymentService service =
	                context.getBean(PaymentService.class);
		 
		 service.makePayment(1500);
	}

}
