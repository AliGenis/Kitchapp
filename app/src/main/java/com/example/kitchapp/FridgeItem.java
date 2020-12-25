package com.example.kitchapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FridgeItem {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "fridgeItemName")
    private String name;

    @ColumnInfo(name = "fridgeItemQuantity")
    private int number;

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
}