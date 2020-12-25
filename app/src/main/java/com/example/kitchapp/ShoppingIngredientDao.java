package com.example.kitchapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ShoppingIngredientDao {
    @Insert
    void addShopIngredient(Ingredient ingredient);

    @Query("select * from ingredient")
    List<Ingredient> getIngredient();

    @Delete
    void deleteShopIngredient(Ingredient ingredient);

    @Update
    void updateShopIngredient(Ingredient ingredient);
}
