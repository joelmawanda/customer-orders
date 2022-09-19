package com.orderapi.services;

import com.orderapi.entities.Customer;
import com.orderapi.entities.Item;
import com.orderapi.entities.Orders;
import com.orderapi.repositories.OrdersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrdersService {

    private final ItemService itemService;
    private final OrdersRepository ordersRepository;

    public Orders createOrder(Orders order) {
        log.info("creating new order...");

        Orders created_order = ordersRepository.save(order);
        order.getItem().stream()
                .forEach(item -> {
                    itemService.createItem(item);
                });

        return created_order;
    }

//    public Customer createCustomer(Customer customer) {
//        log.info("creating new order...");
//
//        Customer created_customer = customerRepository.save(customer);
//
//        customer.getOrders().stream()
//                .forEach(order -> {
//                    ordersService.createOrder(order);
//                });
//
//        return created_customer;
//    }
}
