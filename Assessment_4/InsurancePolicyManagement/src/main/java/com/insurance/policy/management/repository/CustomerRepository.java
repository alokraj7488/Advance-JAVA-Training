package com.insurance.policy.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.policy.management.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
