package com.orderapi.services;

import com.orderapi.entities.Customer;
import com.orderapi.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final OrdersService ordersService;

    public Customer getCustomer(Customer customer) {

        log.debug("create customer...");
        return customerRepository.save(customer);
    }

    public List<Customer> listCustomers() {
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer) {
        log.info("creating new order...");

        Customer created_customer = customerRepository.save(customer);

        customer.getOrders().stream()
                .forEach(order -> {
                    ordersService.createOrder(order);
                });

        return created_customer;
    }
}
