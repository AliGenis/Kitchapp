package com.example.kitchapp;

import java.util.ArrayList;

public class RecipeList {

    private ArrayList<Recipe> recipes = new ArrayList<Recipe>();
    private ArrayList<Ingredient> Ing = new ArrayList<Ingredient>();

    public RecipeList(){
        Ing.add(new Ingredient("Egg",1));
        recipes.add(new Recipe( "Boiled Egg",
                "Boil the eggs for about 5 to 20 mins according to your preference",
                Ing,
                15,
                15,
                false ));
    }

    public void addToList( Recipe e ){
        recipes.add( e );
    }

    public Recipe findByName( String a ){
            for ( int i = 0; i<recipes.size(); i++ ){
                if ( recipes.get(i).getName().equalsIgnoreCase( a ) ) {
                    return recipes.get(i);
                }
            } return null;
    }

    public ArrayList<String> toArray(){
        ArrayList<String> arr = new ArrayList<String>();
        for ( int i =0; i<recipes.size(); i++ ){
            arr.add( recipes.get(i).getName() );
        }
    return arr;
    }


}
