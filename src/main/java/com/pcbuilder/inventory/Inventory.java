package com.pcbuilder.inventory;

import java.util.*;

public class Inventory {
    private static Map<String, Collection<Component>> mapOfInventory;

    public void addToInventory(Component component) {

    }

    public static void removeFromInventory() {

    }

    public static void findFromInventory() {

    }

    public static void calculateTotalItems() {

    }

    private static Collection<Component> cpuList = new ArrayList<>(List.of(
            new CPU("Intel Core I7-13700K", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I7-13700KF", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I5-13600K", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I5-13700KF", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 9 7950X", "Ryzen 9", 439.00, "*****", 20),
            new CPU("AMD Ryzen 9 7900X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 7 7700X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 7 7600X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 5 7600X", "Intel", 439.00, "*****", 20)
    ));

    private static Collection<Component> motherboardList = new ArrayList<>(List.of(
            new CPU("Intel Core I7-13700K", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I7-13700KF", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I5-13600K", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I5-13700KF", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 9 7950X", "Ryzen 9", 439.00, "*****", 20),
            new CPU("AMD Ryzen 9 7900X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 7 7700X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 7 7600X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 5 7600X", "Intel", 439.00, "*****", 20)
    ));

    private static Collection<Component> memoryList = new ArrayList<>(List.of(
            new CPU("Intel Core I7-13700K", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I7-13700KF", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I5-13600K", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I5-13700KF", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 9 7950X", "Ryzen 9", 439.00, "*****", 20),
            new CPU("AMD Ryzen 9 7900X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 7 7700X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 7 7600X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 5 7600X", "Intel", 439.00, "*****", 20)
    ));

    private static Collection<Component> videoCardList = new ArrayList<>(List.of(
            new CPU("Intel Core I7-13700K", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I7-13700KF", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I5-13600K", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I5-13700KF", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 9 7950X", "Ryzen 9", 439.00, "*****", 20),
            new CPU("AMD Ryzen 9 7900X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 7 7700X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 7 7600X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 5 7600X", "Intel", 439.00, "*****", 20)
    ));

    private static Collection<Component> powerSupplyList = new ArrayList<>(List.of(
            new CPU("Intel Core I7-13700K", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I7-13700KF", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I5-13600K", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I5-13700KF", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 9 7950X", "Ryzen 9", 439.00, "*****", 20),
            new CPU("AMD Ryzen 9 7900X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 7 7700X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 7 7600X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 5 7600X", "Intel", 439.00, "*****", 20)
    ));

    private static Collection<Component> storageList = new ArrayList<>(List.of(
            new CPU("Intel Core I7-13700K", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I7-13700KF", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I5-13600K", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I5-13700KF", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 9 7950X", "Ryzen 9", 439.00, "*****", 20),
            new CPU("AMD Ryzen 9 7900X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 7 7700X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 7 7600X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 5 7600X", "Intel", 439.00, "*****", 20)
    ));

    private static Collection<Component> cpuCoolerList = new ArrayList<>(List.of(
            new CPU("Intel Core I7-13700K", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I7-13700KF", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I5-13600K", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I5-13700KF", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 9 7950X", "Ryzen 9", 439.00, "*****", 20),
            new CPU("AMD Ryzen 9 7900X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 7 7700X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 7 7600X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 5 7600X", "Intel", 439.00, "*****", 20)
    ));

    private static Collection<Component> operatingSystemList = new ArrayList<>(List.of(
            new CPU("Intel Core I7-13700K", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I7-13700KF", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I5-13600K", "Intel", 439.00, "*****", 20),
            new CPU("Intel Core I5-13700KF", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 9 7950X", "Ryzen 9", 439.00, "*****", 20),
            new CPU("AMD Ryzen 9 7900X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 7 7700X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 7 7600X", "Intel", 439.00, "*****", 20),
            new CPU("AMD Ryzen 5 7600X", "Intel", 439.00, "*****", 20)
    ));

    static {
        mapOfInventory.put("CPU", cpuList);
    }
}
