package com.company.structuralPattern.adapter.classes.adapter;

import com.company.structuralPattern.adapter.classes.StadiumCovidTicketAllocator;
import com.company.structuralPattern.adapter.classes.TicketPicker;
import com.company.structuralPattern.adapter.classes.exception.OccupiedSeatException;

public class OldPickerToNewPickerClassAdapter extends StadiumCovidTicketAllocator implements TicketPicker {
    public OldPickerToNewPickerClassAdapter(int capacity) {
        super(capacity);
    }

    @Override
    public void pickPlace(int place) throws OccupiedSeatException {
        int seat = super.allocateSeat();
        if (seat == -1) {
            throw new OccupiedSeatException();
        }
        System.out.println("Allocated seat " + seat);
    }
}
