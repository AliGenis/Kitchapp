package com.example.kitchapp.ui.shoppinglist;

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


public class AddShoppingFragment extends Fragment {

    private EditText inputName, inputNumber;
    private Button btSave;

    public AddShoppingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_shopping, container, false);

        inputName = view.findViewById(R.id.inputName);
        inputNumber = view.findViewById(R.id.inputNumber);
        btSave = view.findViewById(R.id.buttonSave);

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = 0;
                String name = inputName.getText().toString();
                try {
                    number = Integer.parseInt(inputNumber.getText().toString());
                }catch(NumberFormatException nfe){
                    System.out.println("Invalid number");
                }
                Ingredient ingredient = new Ingredient();
                ingredient.setName(name);
                ingredient.setDefaultBuyValue(number);
                ingredient.setNumber(0);
                if(number > 0) {
                    MainActivity.roomDatabaseClass.ingredientDao().addIngredient(ingredient);
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