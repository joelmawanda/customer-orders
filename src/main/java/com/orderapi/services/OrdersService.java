package com.orderapi.services;

import com.orderapi.entities.Customer;
import com.orderapi.entities.Item;
import com.orderapi.entities.Orders;
import com.orderapi.repositories.CustomerRepository;
import com.orderapi.repositories.OrdersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrdersService {

    @Autowired
    private ItemService itemService;

    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

//    public Orders createOrder(Orders order) {
//
//        log.debug("create order...");
//        return ordersRepository.save(order);
//    }

    public Orders createOrder(Orders order) {
        log.info("creating new order...");

        Orders created_order = ordersRepository.save(order);

        Item item = new Item();

        log.info("adding new qorder data");

        itemService.createItem(item);

        return created_order;
    }
}