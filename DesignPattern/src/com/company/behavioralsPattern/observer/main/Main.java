package com.company.behavioralsPattern.observer.main;

import com.company.behavioralsPattern.observer.classes.Programmer;
import com.company.behavioralsPattern.observer.classes.SmartFridge;

public class Main {
    public static void main(String[] args) {
        Programmer programmer1=new Programmer("Ionel");
        Programmer programmer2=new Programmer("Gigel");
        Programmer programmer3=new Programmer("Cornel");

        SmartFridge smartFridge=new SmartFridge();
        smartFridge.subscribe(programmer1);
        smartFridge.subscribe(programmer2);
        smartFridge.subscribe(programmer3);
//        ------Nu mai are referinta catre programmer3
        programmer3=null;
        smartFridge.unsubscribe(programmer3);
//        ----------------
        smartFridge.notifyObservers();

        smartFridge.unsubscribe(programmer2);
        smartFridge.notifyObservers();
    }
}
