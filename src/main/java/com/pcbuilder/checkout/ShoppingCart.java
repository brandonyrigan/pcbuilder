package com.pcbuilder.checkout;

import com.pcbuilder.build.Build;

import java.util.*;

public class ShoppingCart {
    public Map<Integer, Build> cartItems = new HashMap<>();
    private int buildCount = 1;

    public void addToCart(Build built) {
        cartItems.put(buildCount, built);
        buildCount++;
    }

    public void removeFromCart(int buildNumberSelected) {
        cartItems.remove(buildNumberSelected);
    }
    public void cartSize() {
            System.out.println(cartItems.size());
    }

    public void showItemsInCart() {
        for (Map.Entry<Integer, Build> build : cartItems.entrySet()) {
            System.out.println("[" + build.getKey() + "]" + " " + build.getValue());
        }
    }

    public Map<Integer, Build> getCartItems() {
        return cartItems;
    }
}