package com.company.structuralPattern.adapter.classes.adapter;

import com.company.structuralPattern.adapter.classes.SocialDistancingTicketAllocator;
import com.company.structuralPattern.adapter.classes.TicketPicker;
import com.company.structuralPattern.adapter.classes.exception.OccupiedSeatException;

public class OldPickerToNewPickerObjectAdapter implements TicketPicker {
    private SocialDistancingTicketAllocator socialDistancingAllocator=null;

    public OldPickerToNewPickerObjectAdapter(SocialDistancingTicketAllocator socialDistancingAllocator){
        this.socialDistancingAllocator=socialDistancingAllocator;
    }

    @Override
    public void pickPlace(int place) throws OccupiedSeatException {
        int seat =socialDistancingAllocator.allocateSeat();
        if (seat == -1) {
            throw new OccupiedSeatException();
        }
        System.out.println("Allocated seat " + seat);
    }
}
