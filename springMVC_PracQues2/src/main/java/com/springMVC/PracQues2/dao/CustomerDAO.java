package com.springMVC.PracQues2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springMVC.PracQues2.model.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long>{

}
