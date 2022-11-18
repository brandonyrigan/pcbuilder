package com.pcbuilder.inventory;

import java.util.UUID;

public class Memory extends Component {
    public Memory(UUID productId, String name, String description, Double price, String rating, Integer inventoryCount) {
        super(productId, name, description, price, rating, inventoryCount);
    }
}
