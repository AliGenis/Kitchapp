package com.example.kitchapp.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;
import com.example.kitchapp.Recipe;

import java.util.List;

public class SettingsFragment extends Fragment {

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        List<Recipe> recipes = MainActivity.roomDatabaseClass.recipeDao().getRecipe();
//        Test Case
//        System.out.println(recipes.get(2).getIngredientList().size());
//        for (int i = 0; i < recipes.get(2).getIngredientList().size(); i++) {
//            System.out.println(recipes.get(2).getIngredientList().get(i).getName());
//        }
        return view;
    }
}