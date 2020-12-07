package com.facensgammingstore.gammingstore.resources;

import com.facensgammingstore.gammingstore.DTO.*;
import com.facensgammingstore.gammingstore.entities.*;
import com.facensgammingstore.gammingstore.entities.enums.OrderStatus;
import com.facensgammingstore.gammingstore.services.OrderItemService;
import com.facensgammingstore.gammingstore.services.OrderService;
import com.facensgammingstore.gammingstore.services.ProductService;
import com.facensgammingstore.gammingstore.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService services;

    @Autowired
    private ProductService serviceProduct;

    @Autowired
    private UserServices serviceUser;

    @Autowired
    private OrderItemService serviceOrderItem;

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

    @PostMapping
    public ResponseEntity<OrdersDTO> insert(@RequestBody OrderInsertDTO postObj) {
        Product objProduct = serviceProduct.findById(postObj.getProductId());
        User objUser = serviceUser.findById(postObj.getUserId());
        Order objOrder = services.insert(new Order(null, Instant.now(), OrderStatus.PAID, objUser));
        OrderItem objOrderItem = serviceOrderItem.insert(new OrderItem(objOrder, objProduct, 1, objProduct.getPrice()));

        OrdersDTO objDto = new OrdersDTO(objOrder);

        return ResponseEntity.ok().body(objDto);
    }



}
