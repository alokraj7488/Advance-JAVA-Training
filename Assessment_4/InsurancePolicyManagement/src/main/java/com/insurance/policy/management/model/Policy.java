package com.insurance.policy.management.model;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Policy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "policy_number")
	private Integer policyNumber;
	
	@Column(name = "policy_type")
	private String policyType;
	
	@Column(name = "premium_amount")
	private Double premiumAmount;
	
	@Column(name = "coverage_amount")
	private Double coverageAmount;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@Enumerated(EnumType.STRING)
	private PolicyStatus status;		
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	
	public enum PolicyStatus {
		ACTIVE, EXPIRED, CANCELLED
	}
}
