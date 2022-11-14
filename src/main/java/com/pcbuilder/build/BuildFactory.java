package com.pcbuilder.build;

import com.pcbuilder.inventory.Component;

import java.util.HashMap;
import java.util.Map;

public class BuildFactory {
    public static Build transformUserInput(String userInput) {
        return null;
    }

//    public static Build createBuild(Session build) {
//
//        return new Build(build);
//
//    }

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
}
