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

    @PrimaryKey(autoGenerate = true)
    private int recipeID;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "recipeName")
    private String recipe;
    @ColumnInfo(name = "recipeInfo")
    private double calorie;
    @ColumnInfo(name = "prepTime")
    private int prepTime;
    @ColumnInfo(name = "recipePhotoId")
    private int recipePhotoId;

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

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
}
