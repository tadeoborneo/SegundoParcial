package Registers;

import Models.Kit;

import java.util.UUID;

public class AislarRegister {
    private UUID kit;
    private Integer temperature;
    private String neighborhood;

    public UUID getKit() {
        return kit;
    }

    public void setKit(UUID kit) {
        this.kit = kit;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public AislarRegister(UUID kit, Integer temperature, String neighborhood) {
        this.kit = kit;
        this.temperature = temperature;
        this.neighborhood = neighborhood;
    }
}
