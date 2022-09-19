package com.orderapi.controllers;

import com.orderapi.configurations.Constants;
import com.orderapi.configurations.OperationResult;
import com.orderapi.entities.Customer;
import com.orderapi.services.CustomerService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAdministrator(@RequestBody @Valid Customer customer) {
        return new ResponseEntity<>(new OperationResult(Constants.SUCCESS_STATUS, Constants.CREATE_RESOURCE_SUCCESS_MESSAGE, customerService.createCustomer(customer)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> listAllCustomers() {
        return new ResponseEntity<>(new OperationResult(Constants.SUCCESS_STATUS, Constants.CREATE_RESOURCE_SUCCESS_MESSAGE, customerService.listCustomers()), HttpStatus.CREATED);
    }
}
