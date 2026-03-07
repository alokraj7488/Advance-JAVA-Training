package com.insurance.policy.management.exception;

public class CustomerNotFoundException extends RuntimeException{
	public CustomerNotFoundException(String message) {
		super(message);
	}
}
