package com.example.kitchapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import com.example.kitchapp.ui.fridge.FridgeFragment;
import com.example.kitchapp.ui.recipes.RecipesFragment;
import com.example.kitchapp.ui.settings.SettingsFragment;
import com.example.kitchapp.ui.shoppinglist.ShoppingListScreenFragment;
import com.example.kitchapp.ui.suggestion.tabs.SuggestionScreen;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static RoomDatabaseClass roomDatabaseClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roomDatabaseClass = Room.databaseBuilder(getApplicationContext(), RoomDatabaseClass.class
                , "mydb").allowMainThreadQueries().build();

       ArrayList<Ingredient> Arr = new ArrayList<Ingredient>();
        System.out.println("KITCHAPP!");
        //Ingredient deneme = new Ingredient( 200,4,true,"Hıyar");
        Ingredient deneme1 = new Ingredient(20, 4, "Limon");
        Arr.add(new Ingredient("Egg", 1));
        Arr.add(new Ingredient("butter", 1));
        Arr.add(new Ingredient("Hıyar", 2));
        Recipe rec = new Recipe("Boiled Egg", "Boil the eggs for about 5 to 20 mins according to your preference", Arr, 15, 15, false);
        //deneme1.setName("Limoon");
        deneme1.setNumber(10);

        Fridge fridge = new Fridge(Arr);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FridgeFragment()).commit();
    }


       //  TODO: it is activity solution
     private  BottomNavigationView.OnNavigationItemSelectedListener navListener =
        new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.fridgeFragment:
                        selectedFragment = new FridgeFragment();
                        break;

                    case R.id.shoppingListScreenFragment:
                       // Intent intent1 = new Intent(MainActivity.this, ShoppingListScreenFragment.class);
                     //   startActivity(intent1);
                        selectedFragment = new ShoppingListScreenFragment();
                        break;

                    case R.id.suggestionScreen:
                   //     Intent intent2 = new Intent(MainActivity.this, SuggestionScreen.class);
                      //  startActivity(intent2);
                        selectedFragment = new SuggestionScreen();
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
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
           return true;
            }
        };


}
