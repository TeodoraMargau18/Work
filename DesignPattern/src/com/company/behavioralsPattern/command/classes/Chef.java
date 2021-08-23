package com.company.behavioralsPattern.command.classes;

public class Chef {
    public void cookPizza(){
        try {
            Thread.sleep(3000);
            System.out.println("Pizza is ready!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void cookBurger(){
        try {
            Thread.sleep(1000);
            System.out.println("The burger is ready!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
