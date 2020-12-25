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
    public List<Ingredient> getIngredient();

    @Delete
    public void deleteShopIngredient(Ingredient ingredient);

    @Update
    public void updateShopIngredient(Ingredient ingredient);
}
