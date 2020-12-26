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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        roomDatabaseClass = Room.databaseBuilder(getApplicationContext(), RoomDatabaseClass.class
                , "mydb").allowMainThreadQueries().build();
        fragmentManager = getSupportFragmentManager();

        addRecipesToDatabase();

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        fragmentManager.beginTransaction().replace(R.id.Container, new FridgeFragment()).commit();
    }

    public void addRecipesToDatabase(){
        //adding recipes to the database manually
        Recipe recipe = new Recipe();
        recipe.setName( "Boiled Eggs" );
        recipe.setRecipe( "Boil your eggs in the tap water for about 5-10 mins" );
        recipe.setPrepTime( 10 );
        recipe.setCalorie( 100 );
        roomDatabaseClass.recipeDao().addRecipe(recipe);

        Recipe recipe2 = new Recipe();
        recipe2.setName( "Pan-Fried Eggs" );
        recipe2.setRecipe( "After adding some butter on the pan, fry your eggs until bottom of the egg layer " +
                "becomes crispy" );
        recipe2.setPrepTime( 10 );
        recipe2.setCalorie( 115 );
        roomDatabaseClass.recipeDao().addRecipe(recipe2);

        Recipe recipe3 = new Recipe();
        recipe3.setName( "Poached Egg" );
        recipe3.setRecipe( "After boiling the water in a pot, add the eggs while spinning the water inside. " +
                "Wait for 5 to 10 mins and then you are finished." );
        recipe3.setPrepTime( 10 );
        recipe3.setCalorie( 95 );
        roomDatabaseClass.recipeDao().addRecipe(recipe3);
    }
}
