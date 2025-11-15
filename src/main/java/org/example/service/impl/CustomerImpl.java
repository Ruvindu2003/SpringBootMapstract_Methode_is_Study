package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.entity.CustomerEntity;
import org.example.repsitory.CustomerRepository;
import org.example.service.CustomerService;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CustomerImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ObjectMapper objectMapper;


    @Override
    public List<Customer> getCustomers() {
        List<CustomerEntity> customerEntities= customerRepository.findAll();
        return (List<Customer>) customerEntities.stream().map(customerEntity -> objectMapper.convertValue(customerEntity,Customer.class));

    }

    @Override
    public Optional<Customer> getCustomer(Long id) {
        if (id == null) {
            return null;
        }
        Optional<CustomerEntity> customerEntity=customerRepository.findById(id);
      return customerEntity.map(customerEntity1 -> objectMapper.convertValue(customerEntity1,Customer.class));

    }

    @Override
    public boolean addCustomer(Customer customer) {
        if (customer == null) {
            return false;
        }
        return objectMapper.convertValue(customer,CustomerEntity.class) != null;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return objectMapper.convertValue(customer,CustomerEntity.class) != null;
    }

    @Override
    public boolean deleteCustomer(Long id) {
       if (id==null){
           return false;
       }
customerRepository.deleteById(id);

       return true;

    }
}
