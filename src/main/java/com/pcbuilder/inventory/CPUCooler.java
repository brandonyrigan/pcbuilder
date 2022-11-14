package com.pcbuilder.inventory;

import java.util.UUID;

public class CPUCooler extends Component {
    public CPUCooler(UUID productId, String name, String description, Double price, String rating, Integer inventoryCount) {
        super(productId, name, description, price, rating, inventoryCount);
    }
}
