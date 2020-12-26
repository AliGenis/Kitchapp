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

    @Query("SELECT * FROM ingredient WHERE ingredientName LIKE (:name) ")
    List<Ingredient> getByName(String name);

    @Query("SELECT * FROM ingredient WHERE isInFridge = 1 ")
    List<Ingredient> getInFridge();

    @Query("SELECT * FROM ingredient WHERE isInShoppingList = 1 ")
    List<Ingredient> getInShoppingList();

    @Query("select * from ingredient")
    List<Ingredient> getIngredient();

    @Delete
    void deleteIngredient(Ingredient ingredient);

    @Update
    void updateIngredient(Ingredient ingredient);

}