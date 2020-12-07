package com.facensgammingstore.gammingstore.services;


import com.facensgammingstore.gammingstore.entities.OrderItem;
import com.facensgammingstore.gammingstore.repositories.OrderItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository repository;

    public OrderItem insert(OrderItem order) { return repository.save(order); }

}
