package com.company.structuralPattern.proxy.classes;

import java.util.Arrays;
import java.util.List;

public class FrontDoor implements AccessInterface{
    private List<Integer> accessCard= Arrays.asList(123,456);

    @Override
    public boolean isAccessGranted(int id) {
        return accessCard.contains(id);
    }
}
