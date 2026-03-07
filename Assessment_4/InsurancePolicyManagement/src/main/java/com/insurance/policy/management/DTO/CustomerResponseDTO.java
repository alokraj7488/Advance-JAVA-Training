package com.insurance.policy.management.DTO;

import lombok.Data;

@Data
public class CustomerResponseDTO {
	private Long id;
	private String name;
	private String email;
	private Long phoneNumber;
	private String address;
}
