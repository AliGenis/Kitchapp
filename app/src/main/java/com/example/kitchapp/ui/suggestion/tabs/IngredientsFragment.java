package com.example.kitchapp.ui.suggestion.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitchapp.Ingredient;
import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;
import com.example.kitchapp.Recipe;

import java.util.ArrayList;
import java.util.List;

public class IngredientsFragment extends Fragment {
    RecyclerAdapter recyclerAdapter;
    Recipe recipe;
    int recipeID;

    public IngredientsFragment() {
    }

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
        if (getArguments() != null) {
            recipeID = getArguments().getInt("idOfRecipe", 0);
            ArrayList<Integer> id = new ArrayList<Integer>();
            id.add(recipeID);
            List<Recipe> recipes = MainActivity.roomDatabaseClass.recipeDao().getRecipeByID(id);
            recipe = recipes.get(0);
        /*
        for(int i = 0; i < recipes.size();i++) {
            if(recipeID == recipes.get(i).getRecipeID() )
                recipe = recipes.get(i);
        }

         */
            RecyclerView recyclerView = root.findViewById(R.id.recipe_list_of_ingredients);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);

            List<Ingredient> ingredientList = new ArrayList<>(recipe.getIngredientList());

            System.out.println(ingredientList.size());
            recyclerAdapter = new RecyclerAdapter(ingredientList);
            recyclerView.setAdapter(recyclerAdapter);
        }

        return root;
    }
}