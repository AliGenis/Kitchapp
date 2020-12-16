package com.example.kitchapp;

import java.util.ArrayList;

public class RecipeList {

    ArrayList<Recipe> recipes;

    public RecipeList(){
        recipes = new ArrayList<Recipe>();
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

}
