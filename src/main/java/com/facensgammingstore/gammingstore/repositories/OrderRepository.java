package com.facensgammingstore.gammingstore.repositories;

import com.facensgammingstore.gammingstore.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
