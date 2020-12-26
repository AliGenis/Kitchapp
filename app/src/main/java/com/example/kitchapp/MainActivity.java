package com.example.kitchapp;

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
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static RoomDatabaseClass roomDatabaseClass;
    //  TODO: it is activity solution
    private final BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
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
                    fragmentManager.beginTransaction().replace(R.id.Container, selectedFragment).commit();
                    return true;
                }
            };
    public void addRecipesToDatabase(){
        //adding recipes to the database manually
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ingredients.add(new Ingredient("ingredient" + i, i*5));
        }
        Recipe recipe = new Recipe();
        recipe.setName( "Boiled Eggs" );
        recipe.setRecipe( "Boil your eggs in the tap water for about 5-10 mins" );
        recipe.setPrepTime( 10 );
        recipe.setCalorie( 100 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe);

        Recipe recipe2 = new Recipe();
        recipe2.setName( "Pan-Fried Eggs" );
        recipe2.setRecipe( "After adding some butter on the pan, fry your eggs until bottom of the egg layer " +
                "becomes crispy" );
        recipe2.setPrepTime( 10 );
        recipe2.setCalorie( 115 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe2);

        Recipe recipe3 = new Recipe();
        recipe3.setName( "Poached Egg" );
        recipe3.setRecipe( "After boiling the water in a pot, add the eggs while spinning the water inside. " +
                "Wait for 5 to 10 mins and then you are finished." );
        recipe3.setPrepTime( 10 );
        recipe3.setCalorie( 95 );
        recipe.setIngredientList(ingredients);
        roomDatabaseClass.recipeDao().addRecipe(recipe3);

        Recipe recipe4 = new Recipe();
        recipe4.setName( "Banana Bread" );
        recipe4.setRecipe( "Preheat oven to 325 degrees F (165 degrees C). Grease a 9x5-inch loaf pan. " +
                "Combine bananas, sugar, egg, and butter together in a bowl. Mix flour and baking soda together in a separate bowl; " +
                "stir into banana mixture until batter is just mixed. Stir salt into batter." +
                " Pour batter into the prepared loaf pan. " +
                "Bake in the preheated oven until a toothpick inserted in the center of the bread comes out clean, about 1 hour. "  );
        recipe4.setPrepTime( 75 );
        recipe4.setCalorie( 326 );
        roomDatabaseClass.recipeDao().addRecipe(recipe4);

        Recipe recipe5 = new Recipe();
        recipe5.setName( "Classic Rice Pilaf" );
        recipe5.setRecipe( "Preheat oven to 350 degrees F (175 degrees C). Melt butter and olive oil in a large saucepan over medium heat. " +
                "Add onion; cook and stir until onion is lightly browned, 7 to 8 minutes. " +
                "Remove from heat." +
                " Combine rice and onion mixture in a 9x13-inch casserole dish placed on a baking sheet. " +
                "Stir thoroughly to coat the rice. " +
                "Combine chicken stock, salt, saffron, and cayenne pepper in a saucepan. " +
                "Bring to a boil, reduce heat to low, and simmer for 5 minutes. " +
                "Pour chicken stock mixture over rice in the casserole dish and stir to combine. " +
                "Spread mixture evenly along the bottom of the pan. " +
                "Cover tightly with heavy-duty aluminum foil. Bake in the preheated oven for 35 minutes." +
                " Remove from oven and allow to rest, covered, for 10 minutes." +
                " Remove foil and fluff with a fork to separate the grains of rice " );
        recipe5.setPrepTime( 65 );
        recipe5.setCalorie( 130 );
        roomDatabaseClass.recipeDao().addRecipe(recipe5);

        Recipe recipe6 = new Recipe();
        recipe6.setName( "Easy Tuna Patties" );
        recipe6.setRecipe( "Beat eggs and lemon juice in a bowl; stir in Parmesan cheese and bread crumbs to make a paste." +
                " Fold in tuna and onion until well-mixed. " +
                "Season with black pepper. " +
                "Shape tuna mixture into eight 1-inch-thick patties." +
                "Heat vegetable oil in a skillet over medium heat; " +
                "fry patties until golden brown, about 5 minutes per side." );
        recipe6.setPrepTime( 25 );
        recipe6.setCalorie( 130 );
        roomDatabaseClass.recipeDao().addRecipe(recipe6);

        Recipe recipe7 = new Recipe();
        recipe7.setName( "Spaghetti and meatballs" );
        recipe7.setRecipe( "In a large pot of boiling salted water, cook spaghetti according to package instructions. Drain."+
                "In a large bowl, combine beef with bread crumbs, parsley, Parmesan, egg, garlic, 1 teaspoon salt, and red pepper flakes. Mix until just combined then form into 16 balls." +
                "In a large pot over medium heat, heat oil. Add meatballs and cook, turning occasionally, until browned on all sides, about 10 minutes. Transfer meatballs to a plate." +
                "Add onion to pot and cook until soft, 5 minutes. Add crushed tomatoes and bay leaf. Season with salt and pepper and bring to a simmer. Return meatballs to pot and cover. Simmer until sauce has thickened, 8 to 10 minutes." +
                "Serve pasta with a healthy scoop of meatballs and sauce. Top with Parmesan before serving." );
        recipe7.setPrepTime( 60 );
        recipe7.setCalorie( 97 );
        roomDatabaseClass.recipeDao().addRecipe(recipe7);

        Recipe recipe8 = new Recipe();
        recipe8.setName( "Pancake" );
        recipe8.setRecipe( "In a large bowl, sift together the flour, baking powder, salt and sugar." +
                " Make a well in the center and pour in the milk, egg and melted butter; mix until smooth." +
                "Heat a lightly oiled griddle or frying pan over medium-high heat. Pour or scoop the batter onto the griddle, using approximately 1/4 cup for each pancake." +
                " Brown on both sides and serve hot." );
        recipe8.setPrepTime( 20 );
        recipe8.setCalorie( 227 );
        roomDatabaseClass.recipeDao().addRecipe(recipe8);

        Recipe recipe9 = new Recipe();
        recipe9.setName( "Greek salad" );
        recipe9.setRecipe( "Make salad: In a large bowl, stir together tomatoes, cucumber, olives, and red onion." +
                " Gently fold in feta.In a small bowl, make dressing: Combine vinegar, lemon juice, and oregano and season with salt and pepper." +
                " Slowly add olive oil, whisking to combine.Drizzle dressing over salad." );
        recipe9.setPrepTime( 15 );
        recipe9.setCalorie( 45 );
        roomDatabaseClass.recipeDao().addRecipe(recipe9);

        Recipe recipe10 = new Recipe();
        recipe10.setName( "Easy Roasted Brocoli" );
        recipe10.setRecipe( "Preheat oven to 400 degrees F (200 degrees C)." +
                "Cut broccoli florets from the stalk." +
                " Peel the stalk and slice into 1/4-inch slices. " +
                "Mix florets and stem pieces with olive oil in a bowl and transfer to a baking sheet; season with salt and pepper. " +
                "Roast in the preheated oven until broccoli is tender and lightly browned, about 18 minutes." );
        recipe10.setPrepTime( 30 );
        recipe10.setCalorie( 33 );
        roomDatabaseClass.recipeDao().addRecipe(recipe10);

        Recipe recipe11 = new Recipe();
        recipe11.setName( "Chicken Strew" );
        recipe11.setRecipe( "In a large pot over medium heat, melt butter." +
                " Add carrots and celery and season with salt and pepper. " +
                "Cook, stirring often, until vegetables are tender, about 5 minutes." +
                " Add garlic and cook until fragrant, about 30 seconds." +
                "Add flour and stir until vegetables are coated, then add chicken, thyme, bay leaf, potatoes, and broth. " +
                "Season with salt and pepper. " +
                "Bring mixture to a simmer and cook until the chicken is no longer pink and potatoes are tender, 15 minutes." +
                "Remove from heat and transfer chicken to a medium bowl. Using two forks, shred chicken into small pieces and return to the pot. " +
                "Garnish with parsley before serving" );
        recipe11.setPrepTime( 45 );
        recipe11.setCalorie( 237 );
        roomDatabaseClass.recipeDao().addRecipe(recipe11);

        Recipe recipe12 = new Recipe();
        recipe12.setName( "Pizza Crust" );
        recipe12.setRecipe("Preheat oven to 450 degrees F (230 degrees C)." +
                " In a medium bowl, dissolve yeast and sugar in warm water." +
                " Let stand until creamy, about 10 minutes." +
                "Stir in flour, salt and oil. Beat until smooth." +
                " Let rest for 5 minutes." +
                "Turn dough out onto a lightly floured surface and pat or roll into a round.," +
                " Transfer crust to a lightly greased pizza pan or baker's peel dusted with cornmeal." +
                " Spread with desired toppings and bake in preheated oven for 15 to 20 minutes, or until golden brown. " +
                "Let baked pizza cool for 5 minutes before serving." );
        recipe12.setPrepTime( 30 );
        recipe12.setCalorie( 278 );
        roomDatabaseClass.recipeDao().addRecipe(recipe12);

        Recipe recipe13 = new Recipe();
        recipe13.setName( "Easy Meatlof" );
        recipe13.setRecipe( "Preheat oven to 350 degrees F (175 degrees C)." +
                "In a large bowl, combine the beef, egg, onion, milk and bread OR cracker crumbs." +
                " Season with salt and pepper to taste and place in a lightly greased 9x5-inch loaf pan, or form into a loaf and place in a lightly greased 9x13-inch baking dish." +
                "In a separate small bowl, combine the brown sugar, mustard and ketchup." +
                " Mix well and pour over the meatloaf. Bake at 350 degrees F (175 degrees C) for 1 hour." );
        recipe13.setPrepTime( 149 );
        recipe13.setCalorie( 70 );
        roomDatabaseClass.recipeDao().addRecipe(recipe13);

        Recipe recipe14 = new Recipe();
        recipe14.setName( "Turkish Cılbır" );
        recipe14.setRecipe( "Place the yoghurt into a fine sieve (or a sieve lined with a cloth) over a bowl for about 1 hour at room temperature to drain away some of the liquid so that the yoghurt thickens further. " +
                "Mix through the garlic and season well with salt." +
                "In a small frying pan melt the butter over medium heat and add the Aleppo pepper. " +
                "Remove the pan from the heat.Bring a tall saucepan of water to a low simmer." +
                " Crack one egg into a small bowl and stir the saucepan to create a very gentle whirlpool. Pour the egg into the centre and poach for about 3 minutes until the egg is set. " +
                "Remove with a slotted spoon and drain.Spoon the yoghurt onto two serving plates then add the eggs on top. " +
                "Season with salt, spoon over a little of the butter and scatter with dill to serve." );
        recipe14.setPrepTime( 10 );
        recipe14.setCalorie( 142 );
        roomDatabaseClass.recipeDao().addRecipe(recipe14);

        Recipe recipe15 = new Recipe();
        recipe15.setName( "Grilled Potatoes" );
        recipe15.setRecipe( "Poke each potato with the tines of a fork. " +
                "Place the potatoes in a microwave oven, and cook on high power for about 5 minutes." +
                " Check about halfway through, and turn potatoes over for even cooking." +
                " Slice each potato in half the long way and cook potatoes another 2 minutes on high power.Preheat a grill for medium heat.  " +
                "Brush the potato tops with olive oil, and season with salt and pepper to taste." +
                " Cook on prepared grill for 15 to 20 minutes, turning once." );
        recipe15.setPrepTime(27 );
        recipe15.setCalorie( 120 );
        roomDatabaseClass.recipeDao().addRecipe(recipe15);

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
//        addRecipesToDatabase();
//        roomDatabaseClass.clearAllTables();
    }
}
