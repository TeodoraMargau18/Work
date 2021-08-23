package com.company.behavioralsPattern.strategy.classes;

import com.company.arhitectural.servicelocator.ServiceLocator;

public class TicketGenerator {
    private int capacity = 0;
    private SeatAllocator seatAllocatorStrategy = null;

    //    ..
//    public TicketGenerator(int capacity) {
//        this.capacity = capacity;
//    }

//    Service locator
    public TicketGenerator(int capacity) {
        this.capacity = capacity;
        seatAllocatorStrategy= (SeatAllocator) ServiceLocator.resolve(SeatAllocator.class);
    }


    //method injection
    //am grija cand o folosesc in generate, daca cineva mi a setat strategia


//    public void setSeatAllocatorStrategy(SeatAllocator seatAllocator) {
//        this.seatAllocatorStrategy = seatAllocator;
//    }

    public int generateTicket() throws Exception {
        if (this.seatAllocatorStrategy != null) {
                return seatAllocatorStrategy.allocateSeat(capacity);
        }else{
            throw new Exception("The strategy isn't set!");
        }
    }
}
