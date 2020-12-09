package com.example.kitchapp;

import java.util.ArrayList;

public abstract class IngredientList {
    protected ArrayList<Ingredient> list;

    public IngredientList (){
        list = new ArrayList<Ingredient>();
    }

    public boolean add( Ingredient ingredient , int number ){
        //If there is already this ingredient
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getName().equalsIgnoreCase(ingredient.getName())){
                list.get(i).setNumber( list.get(i).getNumber() + number );
                return true;
            }
        }
        //If there is not this ingredient
        ingredient.setNumber( number );
        list.add(ingredient);
        return true;
    }
    public boolean eat( Ingredient ingredient , int number ){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getName().equalsIgnoreCase(ingredient.getName())){
                //If there isn't any left after eat
                if(list.get(i).getNumber() <= number)
                    list.remove(i);
                else
                    list.get(i).setNumber( list.get(i).getNumber() - number );
                return true;
            }
        }
        return false;
    }
}
