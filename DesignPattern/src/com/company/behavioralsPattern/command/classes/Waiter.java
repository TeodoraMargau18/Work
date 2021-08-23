package com.company.behavioralsPattern.command.classes;

import java.util.List;
import java.util.Vector;

public class Waiter {
//    Vector is safeThread
    private List<FoodOrder> foodOrderList=new Vector<>();
    public void addOrder(FoodOrder foodOrder){
        foodOrderList.add(foodOrder);
    }
    public synchronized void sendOrders(){
//        new Thread(()->{
//            for(int i=0;i< foodOrderList.size();i++){
//                foodOrderList.get(i).execute();
////                foodOrderList.remove(foodOrderList.get(i));
//            }
//            foodOrderList.clear(); //sterg lista pt ca nu mai am nevoie de ea
//        });


        for(FoodOrder f:foodOrderList){
            f.execute();
        }
        foodOrderList.clear();
    }
}
