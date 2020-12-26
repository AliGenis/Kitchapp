package com.example.kitchapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Ingredient {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "ingredientName", defaultValue = "empty")
    private String name;

    @ColumnInfo(name = "ingredientQuantity")
    private int number;

    @ColumnInfo(name = "defaultBuyValue", defaultValue = "0")
    private int defaultBuyValue;

    @ColumnInfo(name = "isInFridge", defaultValue = "false")
    private boolean isInFridge;

    @ColumnInfo(name = "isInShoppingList", defaultValue = "false")
    private boolean isInShoppingList;

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

    public boolean isInFridge() {
        return isInFridge;
    }

    public void setInFridge(boolean inFridge) {
        isInFridge = inFridge;
    }

    public boolean isInShoppingList() {
        return isInShoppingList;
    }

    public void setInShoppingList(boolean inShoppingList) {
        isInShoppingList = inShoppingList;
    }
}
