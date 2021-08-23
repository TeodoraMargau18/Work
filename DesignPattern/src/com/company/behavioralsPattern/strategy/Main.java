package com.company.behavioralsPattern.strategy;

import com.company.arhitectural.servicelocator.ServiceLocator;
import com.company.behavioralsPattern.strategy.classes.SeatAllocator;
import com.company.behavioralsPattern.strategy.classes.TicketGenerator;
import com.company.behavioralsPattern.strategy.classes.strategies.ConsecutiveSeatAllocator;
import com.company.behavioralsPattern.strategy.classes.strategies.SocialDistancingSeatAllocator;


public class Main {
    public static void main(String[] args) {
//Strategy
//        -------------SERVICE LOCATOR
        ServiceLocator.register(SeatAllocator.class,new ConsecutiveSeatAllocator());
        ServiceLocator.register(SeatAllocator.class,new SocialDistancingSeatAllocator());
        TicketGenerator ticketGenerator = new TicketGenerator(1000);


//        ticketGenerator.setSeatAllocatorStrategy(new ConsecutiveSeatAllocator());
//        ticketGenerator.setSeatAllocatorStrategy(new SocialDistancingSeatAllocator());
//        ticketGenerator.setSeatAllocatorStrategy((x)->new Random().nextInt(x));
//cu operator de rezolutie
//        ticketGenerator.setSeatAllocatorStrategy(new Random()::nextInt);//trebuie sa aiba aceeasi signatura ca metoda din interfata functionala

        for (int i = 0; i < 5; i++) {
            try {
                int ticketNo = ticketGenerator.generateTicket();
                System.out.println("Ticket->seat no. " + ticketNo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//OBSERVER


    }
}
