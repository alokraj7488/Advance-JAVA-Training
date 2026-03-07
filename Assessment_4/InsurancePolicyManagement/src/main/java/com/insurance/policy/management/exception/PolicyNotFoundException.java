package com.insurance.policy.management.exception;

public class PolicyNotFoundException extends RuntimeException {
	public PolicyNotFoundException(String message) {
		super(message);
	}
}
