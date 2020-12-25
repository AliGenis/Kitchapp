package com.example.kitchapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RecipeDao {

    @Insert
    void addRecipe(Recipe recipe);

    @Query("select * from recipe")
    List<Recipe> getRecipe();

    @Delete
    void deleteRecipe(Recipe recipe);

}
