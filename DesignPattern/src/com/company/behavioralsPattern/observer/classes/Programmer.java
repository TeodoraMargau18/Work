package com.company.behavioralsPattern.observer.classes;

public class Programmer implements Observer{
    private String name;
    public Programmer(String name){
        this.name=name;
    }
    @Override
    public void update() {
        goToFridge();
    }

    private void goToFridge(){
        System.out.println("The programmer "+name+" is going to the fridge!");
    }
}
