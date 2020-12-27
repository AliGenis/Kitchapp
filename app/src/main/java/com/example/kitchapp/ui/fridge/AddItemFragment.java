package com.example.kitchapp.ui.fridge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.kitchapp.Ingredient;
import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;

import java.util.List;

public class AddItemFragment extends Fragment {

    private EditText inputName, inputNumber;

    public AddItemFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_fridge, container, false);

        inputName = view.findViewById(R.id.inputName);
        inputNumber = view.findViewById(R.id.inputNumber);
        Button btSave = view.findViewById(R.id.buttonSave);

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = 0;
                List<Ingredient> sameName;
                String name = inputName.getText().toString();
                try {
                    number = Integer.parseInt(inputNumber.getText().toString());
                }catch(NumberFormatException nfe){
                    System.out.println("Invalid number");
                }

                sameName = MainActivity.roomDatabaseClass.ingredientDao().getByName(name);

                if( sameName.isEmpty() )
                {
                    Ingredient ingredient = new Ingredient();
                    ingredient.setName(name);
                    ingredient.setNumber(number);
                    ingredient.setInShoppingList(false);
                    ingredient.setInFridge(true);
                    if(number > 0) {
                        MainActivity.roomDatabaseClass.ingredientDao().addIngredient(ingredient);
                    }
                } else {
                    Ingredient ingredient = sameName.get(0);
                    ingredient.setNumber(number);
                    ingredient.setInFridge(true);
                    if(number > 0) {
                        MainActivity.roomDatabaseClass.ingredientDao().updateIngredient(ingredient);
                    }
                }
                Toast.makeText(getActivity(), "Succesfully saved.", Toast.LENGTH_LONG).show();
                inputName.setText("");
                inputNumber.setText("");
                getActivity().onBackPressed();
            }
        });

        return view;
    }
}