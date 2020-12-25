package com.example.kitchapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FridgeItemDao {

    @Insert
    void addFridgeItem(FridgeItem fridgeItem);

    @Query("select * from fridgeItem")
    public List<FridgeItem> getFridgeItem();

    @Delete
    public void deleteFridgeItem(FridgeItem fridgeItem);

    @Update
    public void updateFridgeItem(FridgeItem fridgeItem);

}