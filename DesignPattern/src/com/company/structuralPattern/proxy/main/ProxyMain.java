package com.company.structuralPattern.proxy.main;

import com.company.structuralPattern.proxy.classes.AccessInterface;
import com.company.structuralPattern.proxy.classes.FrontDoor;
import com.company.structuralPattern.proxy.classes.FrontDoorProxy;

public class ProxyMain {
    public static void main(String[] args) {

        AccessInterface door = new FrontDoor();
        System.out.println(door.isAccessGranted(456));

        FrontDoorProxy proxy = new FrontDoorProxy(door);
        proxy.setTemperature(39);
        door = proxy;
        AccessInterface improvedDoor = new FrontDoorProxy(door);
        System.out.println( improvedDoor.isAccessGranted(456));

        door=new FrontDoorProxy(new FrontDoor(),37);
        System.out.println(door.isAccessGranted(123));


    }
}
