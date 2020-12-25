package com.example.kitchapp;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

/**
 * Ingredients
 * @author
 * @version 12/12/2020
 */
public class Ingredient {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "ingredientName")
    private String name;
    @ColumnInfo(name = "ingredientQuantity")
    private int number;
    @ColumnInfo(name = "criticalNumber")
    private int criticalNumber;
    @ColumnInfo(name = "defaultBuyValue")
    private int defaultBuyValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Ingredient(int number,int criticalNumber,String name){
        this.number = number;
        this.criticalNumber = criticalNumber;
        this.name = name;
    }
    public Ingredient(int number,String name){
        this.number = number;
        this.name = name;
    }

    //Only name and number specified, other variables has set by default values. -Burak
    public Ingredient( String name, int number) {
        this.name = name;
        this.number = number;
        defaultBuyValue = number; //How much firstly bought will be offered next time.
        criticalNumber = 3; //Or may it will be asked later when setting it shopable?
    }

    public String getName(){ return name; }

    public void setName(String newName){
        this.name = newName;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int newNumber){
        this.number = number;
    }

}
