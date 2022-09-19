package com.orderapi.controllers;

import com.orderapi.configurations.Constants;
import com.orderapi.configurations.OperationResult;
import com.orderapi.entities.Customer;
import com.orderapi.services.CustomerService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@RequestBody @Valid Customer customer) {
        return new ResponseEntity<>(new OperationResult(Constants.SUCCESS_STATUS, Constants.CREATE_RESOURCE_SUCCESS_MESSAGE, customerService.createCustomer(customer)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> listAllCustomers() {
        return new ResponseEntity<>(new OperationResult(Constants.SUCCESS_STATUS, Constants.CREATE_RESOURCE_SUCCESS_MESSAGE, customerService.listCustomers()), HttpStatus.CREATED);
    }
}
