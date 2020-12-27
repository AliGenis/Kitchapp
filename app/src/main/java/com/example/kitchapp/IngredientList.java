package com.example.kitchapp;

import java.util.ArrayList;

public abstract class IngredientList {
    protected ArrayList<Ingredient> list;

    public IngredientList() {
        list = new ArrayList<>();
    }

    public boolean add(Ingredient ingredient, int number) {
        //If there is already this ingredient
        for (int i = 0; i <= list.size() - 1; i++) {
            if (list.get(i).getName().equalsIgnoreCase(ingredient.getName())) {
                list.get(i).setNumber(list.get(i).getNumber() + number);
                return true;
            }
        }
        //If there is not this ingredient
        ingredient.setNumber(number);
        list.add(ingredient);
        return true;
    }

    public void eat(Ingredient ingredient, int number) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(ingredient.getName())) {
                //If there isn't any left after eat
                // fixed error -Emre
                if (list.get(i).getNumber() == 0)
                    list.remove(i);
                else
                    list.get(i).setNumber(list.get(i).getNumber() - number);
                return;
            }
        }
    }

    /**
     * -Burak~ It helps when you do not want to mess with number.
     *
     * @param name Name of the Ingredient that will be searched.
     * @return Ingredient if it finded, null vice-versa.
     */
    public Ingredient findByName(String name) {

        for (int i = 0; i < list.size(); i++) {
            if (name.equals(list.get(i).getName()))
                return list.get(i);
        }

        return null;
    }
}
