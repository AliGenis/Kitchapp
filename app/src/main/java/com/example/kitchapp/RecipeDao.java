package com.example.kitchapp;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.time.Period;
import java.util.List;

@Dao
public interface RecipeDao {

        @Insert
        void addRecipe(Recipe recipe);

        @Query("select * from recipe")
        public List<Recipe> getRecipe();

        @Delete
        public void deleteRecipe(Recipe recipe);

    }
