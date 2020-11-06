package com.facensgammingstore.gammingstore.repositories;

import com.facensgammingstore.gammingstore.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
