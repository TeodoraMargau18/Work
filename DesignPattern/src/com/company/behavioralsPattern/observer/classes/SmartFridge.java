package com.company.behavioralsPattern.observer.classes;

import java.util.List;
import java.util.Vector;

public class SmartFridge implements Subject {

    private List<Observer> observers = new Vector<>();

    @Override
    public void subscribe(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }
    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }
}
