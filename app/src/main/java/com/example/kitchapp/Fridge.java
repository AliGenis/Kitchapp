package com.example.kitchapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Fridge
 *
 * @author Burak, Emre, Gülçin
 * @version 12/12/2020
 */
public class Fridge extends IngredientList {

    public void addToFridge(String name, int number) {
        add(name, number);
        Ingredient ingredient = findByName(name);
        ingredient.setInFridge(true);
        MainActivity.roomDatabaseClass.ingredientDao().updateIngredient(ingredient);
    }

    public void removeFromFridge(String name) {
        Ingredient ingredient = findByName(name);
        ingredient.setInFridge(false);
        MainActivity.roomDatabaseClass.ingredientDao().updateIngredient(ingredient);
    }

    /**
     * adds just one to ingredient number
     *
     * @param name
     */
    public void addByOne(String name) {
        addToFridge(name, 1);
    }

    public boolean isInFridge(Recipe recipe) {
        List<Ingredient> list = recipe.getIngredientList();
        for (int i = 0; i < list.size(); i++) {
            Ingredient ingredient = findByName(list.get(i).getName());
            if (ingredient == null || !ingredient.isInFridge())
                return false;
        }
        return true;
    }

    /**
     * eats just one from the amount of ingredient
     *
     * @param name
     */
    public void eatByOne(String name) {
        eat(name, 1);
    }

//    /**
//     * -Burak ~ We can change return type to an IngredientList ???
//     * // tried to do the return type Ingredientlist but as it is abstract there were errors (deleted) -Emre
//     *
//     * @param user The user who requested a suggestion.
//     * @return A specific ArrayList of Ingredient that will be used by suggestion.
//     */
//    public ArrayList<Ingredient> ingredientsSpecificToUser(User user) {
//
//        ArrayList<Ingredient> allergiesList = user.getAllergiesList();
//        ArrayList<Ingredient> specificIngredients = (ArrayList<Ingredient>) list.clone();
//
//        for (int i = 0; i < allergiesList.size(); i++) {
//            if (findByName(allergiesList.get(i).getName()) != null)
//                specificIngredients.remove(findByName(allergiesList.get(i).getName()));
//        }
//
//        return specificIngredients;
//        return null;
//    }
//
//    /**
//     * -Burak ~ We can make a new RecipeList class ???
//     *
//     * @param user The user who requested a suggestion.
//     * @return A specific ArrayList of Recipe that will be used by suggestion.
//     */
//    public ArrayList<Recipe> recipesSpecificToUser(User user) {
//        //TODO: We need to get the full recipe list from database...
//
//        ArrayList<Recipe> recipes; //Assume that we got the full recipe list.
//        recipes = new ArrayList<Recipe>();
//        ArrayList<Recipe> undesired = user.getUndesiredMeals();
//
//        for (int i = 0; i < undesired.size(); i++) {
//            recipes.remove(undesired.get(i));
//        }
//        return recipes;
//    }

//    /**
//     * -Burak, Emre ~ Please read FIXME and TODO entries.
//     *
//     * @param user The user who requested a suggestion.
//     * @return A specific ArrayList of Recipe that will be used by suggestion.
//     */
//    public ArrayList<Recipe> suggest(User user) {
//        //FIXME: This method is not completed and not true. I implemented to show an algorithm.
//        //TODO: We should return a randomized Recipe ArrayList and suggest sequentially in case
//        // user rejects meal.
//        // I think we should find another way to store number of Ingredient because it gives trouble
//        // when comparing fridge ingredients and recipe ingredients. Or it's fine if you can find
//        // another way to solve this :) -Burak
//        // maybe fixed :) -Emre
//
//        ArrayList<Ingredient> usableIngredients;
//        ArrayList<Recipe> usableRecipes;
//
//        usableIngredients = ingredientsSpecificToUser(user);
//        usableRecipes = recipesSpecificToUser(user);
//
//        for (int i = 0; i < usableRecipes.size(); i++) {
//            if (!fridgeContains(usableRecipes.get(i), usableIngredients))
//                usableRecipes.remove(i);
//        }
//
//        Collections.shuffle(usableRecipes);
//
//        return usableRecipes;
//    }

    /**
     * -Burak, Emre ~ TODO: We need another method that connects suggest and eat functions. //maybe it is fixed (?)
     * When user accepts a recipe, the ingredients will be remove from fridge.
     */
    public void eatMeal(Recipe meal) {
        List<Ingredient> recipeIngredients = meal.getIngredientList();

        for (int i = 0; i < recipeIngredients.size(); i++) {
            eat(recipeIngredients.get(i).getName(), recipeIngredients.get(i).getNumber());
        }
    }

    public List<Recipe> suggest() {
        List<Recipe> allRecipes = MainActivity.roomDatabaseClass.recipeDao().getRecipe();
        List<Recipe> suggestionList = new ArrayList<>();
        for (int i = 0; i < allRecipes.size(); i++) {
            if (isInFridge(allRecipes.get(i)))
                suggestionList.add(allRecipes.get(i));
        }
        Collections.shuffle(suggestionList);
        return suggestionList;
    }

    public List<Ingredient> getInFridge() {
        return MainActivity.roomDatabaseClass.ingredientDao().getInFridge();
    }
}