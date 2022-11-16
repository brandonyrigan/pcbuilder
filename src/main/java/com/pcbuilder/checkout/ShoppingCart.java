package com.pcbuilder.checkout;

import com.pcbuilder.build.Build;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShoppingCart {
    List<Build> cartItems = new ArrayList<Build>();

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