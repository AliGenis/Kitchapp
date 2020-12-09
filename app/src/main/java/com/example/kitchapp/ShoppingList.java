package com.example.kitchapp;

import java.util.ArrayList;

/**
 * Shopping list consists of ingredients that will be bought.
 * @author Burak, Ali
 * @version 10/12/2020
 */
public class ShoppingList extends IngredientList{

    //VARIABLES
    private ArrayList<Boolean> isInTheCart;
    private ArrayList<Integer> buyValue;
    private int numOfIngredients;
    private Fridge fridge;

    //CONSTRUCTORS

    //Fridge is not specified. It must be set to buy things.
    public ShoppingList( ArrayList<Ingredient> shoppingList ) {
        super();
        list = shoppingList;
        numOfIngredients = shoppingList.size();
        for( int i = 0 ; i < numOfIngredients ; i++ ){
            isInTheCart.add( false );
            buyValue.add( 0 );
        }
    }
    
    //Fridge is specified. Ingredients will be added to given Fridge.
    public ShoppingList(ArrayList<Ingredient> shoppingList, Fridge fridge ) {
        super();
        numOfIngredients = shoppingList.size();
        this.fridge = fridge;
        for( int i = 0 ; i < numOfIngredients ; i++ ){
            isInTheCart.add( false );
            buyValue.add( 0 );
        }
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

    public int getNumOfIngredients() {
        return numOfIngredients;
    }

    public void setNumOfIngredients(int numOfIngredients) {
        this.numOfIngredients = numOfIngredients;
    }

    public Fridge getFridge() {
        return fridge;
    }

    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }

    //METHODS
    /**
     * Adds checked ingredients to the fridge when user clicked to the buy button.
     */
    public void buy(){
        for ( int i = 0 ; i < numOfIngredients ; i++ ){
            if( isInTheCart.get(i) )
                fridge.add( list.get(i) , buyValue.get(i) );
        }
    }

    /**
     * Sets how many of this ingredient will be added to cart.
     * @param ingredient    The ingredient whose +/- button pressed
     * @param number        Number of Ingredient that will be added to cart
     */
    public void setBuyValue( Ingredient ingredient, int number ){
        int index = list.indexOf( ingredient );
        buyValue.set( index , number );
    }

    /**
     *
     * @param name      Name of the new ingredient
     * @param number    Number of new Ingredient that will be added to cart
     * @return newIngredient will be used for adding new item to database purposes.
     */
    public Ingredient addNew( String name, int number ){
        Ingredient newIngredient = new Ingredient( name, number );
        list.add( newIngredient );
        return newIngredient; //
    }
}
