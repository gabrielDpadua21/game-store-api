package com.facensgammingstore.gammingstore.DTO;

import com.facensgammingstore.gammingstore.entities.Order;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class OrdersDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Instant createdAt;
    private Integer orderStatus;
    private UserDTO client;
    private List<OrderItemDTO> items;

    public OrdersDTO(){}

    public OrdersDTO(Order obj) {
        id = obj.getId();
        createdAt = obj.getCreatedAt();
        orderStatus = obj.getOrderStatus().getCode();
        client = new UserDTO(obj.getClient());
        items = obj.getItems().stream().map(item -> new OrderItemDTO(item)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public UserDTO getClient() {
        return client;
    }

    public void setClient(UserDTO client) {
        this.client = client;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}
