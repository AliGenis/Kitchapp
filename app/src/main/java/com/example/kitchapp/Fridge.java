package com.example.kitchapp;
import java.util.*;

public class Fridge extends IngredientList {
    private IngredientList list;

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
        return null;
    }

    public ArrayList<Recipe> recipesSpecificToUser(User user){
        return null;
    }

    public Recipe suggest(User user){
        return null;
    }

    public void eatMeal(Recipe recipe){

    }

}
