package com.orderapi.services;

import com.orderapi.entities.Customer;
import com.orderapi.entities.Item;
import com.orderapi.entities.Orders;
import com.orderapi.repositories.CustomerRepository;
import com.orderapi.repositories.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item createItem(Item item) {

        log.debug("create item...");
        return itemRepository.save(item);
    }


}
