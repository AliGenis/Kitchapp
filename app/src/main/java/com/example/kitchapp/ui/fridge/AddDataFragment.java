package com.example.kitchapp.ui.fridge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.kitchapp.FridgeItem;
import com.example.kitchapp.Ingredient;
import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;

public class AddDataFragment extends Fragment {

    private EditText inputName, inputNumber;
    private Button btSave;

    public AddDataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_data, container, false);

        inputName = view.findViewById(R.id.inputName);
        inputNumber = view.findViewById(R.id.inputNumber);
        btSave = view.findViewById(R.id.buttonSave);

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputName.getText().toString();
                int number =  Integer.parseInt( inputNumber.getText().toString() );

                FridgeItem fridgeItem = new FridgeItem();
                fridgeItem.setName(name);
                fridgeItem.setNumber(number);

                MainActivity.roomDatabaseClass.fridgeItemDao().addFridgeItem(fridgeItem);
                Toast.makeText(getActivity(), "Succesfully saved.", Toast.LENGTH_LONG).show();
                inputName.setText("");
                inputNumber.setText("");
            }
        });

        return view;
    }
}