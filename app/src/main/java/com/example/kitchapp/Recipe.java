package com.example.kitchapp;

import java.util.ArrayList;

/**
 * Recipe of a meal
 * @author Burak, Ali, Tarik,Şule
 * @version 10/12/2020
 */
public class Recipe {

    //VARIABLES
    private String name;
    private String recipe;
    private ArrayList<Ingredient> ingredients;
    private double calorie;
    private int prepTime;
    private boolean isVegetarian;
    private Image recipePhoto;

    //DEFAULT CONSTRUCTOR
    public Recipe(String name,
                  String recipe,
                  ArrayList<Ingredient> ingredients,
                  double calorie,
                  int prepTime,
                  boolean isVegetarian) {
        this.name = name;
        this.recipe = recipe;
        this.ingredients = ingredients;
        this.calorie = calorie;
        this.prepTime = prepTime;
        this.isVegetarian = isVegetarian;
    }

    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double getCalorie() {
        return calorie;
    }

    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    //TODO: connection to the database will be established
}
