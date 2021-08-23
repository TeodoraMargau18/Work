package com.company.structuralPattern.proxy.classes;

public class FrontDoorProxy implements AccessInterface {
    private AccessInterface frontDoor;
    private int temperature;

    public FrontDoorProxy(FrontDoor frontDoor, int temperature) {
        this.frontDoor = frontDoor;
        this.temperature = temperature;
    }

    public FrontDoorProxy(AccessInterface frontDoor) {
        this.frontDoor = frontDoor;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public boolean isAccessGranted(int id) {
        if (temperature < 35 || temperature > 38) {
            return false;
        }
        return frontDoor.isAccessGranted(id);
    }
}
