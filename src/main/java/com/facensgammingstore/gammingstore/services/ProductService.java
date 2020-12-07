package com.facensgammingstore.gammingstore.services;

import com.facensgammingstore.gammingstore.entities.Product;
import com.facensgammingstore.gammingstore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);

        return obj.get();
    }

    public Product insert(Product product) {
        return repository.save(product);
    }

    public Product update(Product product) {
        return repository.save(product);
    }

    public void delete (Product product) {
        repository.delete(product);
    }

}
