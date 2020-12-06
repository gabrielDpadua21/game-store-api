package com.facensgammingstore.gammingstore.resources;

import com.facensgammingstore.gammingstore.DTO.ProductCategoryDTO;
import com.facensgammingstore.gammingstore.DTO.ProductDTO;
import com.facensgammingstore.gammingstore.DTO.UserDTO;
import com.facensgammingstore.gammingstore.entities.Category;
import com.facensgammingstore.gammingstore.entities.Product;
import com.facensgammingstore.gammingstore.services.CategoryService;
import com.facensgammingstore.gammingstore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/product")
public class ProductResource {

    @Autowired
    private ProductService service;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<Product> list = service.findAll();
        List<ProductDTO> listDto = list.stream().map(item -> new ProductDTO(item)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product product = service.findById(id);
        return ResponseEntity.ok().body(product);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductCategoryDTO postObj) {
        Category objCategory = categoryService.findById(postObj.getCategoryId());
        Product newProduct = new Product(null, postObj.getName(), postObj.getDescription(), postObj.getPrice(), postObj.getImageUri());
        newProduct.getCategories().add(objCategory);
        Product objProduct = service.insert(newProduct);
        ProductDTO objDto = new ProductDTO(objProduct);
        return ResponseEntity.ok().body(objDto);
    }

}
