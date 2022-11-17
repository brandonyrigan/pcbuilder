package com.pcbuilder.checkout;

import com.pcbuilder.build.Build;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShoppingCart {
    double priceTotals = 100.00; // temporary hardcode
    public List<Build> cartItems = new ArrayList<Build>();

    public ShoppingCart(){}

    private void addToCart(Build built) {
        cartItems.add(built);
    }

    public void removeFromCart(UUID builtId) {
        for (Build built: cartItems) {
            if (built.getBuildUUID() == builtId) {
                cartItems.remove(builtId);
            }
        }
    }
    public void cartSize() {
            System.out.println(cartItems.size());
    }
}