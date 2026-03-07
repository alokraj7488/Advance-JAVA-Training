package com.insurance.policy.management.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.policy.management.DTO.CustomerRequestDTO;
import com.insurance.policy.management.DTO.CustomerResponseDTO;
import com.insurance.policy.management.DTO.PolicyRequestDTO;
import com.insurance.policy.management.DTO.PolicyResponseDTO;
import com.insurance.policy.management.service.InsuranceService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class InsuranceController {
	private final InsuranceService service;

	
	@PostMapping("/customers")
	public CustomerResponseDTO registerCustomer(@Valid @RequestBody CustomerRequestDTO dto) {
		return service.createCustomer(dto);
	}

	@GetMapping("/customers")
	public List<CustomerResponseDTO> getAllCustomers() {
		return service.getAllCustomers();
	}

	@GetMapping("/customers/{id}")
	public CustomerResponseDTO getCustomerById(@PathVariable Long id) {
		return service.getCustomerById(id);
	}

	@PostMapping("/policies")
	public PolicyResponseDTO createPolicy(@Valid @RequestBody PolicyRequestDTO dto) {
		return service.createPolicy(dto);
	}

	@GetMapping("/policies")
	public Page<PolicyResponseDTO> getAllPolicies(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc") String direction) {
		Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		return service.getAllPolicies(PageRequest.of(page, size, sort));
	}

	@GetMapping("/policies/{id}")
	public PolicyResponseDTO getPolicyById(@PathVariable Long id) {
		return service.getPolicyById(id);
	}

	@PutMapping("/policies/{id}")
	public PolicyResponseDTO updatePolicy(@PathVariable Long id, @Valid @RequestBody PolicyRequestDTO dto) {
		return service.updatePolicy(id, dto);
	}

	@DeleteMapping("/policies/{id}")
	public void cancelPolicy(@PathVariable Long id) {
		service.cancelPolicy(id);
	}

	
	@GetMapping("/policies/type/{type}") 
	public List<PolicyResponseDTO> getPoliciesByType(@PathVariable String type) { // [cite: 105]
		return service.getPoliciesByType(type);
	}

	@GetMapping("/policies/premium")
	public List<PolicyResponseDTO> getPoliciesByPremiumRange(@RequestParam("min") Double min,
			@RequestParam("max") Double max) {
		return service.getPoliciesByPremiumRange(min, max);
	}
}
