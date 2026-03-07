package com.insurance.policy.management.mapper;

import com.insurance.policy.management.DTO.PolicyRequestDTO;
import com.insurance.policy.management.DTO.PolicyResponseDTO;
import com.insurance.policy.management.model.Policy;

public class PolicyMapper {
	public static Policy toEntity(PolicyRequestDTO dto) { 
        Policy policy = new Policy();
        policy.setPolicyNumber(dto.getPolicyNumber());
        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setCoverageAmount(dto.getCoverageAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());
        return policy;
    }

    public static PolicyResponseDTO toDTO(Policy policy) {
        PolicyResponseDTO dto = new PolicyResponseDTO();
        dto.setId(policy.getId());
        dto.setPolicyNumber(policy.getPolicyNumber());
        dto.setPolicyType(policy.getPolicyType());
        dto.setPremiumAmount(policy.getPremiumAmount());
        dto.setCoverageAmount(policy.getCoverageAmount());
        dto.setStartDate(policy.getStartDate());
        dto.setEndDate(policy.getEndDate());
        if (policy.getStatus() != null) {
            dto.setStatus(policy.getStatus().name());
        }
        dto.setCustomerResponseDTO(CustomerMapper.toDTO(policy.getCustomer())); 
        return dto;
    }
}
