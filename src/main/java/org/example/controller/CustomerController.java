package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/customer")
@RestController
@CrossOrigin
@RequiredArgsConstructor


public class CustomerController {

    private final CustomerService customerService;


    @PostMapping("/add")

    public ResponseEntity<Boolean> addCustomer(@RequestBody Customer customer) {
        Boolean success = customerService.addCustomer(customer);
        if (success) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/all")
    ResponseEntity<List<Customer>> getAllCustomers() {
        Customer customer = customerService.getCustomers().get(0);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }return ResponseEntity.ok(Collections.singletonList(customer));


    }
    @GetMapping("/{id}")

    public ResponseEntity<Customer>getCustomer(@PathVariable Long id) {
        Optional<Customer> customer=customerService.getCustomer(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(customer.get());

    }
    @GetMapping("/")

    public ResponseEntity<Boolean>updateCustomer(@RequestBody Customer customer) {
        boolean result = customerService.updateCustomer(customer);
        if (result) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }
    @DeleteMapping("/{id}")

    public ResponseEntity<Boolean>deleteCustomer(@PathVariable Long id) {
        boolean result = customerService.deleteCustomer(id);

        if (result) {

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
