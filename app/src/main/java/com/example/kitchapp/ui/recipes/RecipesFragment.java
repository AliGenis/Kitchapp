package com.example.kitchapp.ui.recipes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;
import com.example.kitchapp.Recipe;

import java.util.List;


public class RecipesFragment extends Fragment implements View.OnClickListener {

    RecyclerAdapter recyclerAdapter;
    ImageButton addRecipe;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipes, container, false);

        recyclerView = view.findViewById(R.id.recipesRecyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        List<Recipe> recipeList = MainActivity.roomDatabaseClass.recipeDao().getRecipe();
        recyclerAdapter = new RecyclerAdapter(recipeList);
        recyclerView.setAdapter(recyclerAdapter);

        addRecipe = view.findViewById(R.id.addRecipeButton);
        addRecipe.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.addRecipeButton):
                MainActivity.fragmentManager.beginTransaction().replace(R.id.Container, new AddRecipeFragment()
                        , null).addToBackStack(null).commit();
                break;
        }
    }
}


