package com.company.creationalPattern.builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Food implements Cloneable {
    private String name;
    private float price;
    private List<String> ingredients;
    private LocalDate expireDate;
    private boolean isGlutenFree;
    private boolean isVegetarian;
    private boolean isVegan;

    private Food() {
    }

    private Food(String name, float price) {
        this.name = name;
        this.price = price;
    }

     Food(String name, float price, List<String> ingredients,
                 LocalDate expireDate, boolean isGlutenFree,
                 boolean isVegetarian, boolean isVegan) {
        this.name = name;
        this.price = price;
        this.ingredients = new ArrayList<>();
        if(ingredients!=null){
            this.ingredients.addAll(ingredients);
        }
        this.expireDate = expireDate;
        this.isGlutenFree = isGlutenFree;
        this.isVegetarian = isVegetarian;
        this.isVegan = isVegan;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
//-----------------------------------BUILDER-----------------------------------
    public static class FoodBuilder {

        private Food food = new Food();

        public FoodBuilder addName(String name) {
            food.name = name;
            return this;
        }

        public FoodBuilder addPrice(float price) {
            food.price = price;
            return this;
        }

        public FoodBuilder addIngredients(ArrayList<String> ingredients) {
            food.ingredients = new ArrayList<>();
            food.ingredients.addAll(ingredients);
            return this;
        }

        public FoodBuilder setGlutenFree(boolean glutenFree) {
            food.isGlutenFree = glutenFree;
            return this;
        }

        public FoodBuilder setIsVegan(boolean isVegan) {
            food.isVegan = isVegan;
            return this;
        }

        public FoodBuilder addExpireDate(LocalDate expireDate) {
            food.expireDate = expireDate;
            return this;
        }

        public Food build() {
            Food copie = null;
            try {
                copie = (Food) food.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            finally {
                return copie;
            }
        }
    }


}
