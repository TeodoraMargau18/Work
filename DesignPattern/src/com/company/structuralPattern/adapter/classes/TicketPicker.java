package com.company.structuralPattern.adapter.classes;

import com.company.structuralPattern.adapter.classes.exception.OccupiedSeatException;

public interface TicketPicker {
    void pickPlace(int place) throws OccupiedSeatException;
}
