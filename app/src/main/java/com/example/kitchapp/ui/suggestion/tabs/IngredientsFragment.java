package com.example.kitchapp.ui.suggestion.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitchapp.Ingredient;
import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;
import com.example.kitchapp.Recipe;
import com.example.kitchapp.ui.recipes.OneRecipeFragment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IngredientsFragment extends Fragment {
    RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    Recipe recipe;
    int recipeID;
    private List<Ingredient> ingredientList;

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
        recyclerView = root.findViewById(R.id.recipe_list_of_ingredients);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        ingredientList = new ArrayList<>();

        ingredientList.addAll(recipe.getIngredientList());

        System.out.println(ingredientList.size());
        recyclerAdapter = new RecyclerAdapter(ingredientList);
        recyclerView.setAdapter(recyclerAdapter);

        return root;
    }
}