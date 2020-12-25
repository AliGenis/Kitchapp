package com.example.kitchapp;

import androidx.room.RoomDatabase;

public abstract class RoomDatabaseClass extends RoomDatabase {
    public abstract Ingredient ingredientDao();
}
