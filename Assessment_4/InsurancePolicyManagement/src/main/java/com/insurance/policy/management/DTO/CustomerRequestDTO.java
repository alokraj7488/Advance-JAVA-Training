package com.insurance.policy.management.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequestDTO {
	@NotBlank(message = "Name cannot be empty")
	private String name;
	
	@Email(message = "Email must be valid")
	private String email;
	private Long phoneNumber;
	private String address;
}
