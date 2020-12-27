package com.example.kitchapp.ui.recipes;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kitchapp.Ingredient;
import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;
import com.example.kitchapp.Recipe;

import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OneRecipeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OneRecipeFragment extends Fragment {

    private ImageView imageOfRecipe;
    private TextView recipeTitle;
    private TextView recipeWindow;
    private TextView timeText;
    private TextView calText;
    private int recipeID;
    private Recipe recipe;

    public OneRecipeFragment() {
        // Required empty public constructor
    }

    public static OneRecipeFragment newInstance(int id) {
        OneRecipeFragment fragment = new OneRecipeFragment();
        Bundle args = new Bundle();
        args.putInt("idOfRecipe", id);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("UseRequireInsteadOfGet")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one_recipe, container, false);

       recipeID = getArguments().getInt("idOfRecipe",0);
      //  recipeID = Objects.requireNonNull(getArguments()).getInt("idOfRecipe",0);
        List<Recipe> recipes = MainActivity.roomDatabaseClass.recipeDao().getRecipe();
        for(int i = 0; i < recipes.size();i++) {
            if(recipeID == recipes.get(i).getRecipeID() )
                recipe = recipes.get(i);
        }

        recipeTitle = view.findViewById(R.id.recipeTitle);
        recipeWindow = view.findViewById(R.id.recipeText);
        calText = view.findViewById(R.id.calText);
        imageOfRecipe = view.findViewById(R.id.imageOfRecipe);
        timeText = view.findViewById(R.id.timeText);

        recipeTitle.setText(recipe.getName());
        recipeWindow.setText(recipe.getRecipe());
        calText.setText(Double.toString(recipe.getCalorie()));
        timeText.setText(Integer.toString(recipe.getPrepTime()));

        return view;
    }
}