package com.insurance.policy.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.insurance.policy.management.model.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long>{
	List<Policy> findByPolicyType(String policyType);
	List<Policy> findByCustomerId(Long customerId);
	List<Policy> findByPremiumAmountBetween(Double min, Double max);
	
	@Query("SELECT p FROM Policy p WHERE p.customer.email = :email")
	List<Policy> findPolicyByCustomerEmail(@Param("email") String email);
}
