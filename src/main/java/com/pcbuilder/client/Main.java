package com.pcbuilder.client;

import com.pcbuilder.inventory.Inventory;

public class Main {

    public static void main(String[] args) {
        Inventory inventoryInstance = new Inventory();
        System.out.println(inventoryInstance.getMapOfInventory());
    }
}