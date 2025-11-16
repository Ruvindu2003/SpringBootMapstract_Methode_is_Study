package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.entity.CustomerEntity;
import org.example.map.CustomerMastrack;
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
    private final CustomerMastrack customerMastrack;



    @Override
    public List<Customer> getCustomers() {
        List<CustomerEntity> customerEntities= customerRepository.findAll();
        return customerMastrack. toDtoList(customerEntities);
    }

    @Override
    public Optional<Customer> getCustomer(Long id) {
        if (id == null) {
            return null;
        }
        Optional<CustomerEntity> customerEntity=customerRepository.findById(id);
      return customerEntity.map(customerEntity1 -> customerMastrack.toDto(customerEntity1));

    }

    @Override
    public CustomerEntity addCustomer(Customer customer) {
        if (customer == null) {
            return null;
        }
        return customerRepository.save(customerMastrack.toEntity(customer));
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerRepository.save(customerMastrack.toEntityDto(customer)) != null;
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
