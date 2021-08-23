package com.company.behavioralsPattern.command.classes;

public class PizzaOrder implements FoodOrder {
    private Chef chef;

    public PizzaOrder(Chef chef) {
        this.chef = chef;
    }

    @Override
    public void execute() {
        new Thread(chef::cookPizza).start();
//        chef.cookPizza();
    }
}
