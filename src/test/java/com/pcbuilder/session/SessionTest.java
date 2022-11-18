package com.pcbuilder.session;

import com.pcbuilder.build.Build;
import com.pcbuilder.checkout.ShoppingCart;
import com.pcbuilder.inventory.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SessionTest {
    private Session session;
    private String[] customerInfo;
    Map<String, String> sessionBuild;
    private Build build;

    @BeforeEach
    void setUp() {
        customerInfo = new String[] {"firstName", "lastName", "email"};
        session = new Session(customerInfo);
        CPU cpu = new CPU(UUID.randomUUID(), "Intel Core I9-13900K", "24-Core, 3.0 GHz, 125W, Intel UHD Graphics 770", 659.00, "*****", 20);
        Motherboard motherboard = new Motherboard(UUID.randomUUID(), "MSI MPG Z590 GAMING FORCE ATX Intel", "LGA 1200, ATX, 128GB, 4x288pin(DDR4), Intel Z590", 176.29, "****", 20);
        Memory memory = new Memory(UUID.randomUUID(), "G.SKILL Ripjaws V Series", "32GB (2 x 16GB) 288-Pin PC RAM DDR4 3200 (PC4 25600)", 84.99, "*****", 20);
        VideoCard videoCard = new VideoCard(UUID.randomUUID(), "ASUS ROG Strix GeForce RTX 3050", "GeForce RTX 3050 8GB 1890 MHz PCI Express 4.0", 179.99, "*****", 20);
        Case buildCase = new Case(UUID.randomUUID(), "Corsair 4000D Airflow", "ATX Mid Tower Black Steel / Plastic/ Tempered Glass", 89.99, "*****", 20);
        PowerSupply powerSupply = new PowerSupply(UUID.randomUUID(), "Thermaltake Smart 430W", "80+ Black Continuous Power ATX 12V V2.3/EPS 12V Active PFC Power Supply", 29.00, "*****", 20);
        Storage storage = new Storage(UUID.randomUUID(), "Samsung EVO 970", "1TB PCIe Gen3 x4 NVMe M.2-2280 Internal Solid State Drive with V-NAND Technology & 1024MB Cache", 219.99, "*****", 20);
        CPUCooler cpuCooler = new CPUCooler(UUID.randomUUID(), "Cooler Master Hyper 212 EVO V2", "CPU Air Cooler with SickleFlow 120, PWM Fan, Direct Contact Technology, 4 Copper Heat Pipes", 42.99, "*****", 20);
        build = new Build(UUID.randomUUID(), UUID.randomUUID(), "guest", cpu, cpuCooler, videoCard, motherboard, powerSupply, memory, storage, buildCase);

        sessionBuild = session.sessionBuild;
        sessionBuild.put("CPU", "name,"+ cpu.getProductId().toString());
        sessionBuild.put("Motherboard", "name,"+motherboard.getProductId());
        sessionBuild.put("Memory", "name,"+memory.getProductId().toString());
        sessionBuild.put("VideoCard", "name,"+videoCard.getProductId().toString());
        sessionBuild.put("Case", "name,"+buildCase.getProductId().toString());
        sessionBuild.put("PowerSupply", "name,"+powerSupply.getProductId().toString());
        sessionBuild.put("Storage", "name,"+storage.getProductId().toString());
        sessionBuild.put("CPUCooler", "name,"+cpuCooler.getProductId().toString());
    }

    @Test
    void testComposeBuild_Returns_New_Build() {
        Build actual = session.composeBuild(session);

        assertNotNull(actual);
    }

    @Test
    void testCreateNewShoppingCart_Returns_New_ShoppingCart() {
        ShoppingCart expected = new ShoppingCart();
        ShoppingCart actual = session.createNewShoppingCart();

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void testFetchMapOfInventory_Returns_Inventory() {
        Map<String, Collection<Component>> expected = Inventory.mapOfInventory;
        Map<String, Collection<Component>> actual = session.fetchMapOfInventory();

        assertEquals(expected, actual);
    }
}