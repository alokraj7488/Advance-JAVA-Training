package com.insurance.policy.management.DTO;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PolicyRequestDTO {
	@NotNull(message = "policyNumber cannot be blank")
	private Integer policyNumber;
	
	private String policyType;
	
	@Positive(message = "premiumAmount must be positive")
	private Double premiumAmount;
	
	@Positive(message = "coverageAmount must be positive")
	private Double coverageAmount;
	
	@NotNull(message = "startDate cannot be null")
	private LocalDate startDate;
	
	private LocalDate endDate;
	private Long cutomerId;
	
}
