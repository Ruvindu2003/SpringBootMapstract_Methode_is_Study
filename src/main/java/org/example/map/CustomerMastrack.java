package org.example.map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.dto.Customer;
import org.example.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface CustomerMastrack {

@Mapping(target = "id",source = "id")
    CustomerEntity customerEntityMapping(Customer customer);

    CustomerEntity toEntity(Customer customer);

    @Mapping(target = "id",source = "id")
        Customer toDto(CustomerEntity customerEntity);

    List<Customer> toDtoList(List<CustomerEntity> customerEntities);


    CustomerEntity toEntityDto(Customer customer);













}
