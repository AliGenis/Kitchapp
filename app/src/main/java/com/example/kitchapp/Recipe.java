package com.example.kitchapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
    //@ColumnInfo(name = "recipePhotoId")
    //private int recipePhotoId;
    @ColumnInfo(name = "ingredients")
    public String ingredients;

    /**
     * get method for ingredients property
     * @return String ingredients
     */
    public String getIngredients() {
        return ingredients;
    }

    /**
     * set method for ingredients property
     * @param ingredients
     */
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * @return List<Ingredients> returns list of ingredients provided by the string type property of ingredients
     *                           by translating the ingredients to List type property
     */
    public List<Ingredient> getIngredientList() {
        Type listType = new TypeToken<ArrayList<Ingredient>>(){}.getType();
        return new Gson().fromJson(ingredients, listType);
    }

    /**
     * translates this List type property to a string type variable and sets the ingredients to it.
     * @param ingredients List type property
     */
    public void setIngredientList(List<Ingredient> ingredients) {
        Gson gson = new Gson();
        this.ingredients = gson.toJson(ingredients);
    }

    /**
     * get method for recipeID property
     * @return int recipeID
     */
    public int getRecipeID() {
        return recipeID;
    }

    /**
     * set method for recipeID property
     * @param recipeID takes an int from outside and sets the recipeID to it.
     */
    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    /**
     * get method for the name property
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * set method for the name property
     * @param name takes a string from outside and sets the name to it.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get method for the recipe property
     * @return String Recipe
     */
    public String getRecipe() {
        return recipe;
    }
    /**
     * set method for the recipe property
     * @param recipe takes a string from outside and sets the recipe
     */
    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    /**
     * get mathod for the calorie
     * @return double calorie
     */
    public double getCalorie() {
        return calorie;
    }

    /**
     * set method for calorie property
     * @param calorie takes a double value as a parameter and sets calorie to it
     */
    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    /**
     * get method for prepTime property
     * @return int prepTime
     */
    public int getPrepTime() {
        return prepTime;
    }

    /**
     * set method for prepTime property
     * @param prepTime takes a int value from outside and sets the prepTime to it.
     */
    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

}
