package com.company.structuralPattern.adapter.classes;

import com.company.structuralPattern.adapter.classes.exception.OccupiedSeatException;

public class StadiumTicketPicker implements TicketPicker {

    private int capacity;
    private boolean[] occupiedSeats;

    public StadiumTicketPicker(int capacity) {
        this.capacity = capacity;
        this.occupiedSeats = new boolean[capacity];
    }

    @Override
    public void pickPlace(int place) throws OccupiedSeatException {
        if (occupiedSeats[place]) {
            throw new OccupiedSeatException();
        } else {
            occupiedSeats[place] = true;
            System.out.println("seat "+place+" was allocated to you!");
        }
    }
}
