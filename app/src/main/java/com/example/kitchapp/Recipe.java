package com.example.kitchapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

/**
 * Recipe of a meal
 *
 * @author Burak, Ali, Tarik,Şule
 * @version 10/12/2020
 */
@Entity
public class Recipe {

    //VARIABLES
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "recipe")
    private String recipe;
    @ColumnInfo(name = "lisOfIngredients")
    private ArrayList<Ingredient> ingredients;
    @ColumnInfo(name = "recipe")
    private double calorie;
    @ColumnInfo(name = "prepTime")
    private int prepTime;
    @ColumnInfo(name = "recipePhotoId")
    private int recipePhotoId;

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

    public int getRecipePhotoId() {
        return recipePhotoId;
    }

    public void setRecipePhotoId(int recipePhotoId) {
        this.recipePhotoId = recipePhotoId;
    }

    //TODO: connection to the database will be established
}
