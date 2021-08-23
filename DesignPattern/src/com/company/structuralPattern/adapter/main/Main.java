package com.company.structuralPattern.adapter.main;

import com.company.structuralPattern.adapter.classes.SocialDistancingTicketAllocator;
import com.company.structuralPattern.adapter.classes.StadiumCovidTicketAllocator;
import com.company.structuralPattern.adapter.classes.StadiumTicketPicker;
import com.company.structuralPattern.adapter.classes.TicketPicker;
import com.company.structuralPattern.adapter.classes.adapter.OldPickerToNewPickerClassAdapter;
import com.company.structuralPattern.adapter.classes.adapter.OldPickerToNewPickerObjectAdapter;
import com.company.structuralPattern.adapter.classes.exception.OccupiedSeatException;

public class Main {

    public static void main(String[] args) {
//        Cel nou
        SocialDistancingTicketAllocator ticketAllocator = new StadiumCovidTicketAllocator(1000);
        for (int i = 0; i < 3; i++) {
            ticketAllocator.allocateSeat();
        }

//Cel vechi
        TicketPicker oldTicketPicker = new StadiumTicketPicker(1000);
        try {
            oldTicketPicker.pickPlace(5);
            oldTicketPicker.pickPlace(7);
            oldTicketPicker.pickPlace(5);
        } catch (OccupiedSeatException e) {
            System.out.println("Locul este ocupat");
//            e.printStackTrace();
        }

//        cu adapter de CLASE
        TicketPicker newTicketPicker = new OldPickerToNewPickerClassAdapter(1000);
        try {
            newTicketPicker.pickPlace(5);
            newTicketPicker.pickPlace(7);
            newTicketPicker.pickPlace(5);
        } catch (OccupiedSeatException e) {
            System.out.println("Locul este ocupat");
        }

//        cu adapter de OBIECTE
        TicketPicker newTicketPickerObject = new OldPickerToNewPickerObjectAdapter(ticketAllocator);
        try {
            newTicketPickerObject.pickPlace(5);
            newTicketPickerObject.pickPlace(7);
            newTicketPickerObject.pickPlace(5);
        } catch (OccupiedSeatException e) {
            System.out.println("Locul este ocupat");
        }
    }
}
