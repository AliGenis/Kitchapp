package com.example.kitchapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface RecipeDao {

    @Insert
    void addRecipe(Recipe recipe);

    @Query("select * from recipe")
    List<Recipe> getRecipe();

    @Query("select * from recipe WHERE recipeID IN (:recIDList)")
    List<Recipe> getRecipeByID(ArrayList<Integer> recIDList);

    @Delete
    void deleteRecipe(Recipe recipe);

}
