package com.example.kitchapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.internal.NavigationMenu;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.content.Intent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Ingredient> Arr = new ArrayList<Ingredient>();
        System.out.println("KITCHAPP!");
        //Ingredient deneme = new Ingredient( 200,4,true,"Hıyar");
        Ingredient deneme1 = new Ingredient(20, 4, true, "Limon");
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

        //setContentView(R.layout.fragment_suggestion_screen);
     //   setContentView(R.layout.fragment_recipes_list);
        //setContentView(R.layout.activity_main);
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


        //TODO: it is fragment solution
        //BottomNavigationView navView = findViewById(R.id.bottomNavigationView);
        //AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.fridgeFragment,
               // R.id.shoppingListScreenFragment, R.id.suggestionScreen, R.id.recipesFragment, R.id.settingsFragment).build();
        //NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
        //NavController navController = getNavController(); //solution in the video
        //NavigationUI.setupWithNavController(navView,navController);


        //setContentView(R.layout.fragment_suggestion_screen);

        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference();
        //myRef.child("Ingredients").child("Armut").setValue( new Ingredient( "Armut", 20));
        //myRef.child("Ingredients").child("Hıyar").setValue( new Ingredient( "Hıyar", 2));



    /*
    @NonNull
    private  NavController getNavController() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fridgeFragment);
        if (!(fragment instanceof NavHostFragment)) {
            throw new IllegalStateException("Activity " + this
                    + " does not have a NavHostFragment");
        }
        return ((NavHostFragment) fragment).getNavController();

    }

    public void openDataInsert(){
        Intent intent = new Intent(this,DataInsert.class);
        startActivity(intent);
    }*/
}
