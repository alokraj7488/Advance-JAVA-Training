package com.insurance.policy.management.mapper;

import com.insurance.policy.management.DTO.CustomerRequestDTO;
import com.insurance.policy.management.DTO.CustomerResponseDTO;
import com.insurance.policy.management.model.Customer;

public class CustomerMapper {
	public static Customer toEntity(CustomerRequestDTO customerRequestDTO) {
		Customer customer = new Customer();
		customer.setName(customerRequestDTO.getName());
		customer.setEmail(customerRequestDTO.getEmail());
		customer.setPhoneNumber(customerRequestDTO.getPhoneNumber());
		customer.setAddress(customerRequestDTO.getAddress());
		return customer;
	}
	
	public static CustomerResponseDTO toDTO(Customer customer) {
        if (customer == null) return null;
        CustomerResponseDTO dto = new CustomerResponseDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setPhoneNumber(customer.getPhoneNumber());
        dto.setAddress(customer.getAddress());
        return dto;
    }
}
