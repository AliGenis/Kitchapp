package com.example.kitchapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Ingredient {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "ingredientName", defaultValue = "empty")
    private String name;

    @ColumnInfo(name = "ingredientQuantity", defaultValue = "0")
    private int number;

    @ColumnInfo(name = "buyValue", defaultValue = "0")
    private int buyValue;

    @ColumnInfo(name = "isInFridge", defaultValue = "false")
    private boolean isInFridge;

    @ColumnInfo(name = "isInShoppingList", defaultValue = "false")
    private boolean isInShoppingList;

    public Ingredient(){}

    @Ignore
    public Ingredient(String name, int number){
        this.name = name;
        this.number = number;
    }

    /**
     * get method for id
     * @return int id
     */
    public int getId() {
        return id;
    }

    /**
     * set method for id property
     * @param id takes an int value and set the id to it.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get method for name property
     * @return String name
     */
    public String getName() {
        return name;
    }
    /**
     * set method for name property
     * @param name takes a String type variable from outside and sets the name to it
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get method for number property
     * @return int number
     */
    public int getNumber() {
        return number;
    }

    /**
     * set method for number property
     * @param number takes an int value from outside and sets the number to it.
     */
    public void setNumber(int number) {
        if ( number > 0 )
            this.number = number;
        else {
            this.number = 0;
            isInShoppingList = true;
            isInFridge = false;
        }

    }

    /**
     * get method for buyValue property
     * @return int buyValue;
     */
    public int getBuyValue() {
        return buyValue;
    }

    /**
     * set method for buyValue property
     * @param buyValue takes an int value from outside and sets the buyValue; to it.
     */
    public void setBuyValue(int buyValue) {
        if ( buyValue >= 0 )
            this.buyValue = buyValue;
        else
            this.buyValue = 0;
    }

    /**
     * check method for the ingredient object to see whether Fridge contains the Object
     * @return boolean isInFridge
     */
    public boolean isInFridge() {
        return isInFridge;
    }

    /**
     * set method for isInFridge property
     * @param inFridge takes a boolean value and set the isInFridge to it.
     */
    public void setInFridge(boolean inFridge) {
        isInFridge = inFridge;
    }

    /**
     * check method for the ingredient object to see whether ShoppingList contains the Object
     * @return boolean isInShoppingList
     */
    public boolean isInShoppingList() {
        return isInShoppingList;
    }

    /**
     * set method for property isInShoppingList
     * @param inShoppingList takes a boolean value and set the isInShoppingList to it.
     */
    public void setInShoppingList(boolean inShoppingList) {
        isInShoppingList = inShoppingList;
    }
}
