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

<<<<<<< HEAD
=======
    @Query("SELECT * FROM ingredient WHERE isInFridge = 1 ")
    List<Ingredient> getInFridge();

    @Query("SELECT * FROM ingredient WHERE isInShoppingList = 1 ")
    List<Ingredient> getInShoppingList();

>>>>>>> parent of c80ee10... suggestion and fridge full coordination
    @Query("select * from ingredient")
    List<Ingredient> getIngredient();

    @Delete
    void deleteIngredient(Ingredient ingredient);

    @Update
    void updateIngredient(Ingredient ingredient);

}