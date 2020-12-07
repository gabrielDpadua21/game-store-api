package com.facensgammingstore.gammingstore.DTO;

import com.facensgammingstore.gammingstore.entities.OrderItem;
import com.facensgammingstore.gammingstore.entities.Product;

import java.io.Serializable;

public class OrderItemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer quantity;
    private Double price;
    private ProductDTO product;

    public OrderItemDTO() {}

    public OrderItemDTO(OrderItem obj) {
        quantity = obj.getQuantity();
        price = obj.getPrice();
        product = new ProductDTO(obj.getProduct());
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
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
