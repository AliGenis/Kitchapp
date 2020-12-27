package com.example.kitchapp.ui.suggestion.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;
import com.example.kitchapp.Recipe;

import java.util.List;

public class RecipeFragment extends Fragment {
    Recipe recipe;
    int recipeID;
    TextView recipeInfo;

    public RecipeFragment(){}

    public static RecipeFragment newInstance(int id) {
        RecipeFragment fragment = new RecipeFragment();
        Bundle args = new Bundle();
        args.putInt("idOfRecipe", id);
        fragment.setArguments(args);

        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_suggestion_tab_recipe, container, false);

        assert getArguments() != null;
        recipeID = getArguments().getInt("idOfRecipe",0);
        List<Recipe> recipes = MainActivity.roomDatabaseClass.recipeDao().getRecipe();
        for(int i = 0; i < recipes.size();i++) {
            if(recipeID == recipes.get(i).getRecipeID() )
                recipe = recipes.get(i);
        }
        if(recipe != null) {
            recipeInfo = root.findViewById(R.id.recipeTabInfoText);
            recipeInfo.setText(recipe.getRecipe());
        }
        return root;
    }
}