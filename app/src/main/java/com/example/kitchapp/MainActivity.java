package com.example.kitchapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import com.example.kitchapp.ui.fridge.FridgeFragment;
import com.example.kitchapp.ui.recipes.RecipesFragment;
import com.example.kitchapp.ui.settings.SettingsFragment;
import com.example.kitchapp.ui.shoppinglist.ShoppingListFragment;
import com.example.kitchapp.ui.suggestion.SuggestionFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static RoomDatabaseClass roomDatabaseClass;
    public static Fridge fridge;
    public static ShoppingList shoppingList;

    // Navigation listener
    private final BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @SuppressLint("NonConstantResourceId")
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.dislikeButton:
                            selectedFragment = new FridgeFragment();
                            break;

                        case R.id.shoppingListScreenFragment:
                            // Intent intent1 = new Intent(MainActivity.this, ShoppingListScreenFragment.class);
                            //   startActivity(intent1);
                            selectedFragment = new ShoppingListFragment();
                            break;

                        case R.id.suggestionScreen:
                            //     Intent intent2 = new Intent(MainActivity.this, SuggestionScreen.class);
                            //  startActivity(intent2);
                            selectedFragment = new SuggestionFragment();
                            break;
                        case R.id.recipesFragment:
                            //      Intent intent3 = new Intent(MainActivity.this, RecipesFragment.class);
                            //     startActivity(intent3);
                            selectedFragment = new RecipesFragment();
                            break;

                        case R.id.settingsFragment:
                            selectedFragment = new SettingsFragment();
                            //   Intent intent4 = new Intent(MainActivity.this, SettingsFragment.class);
                            //   startActivity(intent4);
                            break;
                    }
                    assert selectedFragment != null;
                    fragmentManager.beginTransaction().replace(R.id.Container, selectedFragment).commit();
                    return true;
                }
            };


    public void addRecipesToDatabase(){
        ArrayList<Ingredient> ingredients;
        Recipe recipe;

        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Butter" , 50)); //change 5 with required number
        ingredients.add(new Ingredient( "Egg" , 1));
        recipe.setName( "Pan-Fried Eggs" );
        recipe.setRecipe( "After adding some butter on the pan, fry your eggs until bottom of the egg layer " +
                "becomes crispy" );
        recipe.setPrepTime( 10 );
        recipe.setCalorie( 115 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Egg" , 1)); //change 5 with required number
        recipe.setName( "Poached Egg" );
        recipe.setRecipe( "After boiling the water in a pot, add the eggs while spinning the water inside. " +
                "Wait for 5 to 10 mins and then you are finished." );
        recipe.setPrepTime( 10 );
        recipe.setCalorie( 95 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Banana" , 2)); //change 5 with required number
        ingredients.add(new Ingredient( "Egg" , 1));
        ingredients.add(new Ingredient( "Butter" , 50));
        ingredients.add(new Ingredient( "Flour" , 150));
        ingredients.add(new Ingredient( "Baking soda" , 1));
        recipe.setName( "Banana Bread" );
        recipe.setRecipe( "Preheat oven to 325 degrees F (165 degrees C). Grease a 9x5-inch loaf pan. " +
                "Combine bananas, sugar, egg, and butter together in a bowl. Mix flour and baking soda together in a separate bowl; " +
                "stir into banana mixture until batter is just mixed. Stir salt into batter." +
                " Pour batter into the prepared loaf pan. " +
                "Bake in the preheated oven until a toothpick inserted in the center of the bread comes out clean, about 1 hour. "  );
        recipe.setPrepTime( 75 );
        recipe.setCalorie( 326 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Butter" , 1)); //change 5 with required number
        ingredients.add(new Ingredient( "Olive oil" , 1));
        ingredients.add(new Ingredient( "Onion" , 1));
        ingredients.add(new Ingredient( "Rice" , 1));
        ingredients.add(new Ingredient( "Chicken" , 1));
        //ingredients.add(new Ingredient( "salt" , 1));
        recipe.setName( "Classic Rice Pilaf" );
        recipe.setRecipe( "Preheat oven to 350 degrees F (175 degrees C). Melt butter and olive oil in a large saucepan over medium heat. " +
                "Add onion; cook and stir until onion is lightly browned, 7 to 8 minutes. " +
                "Remove from heat." +
                " Combine rice and onion mixture in a 9x13-inch casserole dish placed on a baking sheet. " +
                "Stir thoroughly to coat the rice. " +
                "Combine chicken stock and salt in a saucepan. " +
                "Bring to a boil, reduce heat to low, and simmer for 5 minutes. " +
                "Pour chicken stock mixture over rice in the casserole dish and stir to combine. " +
                "Spread mixture evenly along the bottom of the pan. " +
                "Cover tightly with heavy-duty aluminum foil. Bake in the preheated oven for 35 minutes." +
                " Remove from oven and allow to rest, covered, for 10 minutes." +
                " Remove foil and fluff with a fork to separate the grains of rice " );
        recipe.setPrepTime( 65 );
        recipe.setCalorie( 130 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Egg" , 2)); //change 5 with required number
        ingredients.add(new Ingredient( "Lemon" , 1));
        ingredients.add(new Ingredient( "Cheese" , 1));
        ingredients.add(new Ingredient( "Tuna" , 1));
        ingredients.add(new Ingredient( "Olive oil" , 1));
        recipe.setName( "Easy Tuna Patties" );
        recipe.setRecipe( "Beat eggs and lemon juice in a bowl; stir in cheese and bread crumbs to make a paste." +
                " Fold in tuna and onion until well-mixed. " +
                "Shape tuna mixture into eight 1-inch-thick patties." +
                "Heat olive oil in a skillet over medium heat; " +
                "fry patties until golden brown, about 5 minutes per side." );
        recipe.setPrepTime( 25 );
        recipe.setCalorie( 130 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Spaghetti" , 1)); //change 5 with required number
        //ingredients.add(new Ingredient( "salt" , 1));
        ingredients.add(new Ingredient( "Beef" , 1));
        ingredients.add(new Ingredient( "Parsley" , 1)); //change 5 with required number
        ingredients.add(new Ingredient( "Cheese" , 1));
        ingredients.add(new Ingredient( "Egg" , 1));
        ingredients.add(new Ingredient( "Garlic" , 1));
        ingredients.add(new Ingredient( "Onion" , 1));
        ingredients.add(new Ingredient( "Tomatoes" , 2));

        recipe.setName( "Spaghetti and meatballs" );
        recipe.setRecipe( "In a large pot of boiling salted water, cook spaghetti according to package instructions. Drain."+
                "In a large bowl, combine beef with bread crumbs, parsley, cheese, egg, garlic, 1 teaspoon salt. Mix until just combined then form into 16 balls." +
                "In a large pot over medium heat, heat oil. Add meatballs and cook, turning occasionally, until browned on all sides, about 10 minutes. Transfer meatballs to a plate." +
                "Add onion to pot and cook until soft, 5 minutes. Add crushed tomatoes.  Return meatballs to pot and cover. Simmer until sauce has thickened, 8 to 10 minutes." +
                "Serve pasta with a healthy scoop of meatballs and sauce. Top with cheese before serving." );
        recipe.setPrepTime( 60 );
        recipe.setCalorie( 97 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Flour" , 1)); //change 5 with required number
        ingredients.add(new Ingredient( "Baking powder" , 1));
        //ingredients.add(new Ingredient( "salt" , 1));
        ingredients.add(new Ingredient( "Milk" , 1));
        ingredients.add(new Ingredient( "Egg" , 1));
        ingredients.add(new Ingredient( "Butter" , 1));
        recipe.setName( "Pancake" );
        recipe.setRecipe( "In a large bowl, sift together the flour, baking powder, salt and sugar." +
                " Make a well in the center and pour in the milk, egg and melted butter; mix until smooth." +
                "Heat a lightly oiled griddle or frying pan over medium-high heat. Pour or scoop the batter onto the griddle, using approximately 1/4 cup for each pancake." +
                " Brown on both sides and serve hot." );
        recipe.setPrepTime( 20 );
        recipe.setCalorie( 227 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Tomatoes" , 2)); //change 5 with required number
        ingredients.add(new Ingredient( "Cucumber" , 1));
        ingredients.add(new Ingredient( "Olive" , 5));
        ingredients.add(new Ingredient( "Olive oil" , 1));
        ingredients.add(new Ingredient( "Vinegar" , 1));
        ingredients.add(new Ingredient( "Lemon" , 1));
        //ingredients.add(new Ingredient( "salt" , 5));
        //ingredients.add(new Ingredient( "pepper" , 1));
        recipe.setName( "Greek salad" );
        recipe.setRecipe( "Make salad: In a large bowl, stir together tomatoes, cucumber, olives, and red onion." +
                " Gently fold in feta.In a small bowl, make dressing: Combine vinegar, lemon juice and season with salt and pepper." +
                " Slowly add olive oil, whisking to combine.Drizzle dressing over salad." );
        recipe.setPrepTime( 15 );
        recipe.setCalorie( 45 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Broccoli" , 5)); //change 5 with required number
        ingredients.add(new Ingredient( "Olive oil" , 1));
        //ingredients.add(new Ingredient( "salt" , 5));
        //ingredients.add(new Ingredient( "papper" , 1));

        recipe.setName( "Easy Roasted Brocoli" );
        recipe.setRecipe( "Preheat oven to 400 degrees F (200 degrees C)." +
                "Cut broccoli florets from the stalk." +
                " Peel the stalk and slice into 1/4-inch slices. " +
                "Mix florets and stem pieces with olive oil in a bowl and transfer to a baking sheet; season with salt and pepper. " +
                "Roast in the preheated oven until broccoli is tender and lightly browned, about 18 minutes." );
        recipe.setPrepTime( 30 );
        recipe.setCalorie( 33 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Carrot" , 2)); //change 5 with required number
        //ingredients.add(new Ingredient( "salt" , 1));
        //ingredients.add(new Ingredient( "pepper" , 1));
        ingredients.add(new Ingredient( "Garlic" , 1));
        ingredients.add(new Ingredient( "Flour" , 1));
        ingredients.add(new Ingredient( "Chicken" , 1));
        ingredients.add(new Ingredient( "Potatoes" , 2));

        recipe.setName( "Chicken Strew" );
        recipe.setRecipe( "In a large pot over medium heat, melt butter." +
                " Add carrots season with salt and pepper. " +
                "Cook, stirring often, until vegetables are tender, about 5 minutes." +
                " Add garlic and cook until fragrant, about 30 seconds." +
                "Add flour and stir until vegetables are coated, then add chicken and potatoes. " +
                "Season with salt and pepper. " +
                "Bring mixture to a simmer and cook until the chicken is no longer pink and potatoes are tender, 15 minutes." +
                "Remove from heat and transfer chicken to a medium bowl. Using two forks, shred chicken into small pieces and return to the pot. " +
                "Garnish with parsley before serving" );
        recipe.setPrepTime( 45 );
        recipe.setCalorie( 237 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Sugar" , 1)); //change 5 with required number
        ingredients.add(new Ingredient( "Oil" , 1));
        ingredients.add(new Ingredient( "Flour" , 1));

        recipe.setName( "Pizza Crust" );
        recipe.setRecipe("Preheat oven to 450 degrees F (230 degrees C)." +
                " In a medium bowl, dissolve yeast and sugar in warm water." +
                " Let stand until creamy, about 10 minutes." +
                "Stir in flour, salt and oil. Beat until smooth." +
                " Let rest for 5 minutes." +
                "Turn dough out onto a lightly floured surface and pat or roll into a round.," +
                " Transfer crust to a lightly greased pizza pan or baker's peel dusted with cornmeal." +
                " Spread with desired toppings and bake in preheated oven for 15 to 20 minutes, or until golden brown. " +
                "Let baked pizza cool for 5 minutes before serving." );
        recipe.setPrepTime( 30 );
        recipe.setCalorie( 278 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Beef" , 1)); //change 5 with required number
        ingredients.add(new Ingredient( "Egg" , 1));
        ingredients.add(new Ingredient( "Onion" , 1));
        ingredients.add(new Ingredient( "Milk" , 1));
        ingredients.add(new Ingredient( "Bread" , 1));
        //ingredients.add(new Ingredient( "salt" , 1));
        //ingredients.add(new Ingredient( "pepper" , 1));
        //ingredients.add(new Ingredient( "mustard" , 1));
        //ingredients.add(new Ingredient( "ketchup" , 1));

        recipe.setName( "Easy Meatloaf" );
        recipe.setRecipe( "Preheat oven to 350 degrees F (175 degrees C)." +
                "In a large bowl, combine the beef, egg, onion, milk and bread OR cracker crumbs." +
                " Season with salt and pepper to taste and place in a lightly greased 9x5-inch loaf pan, or form into a loaf and place in a lightly greased 9x13-inch baking dish." +
                "In a separate small bowl, combine the  sugar, mustard and ketchup." +
                " Mix well and pour over the meatloaf. Bake at 350 degrees F (175 degrees C) for 1 hour." );
        recipe.setPrepTime( 149 );
        recipe.setCalorie( 70 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Yogurt" , 1)); //change 5 with required number
        ingredients.add(new Ingredient( "Butter" , 1));
        //ingredients.add(new Ingredient( "pepper" , 1));
        ingredients.add(new Ingredient( "Garlic" , 1));
        ingredients.add(new Ingredient( "Egg" , 4));
        //ingredients.add(new Ingredient( "salt" , 1));


        recipe.setName( "Turkish Cilbir" );
        recipe.setRecipe( "Place the yogurt into a fine sieve (or a sieve lined with a cloth) over a bowl for about 1 hour at room temperature to drain away some of the liquid so that the yogurt thickens further. " +
                "Mix through the garlic and season well with salt." +
                "In a small frying pan melt the butter over medium heat and add the  pepper. " +
                "Remove the pan from the heat.Bring a tall saucepan of water to a low simmer." +
                " Crack one egg into a small bowl and stir the saucepan to create a very gentle whirlpool. Pour the egg into the centre and poach for about 3 minutes until the egg is set. " +
                "Remove with a slotted spoon and drain.Spoon the yoghurt onto two serving plates then add the eggs on top. " +
                "Season with salt, spoon over a little of the butter and scatter with dill to serve." );
        recipe.setPrepTime( 10 );
        recipe.setCalorie( 142 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Potatoes" , 3)); //change 5 with required number
        ingredients.add(new Ingredient( "Olive oil" , 1));
        //ingredients.add(new Ingredient( "salt" , 1));
        //ingredients.add(new Ingredient( "pepper" , 1));
        recipe.setName( "Grilled Potatoes" );
        recipe.setRecipe( "Poke each potato with the tines of a fork. " +
                "Place the potatoes in a microwave oven, and cook on high power for about 5 minutes." +
                " Check about halfway through, and turn potatoes over for even cooking." +
                " Slice each potato in half the long way and cook potatoes another 2 minutes on high power.Preheat a grill for medium heat.  " +
                "Brush the potato tops with olive oil, and season with salt and pepper to taste." +
                " Cook on prepared grill for 15 to 20 minutes, turning once." );
        recipe.setPrepTime(27 );
        recipe.setCalorie( 120 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Beef" , 1)); //change 5 with required number
        //ingredients.add(new Ingredient( "salt" , 1));
        //ingredients.add(new Ingredient( "pepper" , 1));
        ingredients.add(new Ingredient( "Tortilla" , 6));
        //ingredients.add(new Ingredient( "sour cream" , 1));
        ingredients.add(new Ingredient( "Cheese" , 1));
        ingredients.add(new Ingredient( "Tomatoes" , 3));
        recipe.setName( "Mexican Pizza" );
        recipe.setRecipe( "Preheat the oven to 375° and line a medium baking sheet with parchment paper." +
                " Heat a large skillet over medium heat." +
                " Add ground beef, breaking up the meat with a wooden spoon. " +
                "Cook until beef is no longer pink, about 6 minutes." +
                " Drain fat. Return to heat and add taco seasoning, then season with salt and pepper. " +
                "Cook 1 minute more, then remove from heat." +
                "Assemble pizzas: Place 3 tortillas on a prepared baking sheet and spread 1/4 cup refried beans on each of them." +
                " Divide beef evenly between the tortillas, then top with 1/4 cup cheese each." +
                " Top with remaining 3 tortillas. " +
                "Spread another 1/4 cup of refried beans on each tortilla, then top each with 1/4 cup cheese." +
                "Bake until the cheese is melty and beans are warm, 10 to 12 minutes. " +
                "Garnish with sour cream, tomatoes, olives, and green onions. Serve with hot sauce." );
        recipe.setPrepTime( 35 );
        recipe.setCalorie( 767 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Butter" , 1)); //change 5 with required number
        ingredients.add(new Ingredient( "Yogurt" , 1));
        ingredients.add(new Ingredient( "Egg" , 5));
        ingredients.add(new Ingredient( "Sugar" , 1));
        //ingredients.add(new Ingredient( "salt" , 1));
        //ingredients.add(new Ingredient( "flour" , 1));
        ingredients.add(new Ingredient( "Cheese" , 1));
        ingredients.add(new Ingredient( "Parsley" , 1));
        ingredients.add(new Ingredient( "Olive oil" , 1));
        recipe.setName( "Pogacha" );
        recipe.setRecipe( "Preheat oven to 375 degrees F (190 degrees C). Line a baking sheet with parchment paper. " +
                "Mix the flour with baking soda in a bowl; set aside." +
                "Mix the butter, yogurt, eggs, sour cream, sugar, and salt together in a large mixing bowl until smooth." +
                " Gradually stir the flour mixture into the wet ingredients to form a soft dough. " +
                "Knead and squeeze the dough in the bowl until it is no longer sticky, about 5 minutes. " +
                "Stir the feta cheese, parsley, olive oil together in a bowl with a fork to make a filling." +
                "Make each dumpling by pinching off about 2 1/2 tablespoons of dough; roll into a ball about 1 3/4 inches across between your hands, and press it into a flat circle 3 inches across on your palm. " +
                "Spoon 1 scant tablespoon of filling into the center of the circle." +
                " Bring the edges of the circle together over the filling, and pinch them together to make a fat, round little stuffed dumpling. " +
                "Set the dumplings onto the parchment paper-lined baking sheet, seam sides down." +
                " Beat the egg yolks in a small bowl, and" +
                "brush the pogaca tops with the egg yolk. " +
                "Sprinkle each with about 1/4 teaspoon of sesame seeds. " +
                "Bake in the preheated oven until the tops are shiny, brown, and crackled, 20 to 30 minutes." );
        recipe.setPrepTime( 60 );
        recipe.setCalorie( 550 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Beef" , 1)); //change 5 with required number
        ingredients.add(new Ingredient( "Onion" , 1));
        ingredients.add(new Ingredient( "Cheese" , 1));
        ingredients.add(new Ingredient( "Soy sauce" , 1));
        ingredients.add(new Ingredient( "Parsley" , 1));
        ingredients.add(new Ingredient( "Egg" , 1));
        ingredients.add(new Ingredient( "Garlic" , 1));
        //ingredients.add(new Ingredient( "salt" , 1));
        //ingredients.add(new Ingredient( "pepper" , 1));

        recipe.setName( "Hamburger" );
        recipe.setRecipe( "Preheat a grill for high heat." +
                "In a large bowl, mix together the ground beef, onion, cheese, soy sauce, egg,  garlic,  parsley,  salt, and pepper." +
                " Form into 4 patties. Grill patties for 5 minutes per side on the hot grill, or until well done." +
                " Serve on buns with your favorite condiments." );
        recipe.setPrepTime( 30 );
        recipe.setCalorie( 294 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Flour" , 1)); //change 5 with required number
        ingredients.add(new Ingredient( "Onion" , 1));
        ingredients.add(new Ingredient( "Beef" , 1));
        //ingredients.add(new Ingredient( "salt" , 1));
        //ingredients.add(new Ingredient( "pepper" , 1));
        recipe.setName( "Turkish Manti" );
        recipe.setRecipe( "Combine the flour and salt in a mixing bowl." +
                " Add the eggs and water, mixing well with your hands." +
                " Add more water, if needed, to form a soft dough." +
                " Cover and set aside for at least 30 minutes." +
                " Shred the onions and place them in a colander or sieve set over a bowl; drain the juice and discard. " +
                "Combine the onion, ground beef, salt, and pepper; mix the meat well with a spoon until mashed." +
                "Divide the dough into two portions and lightly flour a work surface. " +
                "Keep one piece of dough covered while you roll out the second portion into a rectangle, rolling the dough as thin as you can." +
                " Cut the rectangle into 2-inch squares with a knife or pastry wheel." +
                "Place about 2 teaspoons of the meat filling in the center of each square." +
                " Seal the dumplings by gathering the edges of the dough and pinching them together at the top to form a bundle." +
                " Transfer the finished manti to a floured plate, and sprinkle more flour over the manti to prevent sticking." +
                "Repeat with the second piece of dough. Heat the oil and red pepper flakes in a small skillet over low heat just until the pepper flakes have started to color the oil; don't let them burn." +
                " Remove from the heat and keep warm. Stir the minced garlic into the yogurt and set aside." +
                "Bring a large pot of salted water to a boil over medium-high heat, and cook the manti until the filling is no longer pink, and the dough is tender, 20 to 25 minutes. " +
                "Drain well. Divide the manti among four plates. " +
                "Spoon the yogurt sauce over the manti and drizzle each serving with the hot pepper oil." );
        recipe.setPrepTime( 90 );
        recipe.setCalorie( 322 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Butter" , 1)); //change 5 with required number
        ingredients.add(new Ingredient( "Milk" , 1));
        ingredients.add(new Ingredient( "Cream" , 1));
        //ingredients.add(new Ingredient( "salt" , 1));
        ingredients.add(new Ingredient( "Sugar" , 1));
        ingredients.add(new Ingredient( "Flour" , 1));
        recipe.setName( "French Croissant" );
        recipe.setRecipe( "Sprinkle 2 tablespoons of flour over the butter and mix it together with your hands in a mixing bowl or on a work surface." +
                " Transfer the butter to a length of foil or parchment paper and pat it into a 6 inch square. Fold up the foil to make a packet and refrigerate until chilled, about 2 hours." +
                "Combine 2 cups of the flour with the salt and sugar in a mixing bowl." +
                " Dissolve the yeast in the lukewarm water (100 degrees F/38 degrees C) and set aside until frothy, about 10 minutes. Meanwhile, warm the milk and the heavy cream to lukewarm. " +
                "Add the yeast, milk, and cream to the flour mixture and stir well." +
                " The dough will have a batter-like consistency. Stir in the remaining 2 cups of flour 1/4 cup at a time to form a soft dough. It should no longer be sticky. " +
                "Turn the dough onto a lightly floured work surface and knead until smooth, about 5 minutes. " +
                "Place the dough in a mixing bowl and cover with plastic wrap. Refrigerate for 1 hour." +
                "To begin the rolling and folding process, both the butter and the dough should be at a cool room temperature." +
                "  Place the dough on a floured surface and roll it into a 10-inch square. " +
                "Set the block of butter diagonally on the square dough." +
                " Bring each point of dough to the center of the butter square; the edges of the dough should overlap." +
                " Pinch the edges together to seal. Starting from the center of the square and working outward, use a rolling pin to roll the dough out into a rectangle." +
                " The butter should be pliable enough to roll smoothly with the dough; if it's too soft and starts to ooze out the corners, wrap the dough in plastic and refrigerate before proceeding. " +
                "Roll the dough into a long rectangle, approximately 8 by 18 inches." +
                " Fold the length of dough into thirds, like a business letter." +
                "If the dough is still cool, you can continue with another fold." +
                " Otherwise, wrap it in plastic and refrigerate for 45 minutes to 1 hour. " +
                "Remove the dough from the refrigerator and let it warm up for about 10 minutes before you begin rolling it out again. " +
                "Position the dough so that the open ends are at 12 and 6 o'clock." +
                " Roll the dough into a rectangle, working from the center of the dough and pressing outwards. " +
                "Reposition the dough as necessary to fit your work space. " +
                "You should have a long rectangle for the  " +
                "Fold both ends of the dough into the middle; the ends don't have to be touching, but should be close. " +
                "Fold the already-folded dough in half; it will look like a thick book. " +
                "Wrap the dough well with plastic and refrigerate for 1 to 2 hours." +
                " Remove the dough from the refrigerator and let it rest at room temperature for about 20 minutes." +
                " Roll the dough into a rectangle again and fold it into thirds, like a business letter." +
                " Wrap it in plastic and refrigerate for 4-6 hours or overnight." +
                "To shape the croissants, roll the dough into a 10- by 38-inch rectangle on a lightly floured work surface. " +
                "It should be about 1/4 inch thick. Use a pizza wheel or sharp paring knife to trim the edges of the dough." +
                " Divide the rectangle in half so that you have two 5-inch wide strips of dough." +
                " Use a clean yardstick to mark each strip into triangles that are 5 inches wide at their bases. " +
                "Cut the triangles and place them onto parchment-lined baking sheets." +
                " Chill for 15 to 20 minutes, if necessary." +
                "Starting at the base of the triangle, roll the dough up into a log; the tip of the triangle should be under the body of the croissant to prevent it from unraveling. " +
                "Bend in the corners to form the traditional crescent shape. " +
                "Repeat with the remaining dough." +
                " Arrange the croissants on the parchment-lined baking sheets and allow to rise until doubled in size, about 1 to 2 hours." +
                "Preheat an oven to 425 degrees F (220 degrees C). " +
                "Beat the egg with the tablespoon of water to make the egg wash." +
                " Brush the croissants with egg wash and bake in the preheated oven until deep brown, 22 to 25 minutes. " +
                "Cool on a rack before serving." );
        recipe.setPrepTime(145 );
        recipe.setCalorie( 406 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Corn" , 1)); //change 5 with required number
        //ingredients.add(new Ingredient( "salt" , 1));
        ingredients.add(new Ingredient( "Butter" , 1));
        recipe.setName( "Corn On the Tob" );
        recipe.setRecipe( "Place ear of corn in a microwave oven and cook on high for 2 minutes;" +
                " flip corn over and cook on high until kernels are hot and steaming, another 2 minutes." +
                "Place corn ear on a cutting board, using a pot holder or folded kitchen towel," +
                " and cut off the bottom of the ear," +
                " exposing 1/4 to 1/2 inch of kernels." +
                " Hold the ear from the top and squeeze ear of corn out of the husk from top to bottom." +
                " Husks and silk will be left behind." +
                " Spread ear with butter and season with salt." );
        recipe.setPrepTime( 15 );
        recipe.setCalorie( 113 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Garbanzo beans" , 1 )); //change 5 with required number
        ingredients.add(new Ingredient( "Lemon" , 1));
        ingredients.add(new Ingredient( "Olive oil" , 1));
        ingredients.add(new Ingredient( "Garlic" , 1));
        ingredients.add(new Ingredient( "Cumin" , 1));
        //ingredients.add(new Ingredient( "salt" , 1));
        ingredients.add(new Ingredient( "Sesame oil" , 1));
        recipe.setName( "Hummus" );
        recipe.setRecipe( "Blend garbanzo beans, lemon juice, olive oil, garlic, cumin,  salt, and sesame oil in a food processor;" +
                " stream reserved bean liquid into the mixture as it blends until desired consistency is achieved." );
        recipe.setPrepTime( 5 );
        recipe.setCalorie( 121 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Cream cheese" , 1)); //change 5 with required number
        //ingredients.add(new Ingredient( "mayonnaise" , 1));
        ingredients.add(new Ingredient( "Cucumber" , 2));
        ingredients.add(new Ingredient( "Bread" , 1));

        recipe.setName( "Creamy Dill Cucumber Toasties" );
        recipe.setRecipe( "In a medium bowl, mix together cream cheese, dressing mix and mayonnaise." +
                "Spread a thin layer of the cream cheese mixture on a slice of bread, and top with a slice of cucumber." +
                " Sprinkle with dill. Repeat with remaining ingredients." );
        recipe.setPrepTime( 15 );
        recipe.setCalorie( 247 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Egg" , 1)); //change 5 with required number
        ingredients.add(new Ingredient( "Bread" , 1));
        ingredients.add(new Ingredient( "Fish" , 1));

        recipe.setName( "Fish and Chips" );
        recipe.setRecipe( "In a large heavy skillet, heat oil to 375 degrees F (190 degrees C)." +
                "Dip fillets into beaten egg and dredge in bread crumbs." +
                "Gently slide fish into hot oil and fry until golden brown. " +
                "Drain briefly on paper towels. Serve hot." );
        recipe.setPrepTime( 15 );
        recipe.setCalorie( 386 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);
        
        ingredients = new ArrayList<>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Egg" , 3)); //change 5 with required number
        ingredients.add(new Ingredient( "Sugar" , 1));
        ingredients.add(new Ingredient( "Cream cheese" , 1));
        ingredients.add(new Ingredient( "Cream tartar" , 1));

        recipe.setName( "Easy Cloud Bread" );
        recipe.setRecipe( "Preheat oven to 350 degrees F (175 degrees C)." +
                " Line a baking sheet with parchment paper." +
                " Beat egg whites and cream of tartar together in a bowl until stiff peaks form." +
                " Mix egg yolks, cream cheese, and sugar together in a separate bowl" +
                " using a wooden spoon and then mixing with a hand-held egg beater until mixture is very smooth and has no visible cream cheese. " +
                "Gently fold egg whites into cream cheese mixture, taking care not to deflate the egg whites." +
                " Carefully scoop mixture onto the prepared baking sheet, forming 5 to 6. " +
                " Bake in the preheated oven until cloud bread is lightly browned, about 30 minutes." );
        recipe.setPrepTime( 40 );
        recipe.setCalorie( 93 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);


        ingredients = new ArrayList<Ingredient>();
        recipe = new Recipe();
        ingredients.add(new Ingredient( "Butter" , 1)); //change 5 with required number
        ingredients.add(new Ingredient( "Egg" , 1));
        ingredients.add(new Ingredient( "Sugar" , 1));
        ingredients.add(new Ingredient( "Flour" , 1));
        ingredients.add(new Ingredient( "Salt" , 1));
        ingredients.add(new Ingredient( "Vanilla" , 1));

        recipe.setName( "Fresh Fruit Frangipane Tart " );
        recipe.setRecipe( "Preheat oven to 400 degrees F (200 degrees C). " +
                "Place 1 piece of puff pastry on a baking sheet lined with a silicone mat or parchment paper. " +
                "Lightly moisten one of the short edges with water. " +
                "Connect the end of the other puff pastry to the moistened edge." +
                "Press pieces together to form a long rectangle, trimming off loose ends with a dough scraper as needed." +
                "Cut the third puff pastry piece lengthwise into 1-inch strips." +
                "Moisten the outer edges of the long rectangle with your finger; " +
                "stick the pastry strips on top. Poke shallow holes all over the bottom of the dough using a fork." +
                "Do not prick the raised border. " +
                "Bake pastry shell in the preheated oven until it starts to turn golden brown, about 15 minutes. " +
                "Remove from oven. Reduce oven temperature to 375 degrees F (190 degrees C)." +
                "Readjust the borders and push the bottom down with the flat side of a fork. " +
                "Let cool completely while preparing the filling." +
                "Place butter and 1/3 cup plus 1 tablespoon sugar in a bowl; smear together using a spatula until combined. " +
                "Whisk in egg until mixture is creamy." +
                "Add almond flour, salt, vanilla extract, and almond extract. " +
                "Mix thoroughly. Cut each pluot into 6 wedges." +
                "Fill pastry shell with the almond paste. " +
                "Stick the pluots snugly, but not too deeply, into the filling." +
                "Bake in the preheated oven until browned and almond filling is set, 30 to 40 minutes." +
                "Transfer tart onto a wire rack and let cool completely, at least 40 minutes. " );
        recipe.setPrepTime( 105 );
        recipe.setCalorie( 397 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);

        



    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        roomDatabaseClass = Room.databaseBuilder(getApplicationContext(), RoomDatabaseClass.class
                , "mydb").allowMainThreadQueries().build();
        fragmentManager = getSupportFragmentManager();
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        fragmentManager.beginTransaction().replace(R.id.Container, new FridgeFragment()).commit();

        fridge = new Fridge(MainActivity.roomDatabaseClass.ingredientDao().getInFridge());
        shoppingList = new ShoppingList(MainActivity.roomDatabaseClass.ingredientDao().getInShoppingList());
        addRecipesToDatabase();
//        roomDatabaseClass.clearAllTables();
    }
}
