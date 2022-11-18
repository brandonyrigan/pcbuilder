package com.pcbuilder.inventory;

import java.util.UUID;

public class Motherboard extends Component {
    public Motherboard(UUID productId, String name, String description, Double price, String rating, Integer inventoryCount) {
        super(productId, name, description, price, rating, inventoryCount);
    }
}
