package com.company.structuralPattern.adapter.classes;

public class StadiumCovidTicketAllocator implements SocialDistancingTicketAllocator {

    private int capacity;
    private int latestGeneratedSeat = -1;

    public StadiumCovidTicketAllocator(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
        }
    }

    @Override
    public int allocateSeat() {
        int allocatedSeat = latestGeneratedSeat + 2;
        if (allocatedSeat < capacity) {
            latestGeneratedSeat = allocatedSeat;
            return allocatedSeat;
        } else {
            return -1;
        }
    }
}
