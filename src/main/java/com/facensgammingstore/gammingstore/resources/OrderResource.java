package com.facensgammingstore.gammingstore.resources;

import com.facensgammingstore.gammingstore.DTO.OrdersDTO;
import com.facensgammingstore.gammingstore.entities.Order;
import com.facensgammingstore.gammingstore.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService services;

    @GetMapping
    public ResponseEntity<List<OrdersDTO>> findAll() {
        List<Order> list = services.findAll();
        List<OrdersDTO> listDto = list.stream().map(item -> new OrdersDTO(item)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order order = services.findById(id);

        return ResponseEntity.ok().body(order);
    }



}
