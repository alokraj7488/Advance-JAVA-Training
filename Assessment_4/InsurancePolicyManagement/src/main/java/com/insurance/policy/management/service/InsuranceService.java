package com.insurance.policy.management.service;

import com.insurance.policy.management.DTO.*;
import com.insurance.policy.management.exception.*;
import com.insurance.policy.management.mapper.*;
import com.insurance.policy.management.model.Customer;
import com.insurance.policy.management.model.Policy;
import com.insurance.policy.management.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InsuranceService {
	private final CustomerRepository customerRepository;
	private final PolicyRepository policyRepository;

	public CustomerResponseDTO createCustomer(CustomerRequestDTO dto) {
		Customer saved = customerRepository.save(CustomerMapper.toEntity(dto));
		return CustomerMapper.toDTO(saved);
	}

	public List<CustomerResponseDTO> getAllCustomers() {
		return customerRepository.findAll().stream().map(CustomerMapper::toDTO).collect(Collectors.toList());
	}

	public CustomerResponseDTO getCustomerById(Long id) {
		return customerRepository.findById(id).map(CustomerMapper::toDTO)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
	}

	public PolicyResponseDTO createPolicy(PolicyRequestDTO dto) {
		Customer customer = customerRepository.findById(dto.getCutomerId())
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

		Policy policy = PolicyMapper.toEntity(dto);
		policy.setCustomer(customer);
		policy.setStatus(Policy.PolicyStatus.ACTIVE);
		return PolicyMapper.toDTO(policyRepository.save(policy));
	}

	public Page<PolicyResponseDTO> getAllPolicies(Pageable pageable) { 
		return policyRepository.findAll(pageable).map(PolicyMapper::toDTO);
	}

	public PolicyResponseDTO getPolicyById(Long id) {
		return policyRepository.findById(id).map(PolicyMapper::toDTO)
				.orElseThrow(() -> new PolicyNotFoundException("Policy not found"));
	}

	public PolicyResponseDTO updatePolicy(Long id, PolicyRequestDTO dto) { 
		Policy policy = policyRepository.findById(id)
				.orElseThrow(() -> new PolicyNotFoundException("Policy not found"));
		policy.setPolicyNumber(dto.getPolicyNumber());
		policy.setPolicyType(dto.getPolicyType());
		policy.setPremiumAmount(dto.getPremiumAmount());
		return PolicyMapper.toDTO(policyRepository.save(policy));
	}

	public void cancelPolicy(Long id) {
		Policy policy = policyRepository.findById(id)
				.orElseThrow(() -> new PolicyNotFoundException("Policy not found"));
		policy.setStatus(Policy.PolicyStatus.CANCELLED);
		policyRepository.save(policy);
	}

	public List<PolicyResponseDTO> getPoliciesByType(String type) {
		return policyRepository.findByPolicyType(type).stream().map(PolicyMapper::toDTO).collect(Collectors.toList());
	}

	public List<PolicyResponseDTO> getPoliciesByPremiumRange(Double min, Double max) {
		return policyRepository.findByPremiumAmountBetween(min, max).stream().map(PolicyMapper::toDTO)
				.collect(Collectors.toList());
	}
}
