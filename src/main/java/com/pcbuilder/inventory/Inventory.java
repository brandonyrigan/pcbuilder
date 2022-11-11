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
        cpuList.add(new CPU("Intel Core I9-13900K", "24-Core, 3.0 GHz, 125W, Intel UHD Graphics 770", 659.00, "*****", 20));
        cpuList.add(new CPU("Intel Core I7-13700K", "16-Core, 3.4 GHz, DDR5 5600, 125W, Intel UHD Graphics 770", 439.99, "*****", 20));
        cpuList.add(new CPU("Intel Core I5-13600K", "14-Core, 3.5 GHz, DDR5 5600, 125W, Intel UHD Graphics 770", 319.99, "*****", 20));
        cpuList.add(new CPU("AMD Ryzen 9 7950X", "16-Core, 170W", 699.00, "*****", 20));
        cpuList.add(new CPU("AMD Ryzen 9 7900X", "12-Core, 4.7 GHz, 170W", 549.00, "*****", 20));
        cpuList.add(new CPU("AMD Ryzen 7 7700X", "8-Core, 105W", 398.98, "*****", 20));
        cpuList.add(new CPU("AMD Ryzen 5 7600X", "6-Core, 105W", 299.00, "*****", 20));
        cpuList.add(new CPU("AMD Ryzen 5 5600", "6-Core, 3.5 GHz, DDR4 3200, 65W", 138.99, "*****", 20));
    }

    private static Collection<Component> motherboardList = new ArrayList<>();
    static {
        motherboardList.add(new Motherboard("MSI MPG Z590 GAMING FORCE ATX Intel", "LGA 1200, ATX, 128GB, 4x288pin(DDR4), Intel Z590", 176.29, "****", 20));
        motherboardList.add(new Motherboard("ASRock B660M PRO RS Micro ATX Intel", "LGA 1700, Micro ATX, 128GB, 4x288pin(DDR4), Intel B660", 89.99, "****", 20));
        motherboardList.add(new Motherboard("MSI MAG Z490 TOMAHAWK ATX Intel", "LGA 1200, ATX, 128GB, 4x288pin(DDR4), Intel Z490", 89.99, "****", 20));
        motherboardList.add(new Motherboard("ASUS ROG STRIX Z790-E GAMING WIFI ATX Intel", "LGA 1700, ATX, 128GB, 4x288pin(DDR5), Intel Z790", 499.99, "*****", 20));
        motherboardList.add(new Motherboard("GIGABYTE B650 AORUS ELITE AX", "AM5, ATX, 128GB, 4x288pin(DDR5), AMD B650", 229.99, "*****", 20));
        motherboardList.add(new Motherboard("ASUS STRIX X670E-E GAMING WIFI ATX", "AM5, ATX, 128GB, 4x288pin(DDR5), AMD X670E", 499.99, "****", 20));
        motherboardList.add(new Motherboard("ASRock B550M PG RIPTIDE Micro ATX", "AM4, Micro ATX, 128GB, 4x288pin(DDR), AMD B550", 89.99, "***", 20));
        motherboardList.add(new Motherboard("ASRock B550 Phantom Gaming", "AM4, ATX, 128GB, 4x288pin(DDR4), AMD B550", 84.99, "****", 20));
    }

    private static Collection<Component> memoryList = new ArrayList<>();
    static {
        memoryList.add(new Memory("G.SKILL Ripjaws V Series", "32GB (2 x 16GB) 288-Pin PC RAM DDR4 3200 (PC4 25600)", 84.99, "*****", 20));
        memoryList.add(new Memory("G.SKILL Trident Z5 RGB Series", "32GB (2 x 16GB) 288-Pin PC RAM DDR5 6000 (PC5 48000)", 189.99, "*****", 20));
        memoryList.add(new Memory("G.SKILL Trident Z RGB (For AMD)", "16GB (2 x 8GB) 288-Pin PC RAM DDR4 3600 (PC4 28800)", 75.99, "*****", 20));
        memoryList.add(new Memory("CORSAIR Vengeance RGB Pro", "16GB (2 x 8GB) 288-Pin PC RAM DDR4 3200 (PC4 25600)", 69.99, "*****", 20));
        memoryList.add(new Memory("G.SKILL Ripjaws V Series", "32GB (2 x 16GB) 288-Pin PC RAM DDR4 3600 (PC4 28800)", 93.99, "*****", 20));
        memoryList.add(new Memory("G.SKILL Trident Z5 RGB Series", "32GB (2 x 16GB) 288-Pin PC RAM DDR5 6000 (PC5 48000)", 198.99, "*****", 20));
        memoryList.add(new Memory("G.SKILL Ripjaws V Series", "16GB (2 x 8GB) 288-Pin PC RAM DDR4 3600 (PC4 28800)", 64.99, "*****", 20));
        memoryList.add(new Memory("G.SKILL Ripjaws V Series", "64GB (2 x 32GB) 288-Pin PC RAM DDR4 3600 (PC4 28800)", 176.99, "*****", 20));
    }

    private static Collection<Component> videoCardList = new ArrayList<>();
    static {
        videoCardList.add(new VideoCard("ASUS ROG Strix GeForce RTX 3050", "GeForce RTX 3050 8GB 1890 MHz PCI Express 4.0", 179.99, "*****", 20));
        videoCardList.add(new VideoCard("GIGABYTE GAMING OC Radeon RX 6500 XT ", "Radeon RX 6500 XT 4GB 2825 MHz PCI Express 4.0", 185.99, "*****", 20));
        videoCardList.add(new VideoCard("MSI Mech Radeon RX 6500 XT", "Radeon RX 6500 XT 4GB 2825 MHz PCI Express 4.0", 489.76, "*****", 20));
        videoCardList.add(new VideoCard("GIGABYTE Radeon RX 6700 XT GAMING OC", "Radeon RX 6700 XT 12GB 2622 MHz PCI Express 4.0", 239.99, "*****", 20));
        videoCardList.add(new VideoCard("Yeston RTX 3080 10GB GDDR6X", "GeForce RTX 3080 8GB 1890 MHz PCI Express 4.0", 769.00, "*****", 20));
        videoCardList.add(new VideoCard("MSI Ventus GeForce RTX 3060", "GeForce RTX 3060 8GB 1890 MHz PCI Express 4.0", 369.39, "*****", 20));
        videoCardList.add(new VideoCard("GIGABYTE Eagle Radeon RX 6650 XT", "Radeon RX 6650 XT 8GB 2635 MHz PCI Express 4.0", 279.99, "*****", 20));
        videoCardList.add(new VideoCard("GIGABYTE Gaming OC GeForce RTX 3070", "GeForce RTX 3070 8GB 1890 MHz PCI Express 4.0", 539.99, "*****", 20));
    }

    private static Collection<Component> caseList = new ArrayList<>();
    static {
        caseList.add(new Case("Corsair 4000D Airflow", "ATX Mid Tower Black Steel / Plastic/ Tempered Glass", 89.99, "*****", 20));
        caseList.add(new Case("NZXT H510 - CA-H510B-W1", "Compact ATX Mid-Tower PC Gaming Case - Front I/O USB Type-C Port - Tempered Glass Side Panel", 83.13, "*****", 20));
        caseList.add(new Case("NZXT H510 - CA-H510B-B1", "Compact ATX Mid-Tower PC Gaming Case - Front I/O USB Type-C Port - Tempered Glass Side Panel", 69.99, "*****", 20));
        caseList.add(new Case("NZXT H510 Elite Premium", "Mid-Tower ATX Case PC Gaming Case - Dual-Tempered Glass Panel - Front I/O USB Type-C Port - Vertical GPU Mount - Integrated RGB Lighting", 186.25, "*****", 20));
        caseList.add(new Case("Corsair Carbide Series 100R", "Silent Edition Quiet Mid Tower Case", 210.00, "*****", 20));
        caseList.add(new Case("Corsair 110Q", "Mid-Tower Quiet ATX Case", 89.99, "*****", 20));
        caseList.add(new Case("Corsair 5000D", "Tempered Glass Mid-Tower ATX PC Case", 129.99, "*****", 20));
        caseList.add(new Case("Corsair Carbide Series 175R", "RGB Tempered Glass Mid-Tower ATX Gaming Case", 74.99, "*****", 20));
    }

    private static Collection<Component> powerSupplyList = new ArrayList<>();
    static {
        powerSupplyList.add(new PowerSupply("Thermaltake Smart 430W", "80+ Black Continuous Power ATX 12V V2.3/EPS 12V Active PFC Power Supply", 29.00, "*****", 20));
        powerSupplyList.add(new PowerSupply("Thermaltake SMART 600W", "ATX 12V V2.3/EPS 12V 80 Plus Certified Active PFC Power Supply", 39.99, "*****", 20));
        powerSupplyList.add(new PowerSupply("Corsair CX750F", "RGB, 750 Watt, 80 PLUS Bronze, Fully Modular RGB Power Supply", 84.99, "*****", 20));
        powerSupplyList.add(new PowerSupply("Corsair CX750F", "RGB, 750 Watt, 80 PLUS Bronze, Fully Modular RGB White Power Supply", 114.00, "*****", 20));
        powerSupplyList.add(new PowerSupply("EVGA 500W", "80PLUS Certified ATX12V/EPS12V Power Supply", 45.82, "*****", 20));
        powerSupplyList.add(new PowerSupply("Seasonic FOCUS Plus", "750 Gold, 80+ Gold Certified 750W Full Modular Power Supply", 139.27, "*****", 20));
        powerSupplyList.add(new PowerSupply("Seasonic FOCUS", "750 Gold, 80+ Gold 750W Semi-Modular Power Supply", 128.47, "*****", 20));
        powerSupplyList.add(new PowerSupply("Seasonic Focus GX-750", "80+ Gold Certified 750W Full-Modular Power Supply with Fan Control in Fanless, Silent, and Cooling Mode", 151.39, "*****", 20));
    }

    private static Collection<Component> storageList = new ArrayList<>();
    static {
        storageList.add(new Storage("Samsung EVO 970", "1TB PCIe Gen3 x4 NVMe M.2-2280 Internal Solid State Drive with V-NAND Technology & 1024MB Cache", 219.99, "*****", 20));
        storageList.add(new Storage("Seagate BarraCuda", "2TB SATA 3 6Gb/s, 3.5\" Internal Hard Drive with 7200 RPM & 256MB Cache", 55.49, "*****", 20));
        storageList.add(new Storage("Samsung EVO 970", "500GB PCIe NVMe M.2-2280 Internal Solid State Drive with V-NAND Technology & 512MB Cache", 119.78, "*****", 20));
        storageList.add(new Storage("Western Digital WD Blue", "1TB SATA 3 6Gb/s, 3.5\" Internal Hard Drive with 7200 RPM & 64 MB Cache", 37.49, "*****", 20));
        storageList.add(new Storage("Crucial P1", "1TB PCIe Gen3 x4 NVMe M.2-2280 3D NAND Internal Solid State Drive", 119.00, "*****", 20));
        storageList.add(new Storage("Western Digital WD Blue", "500GB SATA 3 6Gb/s, M.2-2280 3D NAND Internal Solid State Drive", 68.00, "*****", 20));
        storageList.add(new Storage("Kingston A400", "240GB SATA 3 6Gb/s, 2.5\" Internal Solid State Drive", 19.99, "*****", 20));
        storageList.add(new Storage("Western Digital WD Blue", "1TB SATA 3 6Gb/s, M.2-2280 3D NAND Internal Solid State Drive", 105.00, "*****", 20));
    }

    private static Collection<Component> cpuCoolerList = new ArrayList<>();
    static {
        cpuCoolerList.add(new CPUCooler("Cooler Master Hyper 212 EVO V2", "CPU Air Cooler with SickleFlow 120, PWM Fan, Direct Contact Technology, 4 Copper Heat Pipes", 42.99, "*****", 20));
        cpuCoolerList.add(new CPUCooler("Cooler Master Hyper T20 Compact CPU Air Cooler", "95mm Fan, 2 Copper Direct Contact Heat Pipe for AMD Ryzen AM4/Intel LGA1200/1151", 14.25, "*****", 20));
        cpuCoolerList.add(new CPUCooler("Cooler Master Hyper 212 Black Edition CPU Air Coolor", "Silencio FP120 Fan, 4 CDC 2.0 Heatpipes, Anodized Gun-Metal Black, Brushed Nickel Fins", 49.99, "*****", 20));
        cpuCoolerList.add(new CPUCooler("Cooler Master Hyper 212 Evo CPU Cooler", "4 CDC Heatpipes, 120mm PWM Fan, Aluminum Fins", 42.99, "*****", 20));
        cpuCoolerList.add(new CPUCooler("NZXT Kraken 120", "Quiet and Effective - Silent Operation - Ring RGB LEDs - Aer P 120mm Radiator Fans (Included)", 89.99, "*****", 20));
        cpuCoolerList.add(new CPUCooler("Corsair iCUE H60i RGB PRO XT", "120mm Radiator, Single 120mm PWM Fan, Software Control, Liquid CPU Cooler", 89.06, "*****", 20));
        cpuCoolerList.add(new CPUCooler("Corsair iCUE H115i", "Elite Capellix Liquid CPU Cooler", 158.39, "*****", 20));
        cpuCoolerList.add(new CPUCooler("Corsair iCUE H150i", "Elite Capellix Liquid CPU Cooler", 189.99, "*****", 20));
    }

}
