package com.orderapi.services;

import com.orderapi.entities.Customer;
import com.orderapi.entities.Orders;
import com.orderapi.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private OrdersService ordersService;

    private final CustomerRepository customerRepository;
//    private final OrdersService ordersService;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

//    public Customer createCustomer(Customer customer) {
//
//        log.debug("create customer...");
//        return customerRepository.save(customer);
//    }

    public Customer getCustomersr(Customer customer) {

        log.debug("create customer...");
        return customerRepository.save(customer);
    }

    public List<Customer> listCustomers() {
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer) {
        log.info("creating new order...");

        Customer created_customer = customerRepository.save(customer);

        Orders orders = new Orders();
        orders.setOrderNumber("2");
//        orders.setOrderNumber(customer.getOrders());
        orders.setCustomers(created_customer);

        log.info("adding new customer data to the register");

        ordersService.createOrder(orders);

//        created_customer.setOrders((Set<Orders>) orders);

        return created_customer;
    }
}
