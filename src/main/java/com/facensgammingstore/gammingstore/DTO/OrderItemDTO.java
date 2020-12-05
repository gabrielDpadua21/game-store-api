package com.facensgammingstore.gammingstore.DTO;

import com.facensgammingstore.gammingstore.entities.OrderItem;

import java.io.Serializable;

public class OrderItemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer quantity;
    private Double price;

    public OrderItemDTO() {}

    public OrderItemDTO(OrderItem obj) {
        quantity = obj.getQuantity();
        price = obj.getPrice();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
