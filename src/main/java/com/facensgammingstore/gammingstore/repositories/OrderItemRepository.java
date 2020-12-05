package com.facensgammingstore.gammingstore.repositories;

import com.facensgammingstore.gammingstore.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
