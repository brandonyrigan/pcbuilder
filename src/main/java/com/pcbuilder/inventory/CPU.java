package com.pcbuilder.inventory;

import java.util.UUID;

public class CPU extends Component {
    public CPU(UUID productId, String name, String description, Double price, String rating, Integer inventoryCount) {
        super(productId, name, description, price, rating, inventoryCount);
    }
}
