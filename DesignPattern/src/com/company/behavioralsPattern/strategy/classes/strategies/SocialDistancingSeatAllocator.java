package com.company.behavioralsPattern.strategy.classes.strategies;

import com.company.behavioralsPattern.strategy.classes.SeatAllocator;

public class SocialDistancingSeatAllocator implements SeatAllocator {
    private int currentSeat=-1;
    @Override
    public int allocateSeat(int capacity) {
        currentSeat+=2;
        if(currentSeat<=capacity){
            return currentSeat;
        }else{
            return -1;
        }
    }

}
