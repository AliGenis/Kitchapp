package com.example.kitchapp;

import android.media.Image;

import java.util.ArrayList;

/**
 * @version 10/12/2020
 * @authors Burak, Tarik...
 */

public class User {

    //VARIABLES
    private String name;
    private ArrayList<Recipe> undesiredMeals;
    private Image profilePhoto;
    private boolean isVegetarian;
    private ArrayList<Ingredient> allergiesList;
    private String password;

    //CONSTRUCTORS
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    //Everything is specified
    public User(String name,
                ArrayList<Recipe> undesiredMeals,
                Image profilePhoto,
                boolean isVegetarian,
                ArrayList<Ingredient> allergiesList) {
        this.name = name;
        this.undesiredMeals = undesiredMeals;
        this.profilePhoto = profilePhoto;
        this.isVegetarian = isVegetarian;
        this.allergiesList = allergiesList;
    }

    //undesiredMeals is not specified.
    public User(String name,
                Image profilePhoto,
                boolean isVegetarian,
                ArrayList<Ingredient> allergiesList) {
        this.name = name;
        this.profilePhoto = profilePhoto;
        this.isVegetarian = isVegetarian;
        this.allergiesList = allergiesList;
    }

    //undesiredMeals and allergiesList are not specified.
    public User(String name, Image profilePhoto, boolean isVegetarian) {
        this.name = name;
        this.profilePhoto = profilePhoto;
        this.isVegetarian = isVegetarian;
    }

    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Recipe> getUndesiredMeals() {
        return undesiredMeals;
    }

    public void setUndesiredMeals(ArrayList<Recipe> undesiredMeals) {
        this.undesiredMeals = undesiredMeals;
    }

    public Image getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(Image profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public ArrayList<Ingredient> getAllergiesList() {
        return allergiesList;
    }

    public void setAllergiesList(ArrayList<Ingredient> allergiesList) {
        this.allergiesList = allergiesList;
    }

    //METHODS

    /**
     * Adds the given meal to the undesired list so it will not suggested to this user.
     *
     * @param disliked Disliked meal
     */
    public void dislikeMeal(Recipe disliked) {
        if (!undesiredMeals.contains(disliked))
            undesiredMeals.add(disliked);
    }

}
