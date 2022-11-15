package com.pcbuilder.checkout;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShoppingCart {
    List<UUID> cartItems = new ArrayList<UUID>();
    public void addProduct(int uuid) {
        UUID product = getProduct(uuid);
        addToCart(product);
    }
    private UUID getProduct(int uuid) {
        UUID product = null;
        List<UUID> products = new Products().getProducts();
        for (UUID prod: products) {
            if (prod.getuuid() == uuid) {
                product = prod;
                break;
            }
        }
        return product;
    }
    private void addToCart(UUID product) {
        cartItems.add(product);
    }
    public void removeProduct(int uuid) {
        UUID prod = getProduct(uuid);
        cartItems.remove(prod);
    }
    public void showCart() {
        for (UUID prod: cartItems) {
            System.out.println(prod.getName());
        }
    }
}