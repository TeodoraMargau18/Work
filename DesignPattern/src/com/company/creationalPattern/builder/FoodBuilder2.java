package com.company.creationalPattern.builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FoodBuilder2 {

    private String name;
    private float price;
    private List<String> ingredients;
    private LocalDate expireDate;
    private boolean isGlutenFree;
    private boolean isVegetarian;
    private boolean isVegan;

    public FoodBuilder2 addName(String name) {
       this.name = name;
        return this;
    }

    public FoodBuilder2 addPrice(float price) {
        this.price = price;
        return this;
    }

    public FoodBuilder2 addIngredients(ArrayList<String> ingredients) {
        this.ingredients = new ArrayList<>();
        this.ingredients.addAll(ingredients);
        return this;
    }

    public FoodBuilder2 setGlutenFree(boolean glutenFree) {
        this.isGlutenFree = glutenFree;
        return this;
    }

    public FoodBuilder2 setIsVegan(boolean isVegan) {
        this.isVegan = isVegan;
        return this;
    }

    public FoodBuilder2 addExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
        return this;
    }

    public Food build() {
       Food food= new Food(name,price,ingredients,expireDate,isGlutenFree,isVegetarian,isVegan);
       init();
       return food;
    }
    private void init(){
        name=null;
        price=0;
        ingredients=null;
        expireDate=null;
        isGlutenFree=false;
        isVegan=false;
        isVegetarian=false;
    }
}
