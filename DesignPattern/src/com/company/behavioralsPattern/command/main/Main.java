package com.company.behavioralsPattern.command.main;

import com.company.behavioralsPattern.command.classes.*;

public class Main {
    public static void main(String[] args) {
        Waiter waiter=new Waiter();
        Chef chef=new Chef();

        FoodOrder fPizza1=new PizzaOrder(chef);
        FoodOrder fPizza2=new PizzaOrder(chef);
        FoodOrder fBurger1=new BurgerOrder(chef);
        waiter.addOrder(fBurger1);
        waiter.addOrder(fPizza2);
        waiter.addOrder(fPizza1);
        waiter.sendOrders();
        waiter.addOrder(fPizza1);
        waiter.sendOrders();
    }
}
