package com.company.behavioralsPattern.command.classes;

public class BurgerOrder implements FoodOrder{
    private Chef chef;

    public BurgerOrder(Chef chef){
        this.chef=chef;
    }
    @Override
    public void execute() {
        new Thread(chef::cookBurger).start();
        //        chef.cookBurger();
    }
}
