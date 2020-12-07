package com.facensgammingstore.gammingstore.DTO;

import java.io.Serializable;

public class OrderInsertDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long productId;
    private Long userId;

    public OrderInsertDTO() {}

    public OrderInsertDTO(Long productId, Long userId) {
        productId = this.productId;
        userId = this.userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
