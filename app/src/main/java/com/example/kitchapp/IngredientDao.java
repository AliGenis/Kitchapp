package com.example.kitchapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface IngredientDao {

    @Insert
    void addIngredient(Ingredient ingredient);

    @Query("select * from ingredient")
    List<Ingredient> getIngredient();

    @Delete
    void deleteIngredient(Ingredient ingredient);

    @Update
    void updateIngredient(Ingredient ingredient);

}