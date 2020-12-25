package com.example.kitchapp.ui.recipes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kitchapp.Ingredient;
import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;
import com.example.kitchapp.Recipe;


public class AddRecipeFragment extends Fragment {

    private EditText inputName, inputRecipe, inputCalorie, inputPrepTime;
    private Button btSave;

    public AddRecipeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_recipe, container, false);

        inputName = view.findViewById(R.id.inputName);
        inputRecipe = view.findViewById(R.id.inputRecipe);
        inputCalorie = view.findViewById(R.id.inputCalorie);
        inputPrepTime = view.findViewById(R.id.inputPrepTime);
        btSave = view.findViewById(R.id.buttonSave);

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputName.getText().toString();

                Recipe recipe = new Recipe();
                recipe.setName(name);
                recipe.setRecipe(inputRecipe.getText().toString());
                recipe.setCalorie(Integer.parseInt(inputCalorie.getText().toString()));
                recipe.setPrepTime(Integer.parseInt(inputPrepTime.getText().toString()));

                MainActivity.roomDatabaseClass.recipeDao().addRecipe(recipe);
                Toast.makeText(getActivity(), "Succesfully saved.", Toast.LENGTH_LONG).show();
                inputName.setText("");
                inputRecipe.setText("");
                inputCalorie.setText("");
                inputPrepTime.setText("");
                getActivity().onBackPressed();
            }
        });

        return view;
    }
}