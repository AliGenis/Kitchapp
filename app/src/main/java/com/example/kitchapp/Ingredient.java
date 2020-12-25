package com.example.kitchapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Ingredient {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "ingredientName")
    private String name;

    @ColumnInfo(name = "ingredientQuantity")
    private int number;

    @ColumnInfo(name = "defaultBuyValue")
    private int defaultBuyValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDefaultBuyValue() {
        return defaultBuyValue;
    }

    public void setDefaultBuyValue(int defaultBuyValue) {
        this.defaultBuyValue = defaultBuyValue;
    }
}
