package com.company.behavioralsPattern.strategy.classes.strategies;

import com.company.behavioralsPattern.strategy.classes.SeatAllocator;

public class ConsecutiveSeatAllocator implements SeatAllocator {
    private int currentSeat=0;
    @Override
    public int allocateSeat(int capacity) {
        currentSeat++;
        if(currentSeat<=capacity){
            return currentSeat;
        }else{
            return -1;
        }
    }
}
