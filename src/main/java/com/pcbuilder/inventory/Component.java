package com.pcbuilder.inventory;

import java.util.UUID;

public abstract class Component {
    UUID productId;
    String name;
    String description;
    Double price;
    String rating;
    Integer inventoryCount;

    public Component(UUID productId, String name, String description, Double price, String rating, Integer inventoryCount) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.inventoryCount = inventoryCount;
    }

    public UUID getProductId() {
        return productId;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(Integer inventoryCount) {
        this.inventoryCount = inventoryCount;
    }
}
