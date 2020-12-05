package com.facensgammingstore.gammingstore.DTO;

import com.facensgammingstore.gammingstore.entities.Product;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imageUri;
    private List<CategoryDTO> categories;

    public ProductDTO() {}

    public ProductDTO(Product obj) {
        id = obj.getId();
        name = obj.getName();
        description = obj.getDescription();
        price = obj.getPrice();
        imageUri = obj.getImageUri();
        categories = obj.getCategories().stream().map(item -> new CategoryDTO(item)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
}
