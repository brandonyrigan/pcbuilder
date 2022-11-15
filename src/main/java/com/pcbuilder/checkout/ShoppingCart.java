package com.pcbuilder.checkout;

import com.pcbuilder.build.Build;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShoppingCart {
    List<Build> cartItems = new ArrayList<Build>();
    public void addProduct(int uuid) {
        Build product = getProduct(uuid);
        addToCart(product);
    }
    private Build getProduct(int uuid) {
        Build product = null;
        List<Build> products = new Products().getProducts();
        for (Build prod: products) {
            if (prod.getuuid() == uuid) {
                product = prod;
                break;
            }
        }
        return product;
    }
    private void addToCart(Build product) {
        cartItems.add(product);
    }
    public void removeProduct(int uuid) {
        Build prod = getProduct(uuid);
        cartItems.remove(prod);
    }
    public void showCart() {
        for (Build prod: cartItems) {
            System.out.println(prod.getName());
        }
    }
}