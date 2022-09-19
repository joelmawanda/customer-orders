package com.orderapi.services;

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

//    public Orders createOrder(Orders order) {
//
//        log.debug("create order...");
//        return ordersRepository.save(order);
//    }
    public Orders createOrder(Orders order) {
        log.info("creating new order...");

        Orders created_order = ordersRepository.save(order);

        //Item item = new Item();

        //log.info("adding new qorder data");

        //itemService.createItem(item);

        return created_order;
    }
}
