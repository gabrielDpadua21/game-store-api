package com.facensgammingstore.gammingstore.DTO;

public class ProductCategoryDTO {

    private String name;
    private String description;
    private Double price;
    private String imageUri;
    private Long categoryId;

    public ProductCategoryDTO() {}

    public ProductCategoryDTO(Long id, String name, String description, Double price, String imageUri, Long categoryId) {
        name = this.name;
        description = this.description;
        price = this.price;
        imageUri = this.imageUri;
        categoryId = this.categoryId;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
