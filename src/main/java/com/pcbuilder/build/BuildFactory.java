package com.pcbuilder.build;

import com.pcbuilder.inventory.*;
import com.pcbuilder.session.Session;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BuildFactory {

    public static Build createBuild(Session sessionBuild) {

        CPU cpu = (CPU) findComponentByUUID("CPU", sessionBuild);
        Case buildCase = (Case) findComponentByUUID("Case", sessionBuild);
        CPUCooler cpuCooler = (CPUCooler) findComponentByUUID("CPUCooler", sessionBuild);
        Memory memory = (Memory) findComponentByUUID("Memory", sessionBuild);
        Motherboard motherboard = (Motherboard) findComponentByUUID("Motherboard", sessionBuild);
        PowerSupply powerSupply = (PowerSupply) findComponentByUUID("PowerSupply", sessionBuild);
        Storage storage = (Storage) findComponentByUUID("Storage", sessionBuild);
        VideoCard videoCard = (VideoCard) findComponentByUUID("VideoCard", sessionBuild);

        UUID buildUUID = sessionBuild.getUuid();
        UUID customerUUID = sessionBuild.getCustomer().getCustomerUUID();
        String customerName = sessionBuild.getCustomer().getFirstName() + " " + sessionBuild.getCustomer().getLastName();

        return new Build(buildUUID, customerUUID, customerName, cpu, cpuCooler, videoCard, motherboard, powerSupply, memory, storage, buildCase);
    }

    public static Map<String, Component> generateFinalMapOfBuild(Build build) {

        Map<String, Component> finalMap = new HashMap<>();
        {
            finalMap.put("CPU", build.getCpu());
            finalMap.put("CPUCooler", build.getCpuCooler());
            finalMap.put("Case", build.getBuildCase());
            finalMap.put("Memory", build.getMemory());
            finalMap.put("Motherboard", build.getMotherboard());
            finalMap.put("PowerSupply", build.getPowerSupply());
            finalMap.put("Storage", build.getStorage());
            finalMap.put("VideoCard", build.getVideoCard());
        }
        return finalMap;
    }

    private static Component findComponentByUUID(String componentType, Session session) {
        Map<String, Collection<Component>> fetchedInventoryMap = session.fetchMapOfInventory();
        Component selectedComponent = null;
        for (Component component : fetchedInventoryMap.get(componentType)) {
            if (component.getProductId().toString().equals(session.getSessionBuild().get(componentType))) {
                selectedComponent = component;
            }
        }
        return selectedComponent;
    }
}
