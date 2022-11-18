package com.pcbuilder.checkout;

import com.pcbuilder.build.Build;

import java.util.*;

import static com.pcbuilder.menus.DecorateEnum.*;

public class ShoppingCart {
    public Map<Integer, Build> cartItems = new HashMap<>();
    private int buildCount = 1;

    public void addToCart(Build built) {
        cartItems.put(buildCount, built);
        buildCount++;
    }

    public void removeFromCart(int buildNumberSelected) {
        cartItems.remove(buildNumberSelected);
        buildCount--;
    }
    public void cartSize() {
            System.out.println(cartItems.size());
    }

    public void showItemsInCart() {
        System.out.println(RENDER_TXT_SPACE.getDecoration() + "Items in cart: ");
        for (Map.Entry<Integer, Build> build : cartItems.entrySet()) {
            System.out.println(RENDER_TXT_SPACEx2.getDecoration() + "Custom Build " + (buildCount - 1) + " -- [" + build.getValue().getBuildUUID() + "]");
        }
        System.out.println( RENDER_SHORT_BAR.getDecoration() );
    }

    public Map<Integer, Build> getCartItems() {
        return cartItems;
    }
}