package com.pcbuilder.build;

import com.pcbuilder.inventory.*;

import java.util.UUID;

public class Build {
    private UUID buildUUID;
    private UUID guestCustomerId;
    private String guestCustomer;
    private CPU cpu;
    private CPUCooler cpuCooler;
    private VideoCard videoCard;
    private Motherboard motherboard;
    private PowerSupply powerSupply;
    private Memory memory;
    private Storage storage;
    private Case buildCase;

    public Build(UUID buildUUID, UUID guestCustomerId, String guestCustomer, CPU cpu, CPUCooler cpuCooler, VideoCard videoCard, Motherboard motherboard, PowerSupply powerSupply, Memory memory, Storage storage, Case buildCase) {
        this.buildUUID = buildUUID;
        this.guestCustomerId = guestCustomerId;
        this.guestCustomer = guestCustomer;
        this.cpu = cpu;
        this.cpuCooler = cpuCooler;
        this.videoCard = videoCard;
        this.motherboard = motherboard;
        this.powerSupply = powerSupply;
        this.memory = memory;
        this.storage = storage;
        this.buildCase = buildCase;
    }

    public Case getBuildCase() {
        return buildCase;
    }

    public void setBuildCase(Case buildCase) {
        this.buildCase = buildCase;
    }

    public UUID getBuildUUID() {
        return buildUUID;
    }

    public void setBuildUUID(UUID buildUUID) {
        this.buildUUID = buildUUID;
    }

    public UUID getGuestCustomerId() {
        return guestCustomerId;
    }

    public void setGuestCustomerId(UUID guestCustomerId) {
        this.guestCustomerId = guestCustomerId;
    }

    public String getGuestCustomer() {
        return guestCustomer;
    }

    public void setGuestCustomer(String guestCustomer) {
        this.guestCustomer = guestCustomer;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public CPUCooler getCpuCooler() {
        return cpuCooler;
    }

    public void setCpuCooler(CPUCooler cpuCooler) {
        this.cpuCooler = cpuCooler;
    }

    public VideoCard getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public PowerSupply getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
