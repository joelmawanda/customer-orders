package com.orderapi.repositories;

import com.orderapi.entities.Customer;
import com.orderapi.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository  extends JpaRepository<Orders, Integer> {
}
