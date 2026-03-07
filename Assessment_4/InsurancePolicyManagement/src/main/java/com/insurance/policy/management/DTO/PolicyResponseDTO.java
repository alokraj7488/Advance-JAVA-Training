package com.insurance.policy.management.DTO;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PolicyResponseDTO {
	private Long id;
	private Integer policyNumber;
	private String policyType;
	private Double premiumAmount;
	private Double coverageAmount;
	private LocalDate startDate;
	private LocalDate endDate;
	private String status;
	
	private CustomerResponseDTO customerResponseDTO;
}
