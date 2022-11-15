package com.pcbuilder.checkout;

import com.pcbuilder.build.Build;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShoppingCart {
    List<Build> cartItems = new ArrayList<Build>();
//    public void addProduct(int uuid) {
//        Build product = getBuild(uuid);
//        addToCart(product);
//    }
//    private Build getProduct(int uuid) {
//        Build product = null;
//        List<Build> products = new Products().getProducts();
//        for (Build prod: products) {
//            if (prod.getuuid() == uuid) {
//                product = prod;
//                break;
//            }
//        }
//        return product;
//   }
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