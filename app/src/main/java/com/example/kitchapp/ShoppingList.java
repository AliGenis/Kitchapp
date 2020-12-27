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

    public List<Ingredient> getInShoppingList() {
        return MainActivity.roomDatabaseClass.ingredientDao().getInShoppingList();
    }

    public void removeFromShoppingList(String name) {
        Ingredient ingredient = findByName(name);
        ingredient.setInShoppingList(false);
        MainActivity.roomDatabaseClass.ingredientDao().updateIngredient(ingredient);
    }
}
