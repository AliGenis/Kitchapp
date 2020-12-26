package com.example.kitchapp.ui.suggestion.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;
import com.example.kitchapp.Recipe;
import com.example.kitchapp.ui.recipes.OneRecipeFragment;

import java.util.List;

public class IngredientsFragment extends Fragment {
    Recipe recipe;
    int recipeID;

    public IngredientsFragment(){}

    public static IngredientsFragment newInstance(int id) {
        IngredientsFragment fragment = new IngredientsFragment();
        Bundle args = new Bundle();
        args.putInt("idOfRecipe", id);
        fragment.setArguments(args);

        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_suggestion_tab_ingredients, container, false);
        recipeID = getArguments().getInt("idOfRecipe",0);
        List<Recipe> recipes = MainActivity.roomDatabaseClass.recipeDao().getRecipe();
        for(int i = 0; i < recipes.size();i++) {
            if(recipeID == recipes.get(i).getRecipeID() )
                recipe = recipes.get(i);
        }

        return root;
    }
}