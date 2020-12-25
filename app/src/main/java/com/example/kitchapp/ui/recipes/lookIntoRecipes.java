package com.example.kitchapp.ui.recipes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.kitchapp.Ingredient;
import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;

public class lookIntoRecipes extends Fragment {

    private TextView recipeName,recipeItself;
    private ImageView photo;
    private Button eat;

    public lookIntoRecipes() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipes, container, false);

        recipeName = view.findViewById(R.id.textView19);
        recipeItself = view.findViewById(R.id.textView20);
        photo = view.findViewById(R.id.imageView2);
        eat = view.findViewById(R.id.button2);

        /**eat.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                String name = inputName.getText().toString();
                int number =  Integer.parseInt( inputNumber.getText().toString() );

                Ingredient ingredient = new Ingredient();
                ingredient.setName(name);
                ingredient.setNumber(number);

                MainActivity.roomDatabaseClass.ingredientDao().addIngredient(ingredient);
                Toast.makeText(getActivity(), "Succesfully saved.", Toast.LENGTH_LONG).show();
                inputName.setText("");
                inputNumber.setText("");
            }
        });
**/
        return view;

        }
}
