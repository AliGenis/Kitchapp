package com.example.kitchapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Ingredient {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "ingredientName", defaultValue = "empty")
    private String name;

    @ColumnInfo(name = "ingredientQuantity", defaultValue = "0")
    private int number;

    @ColumnInfo(name = "defaultBuyValue", defaultValue = "0")
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
