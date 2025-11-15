package org.example.map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.dto.Customer;
import org.example.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper

public interface CustomerMastrack {

@Mapping(target = "id",source = "id")
    CustomerEntity customerEntityMapping(Customer customer);

    Customer customerMapping(CustomerEntity customerEntity);

    @Mapping(target = "id",source = "id")
    CustomerEntity customerDtoMapping(Customer customer);








}
