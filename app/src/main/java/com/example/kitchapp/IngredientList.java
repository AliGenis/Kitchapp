package com.example.kitchapp;

import java.util.List;

public abstract class IngredientList {

    /**
     * Method for add any amount of that ingredient
     * @param name name of ingredient
     * @param number desired amount
     */
    public void add(String name, int number) {

        Ingredient ingredient = new Ingredient();

        if( findByName(name) == null )
        {
            ingredient.setName(name);
            ingredient.setNumber(number);
            ingredient.setInFridge(false);
            ingredient.setInShoppingList(false);
            MainActivity.roomDatabaseClass.ingredientDao().addIngredient(ingredient);
        }
        else {
            ingredient = findByName(name);
            ingredient.setNumber( ingredient.getNumber() + number );
            MainActivity.roomDatabaseClass.ingredientDao().updateIngredient(ingredient);
        }
    }

    /**
     * Method for delete any amount of that ingredient
     * @param name name of ingredient
     * @param number desired amount
     */
    public void eat(String name, int number) {

        Ingredient ingredient = new Ingredient();

        if( findByName(name) == null )
        {
            ingredient.setName(name);
            ingredient.setNumber(0);
            MainActivity.roomDatabaseClass.ingredientDao().addIngredient(ingredient);
        }
        else {
            ingredient = findByName(name);
            ingredient.setNumber( ingredient.getNumber() - number );
            MainActivity.roomDatabaseClass.ingredientDao().updateIngredient(ingredient);
        }
    }

    public void removeFromDb (String name) {

        Ingredient ingredient = findByName(name);

        if(findByName(name) != null) {
            MainActivity.roomDatabaseClass.ingredientDao().deleteIngredient(ingredient);
        }
    }

    /**
     * -Burak~ It helps when you do not want to mess with number.
     *
     * @param name Name of the Ingredient that will be searched.
     * @return Ingredient if it found, null vice-versa.
     */
    public Ingredient findByName(String name) {
        List<Ingredient> list
                = MainActivity.roomDatabaseClass.ingredientDao().getByName(name);
        if(list.isEmpty())
            return null;
        else
            return list.get(0);
    }
}
