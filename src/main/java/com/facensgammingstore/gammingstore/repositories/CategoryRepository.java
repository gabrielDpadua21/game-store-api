package com.facensgammingstore.gammingstore.repositories;

import com.facensgammingstore.gammingstore.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
