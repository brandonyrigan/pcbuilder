package com.pcbuilder.inventory;

import java.util.UUID;

public class PowerSupply extends Component {
    public PowerSupply(UUID productId, String name, String description, Double price, String rating, Integer inventoryCount) {
        super(productId, name, description, price, rating, inventoryCount);
    }
}
