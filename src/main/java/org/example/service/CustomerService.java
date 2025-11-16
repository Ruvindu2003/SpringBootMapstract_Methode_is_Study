package org.example.service;

import org.example.dto.Customer;
import org.example.entity.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerService {


    List<Customer> getCustomers();
    Optional<Customer> getCustomer(Long id);
    CustomerEntity addCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(Long id);
}
