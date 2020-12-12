package com.example.kitchapp;
import java.util.*;

/**
 * Fridge
 * @author Burak, Emre
 * @version 12/12/2020
 */
public class Fridge extends IngredientList {
    Recipe param;
    //constructor
    public Fridge( ArrayList<Ingredient> list ){
        super();
        this.list = list;
    }

    /**
     * adds just one to ingredient number
     * @param ingredient
     */
    public void addByOne(Ingredient ingredient){
        add( ingredient,1);
    }
    /**
     * eats just one from the amount of ingredient
     * @param ingredient
     */
    public void eatByOne(Ingredient ingredient){ //same as above
        eat( ingredient, 1);
    }

    /**
     * -Burak ~ We can change return type to an IngredientList ???
     * // tried to do the return type Ingredientlist but as it is abstract there were errors (deleted) -Emre
     * @param user The user who requested a suggestion.
     * @return  A specific ArrayList of Ingredient that will be used by suggestion.
     */
    public ArrayList<Ingredient> ingredientsSpecificToUser(User user){

        ArrayList<Ingredient> allergiesList = user.getAllergiesList();
        ArrayList<Ingredient> specificIngredients = (ArrayList<Ingredient>) list.clone();

        for ( int i = 0 ; i < allergiesList.size() ; i++ ){
            if( findByName( allergiesList.get(i).getName() ) != null )
                specificIngredients.remove( findByName( allergiesList.get(i).getName() ) );
        }

        return specificIngredients;

    }

    /**
     * -Burak ~ We can make a new RecipeList class ???
     * @param user The user who requested a suggestion.
     * @return  A specific ArrayList of Recipe that will be used by suggestion.
     */
    public ArrayList<Recipe> recipesSpecificToUser(User user){
        //TODO: We need to get the full recipe list from database...

        ArrayList<Recipe> recipes; //Assume that we got the full recipe list.
        recipes = new ArrayList<Recipe>();
        ArrayList<Recipe> undesired = user.getUndesiredMeals();

        for( int i = 0; i < undesired.size() ; i++ ){
            recipes.remove( undesired.get(i) );
        }
        return recipes;
    }

    /**
     * -Burak, Emre ~ Please read FIXME and TODO entries.
     * @param user The user who requested a suggestion.
     * @return  A specific ArrayList of Recipe that will be used by suggestion.
     */
    public Recipe suggest(User user){
        //FIXME: This method is not completed and not true. I implemented to show an algorithm.
        //TODO: We should return a randomized Recipe ArrayList and suggest sequentially in case
        // user rejects meal.
        // I think we should find another way to store number of Ingredient because it gives trouble
        // when comparing fridge ingredients and recipe ingredients. Or it's fine if you can find
        // another way to solve this :) -Burak
        // maybe fixed :) -Emre

        ArrayList<Ingredient> usableIngredients;
        ArrayList<Recipe> usableRecipes;

        usableIngredients   =   ingredientsSpecificToUser(user);
        usableRecipes       =   recipesSpecificToUser(user);

        ArrayList<Recipe> randomizedRecipes;
        randomizedRecipes = new ArrayList<Recipe>();

        for( int i = 0 ; i < usableRecipes.size() ; i++ ) {

            if( usableIngredients.containsAll( usableRecipes.get(i).getIngredients() ) ) {
                randomizedRecipes.add(usableRecipes.get(i));
                param = randomizedRecipes.get((int)(Math.random()*(randomizedRecipes.size())));
                return randomizedRecipes.get((int)(Math.random()*(randomizedRecipes.size())));
            }
        }
        return null;
    }

    /**
     * -Burak, Emre ~ TODO: We need another method that connects suggest and eat functions. //maybe it is fixed (?)
     * When user accepts a recipe, the ingredients will be remove from fridge.
     */
    public void eatMeal(){
        ArrayList<Ingredient> recipeIngredients;
        recipeIngredients = param.getIngredients();

        for( int i = 0 ; i < recipeIngredients.size() ; i++ )
            eat( recipeIngredients.get(i) , recipeIngredients.get(i).getNumber() );
    }

}
