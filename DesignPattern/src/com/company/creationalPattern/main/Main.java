package com.company.creationalPattern.main;

import com.company.creationalPattern.builder.Food;
import com.company.creationalPattern.builder.FoodBuilder2;
import com.company.creationalPattern.factory.DatabaseServer;
import com.company.creationalPattern.factory.DatabaseServerFactory;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Factory
        DatabaseServer server= DatabaseServerFactory.createDatabaseServer("development");
        server.connect();

//        Builder

        Food.FoodBuilder builder=new Food.FoodBuilder();
        Food food=builder.addName("Chocolate").addPrice(8).addExpireDate(LocalDate.now()).setIsVegan(true)
                .setGlutenFree(false).build();
        System.out.println(food.toString());
//        builder.addIngredients(Arrays.asList(new String[]{"Cocoa", "Milk"}));


        FoodBuilder2 builder2=new FoodBuilder2();
       Food food2= builder2.addExpireDate(LocalDate.now()).addName("Bread").build();
       Food food3= builder2.addName("Milk").build();
    }

}
