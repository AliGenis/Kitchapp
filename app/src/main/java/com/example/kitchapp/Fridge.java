package com.example.kitchapp;
import java.util.*;

public class Fridge {
    IngredientList list;

    public Fridge(IngredientList list){
    this.list = list;
    }

    public void addByOne(Ingredient ingredient){
    list.add(ingredient,1);
    }
    public void eatByOne(Ingredient ingredient){
        list.eat(ingredient,1);
    }

    public ArrayList<Ingredient> ingredientsSpecificToUser(User user){

    }

    public ArrayList<Recipe> recipesSpecificToUser(User user){

    }

    public Recipe suggest(User user){

    }

    public void eatMeal(Recipe recipe){

    }



}
