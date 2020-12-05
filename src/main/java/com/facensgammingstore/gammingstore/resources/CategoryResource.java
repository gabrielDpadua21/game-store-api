package com.facensgammingstore.gammingstore.resources;

import com.facensgammingstore.gammingstore.DTO.CategoryDTO;
import com.facensgammingstore.gammingstore.entities.Category;
import com.facensgammingstore.gammingstore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource {

    @Autowired
    private CategoryService services;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<Category> list = services.findAll();
        List<CategoryDTO> listDto = list.stream().map(item -> new CategoryDTO(item)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category category = services.findById(id);

        return ResponseEntity.ok().body(category);
    }

}
