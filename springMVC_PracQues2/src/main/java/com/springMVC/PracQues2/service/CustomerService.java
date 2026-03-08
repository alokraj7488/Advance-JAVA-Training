package com.springMVC.PracQues2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springMVC.PracQues2.dao.CustomerDAO;
import com.springMVC.PracQues2.model.Customer;

@Service
public class CustomerService {

    private final CustomerDAO customerDAO;
    
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }

    public void saveCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return customerDAO.findById(id)
                .orElse(null);
    }

    public void deleteCustomer(Long id) {
        customerDAO.deleteById(id);
    }
}