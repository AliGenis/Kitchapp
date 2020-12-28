package com.example.kitchapp;

import java.util.ArrayList;
import java.util.List;

import static com.example.kitchapp.MainActivity.fridge;

/**
 * Shopping list consists of ingredients that will be bought.
 *
 * @author Burak, Ali
 * @version 10/12/2020
 */
public class ShoppingList extends IngredientList {

    /**
     * Method to add ingredient to shopping list
     * @param name name of that ingredient
     * @param buyValue amount of it
     */
    public void addToShoppingList(String name, int buyValue) {
        add(name, 0);
        Ingredient ingredient = findByName(name);
        ingredient.setInShoppingList(true);
        ingredient.setBuyValue(buyValue);
        MainActivity.roomDatabaseClass.ingredientDao().updateIngredient(ingredient);
    }

    /**
     * Sets how many of this ingredient will be added to cart.
     *
     * @param name      The ingredient whose +/- button pressed
     * @param number    Number of Ingredient that will be added to cart
     */
    public void setBuyValue(String name, int number) {
        add(name,0);
        Ingredient ingredient = findByName(name);
        ingredient.setInShoppingList(true);
        ingredient.setBuyValue(number);
        MainActivity.roomDatabaseClass.ingredientDao().updateIngredient(ingredient);
    }

    /**
     * Method for move ingredients from shopping list to fridge
     * @param checkedItems checkbox values for ingredients
     * @param ingredientList list of ingredients
     */
    public void buy(boolean[] checkedItems, List<Ingredient> ingredientList) {
        for (int i = 0; i < checkedItems.length; i++) {
            if(checkedItems[i]){
                System.out.println(checkedItems.length);
                Ingredient ingredient = ingredientList.get(i);
                ingredient.setNumber( ingredient.getNumber() + ingredient.getBuyValue() );
                ingredient.setInFridge(true);
                ingredient.setInShoppingList(false);
                MainActivity.roomDatabaseClass.ingredientDao().updateIngredient(ingredient);
            }
        }
    }

    /**
     * Method for access all ingredients in shopping list
     * @return all ingredients in shopping list
     */
    public List<Ingredient> getInShoppingList() {
        return MainActivity.roomDatabaseClass.ingredientDao().getInShoppingList();
    }

    /**
     * Method for remove desired ingredient from shopping list
     * @param name name of desired ingredient
     */
    public void removeFromShoppingList(String name) {
        Ingredient ingredient = findByName(name);
        ingredient.setInShoppingList(false);
        MainActivity.roomDatabaseClass.ingredientDao().updateIngredient(ingredient);
    }
}
