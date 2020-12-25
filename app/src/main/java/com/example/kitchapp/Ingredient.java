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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){ return name; }

    public void setName(String newName){
        this.name = newName;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number){
        this.number = number;
    }

}
