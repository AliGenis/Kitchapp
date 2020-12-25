package com.example.kitchapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Ingredient.class, Recipe.class}, version = 2)
public abstract class RoomDatabaseClass extends RoomDatabase {

    public abstract RecipeDao recipeDao();

    public abstract IngredientDao ingredientDao();
}
