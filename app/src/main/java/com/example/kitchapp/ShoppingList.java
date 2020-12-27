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

    //VARIABLES
    private ArrayList<Boolean> isInTheCart;
    private ArrayList<Integer> buyValue;
    //private int numOfIngredients;

    //CONSTRUCTORS

    //Fridge is not specified. It must be set to buy things.
    public ShoppingList(List<Ingredient> shoppingList) {
        super();
        list = shoppingList;
    }

    //GETTERS AND SETTERS
    public ArrayList<Boolean> getIsInTheCart() {
        return isInTheCart;
    }

    public void setIsInTheCart(ArrayList<Boolean> isInTheCart) {
        this.isInTheCart = isInTheCart;
    }

    public ArrayList<Integer> getBuyValue() {
        return buyValue;
    }

    public void setBuyValue(ArrayList<Integer> buyValue) {
        this.buyValue = buyValue;
    }
/*
    public int getNumOfIngredients() {
        return numOfIngredients;
    }

    public void setNumOfIngredients(int numOfIngredients) {
        this.numOfIngredients = numOfIngredients;
    }
*/

    //METHODS
    /**
     * Sets how many of this ingredient will be added to cart.
     *
     * @param ingredient The ingredient whose +/- button pressed
     * @param number     Number of Ingredient that will be added to cart
     */
    public void setBuyValue(Ingredient ingredient, int number) {
        int index = list.indexOf(ingredient);
        buyValue.set(index, number);
    }

    /**
     * @param name   Name of the new ingredient
     * @param number Number of new Ingredient that will be added to cart
     * @return newIngredient will be used for adding new item to database purposes.
     */
    public Ingredient addNew(String name, int number) {
        Ingredient newIngredient = new Ingredient();
        list.add(newIngredient);
        return newIngredient; //
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
}
