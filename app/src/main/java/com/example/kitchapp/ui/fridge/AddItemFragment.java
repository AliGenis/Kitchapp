package com.example.kitchapp.ui.fridge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.kitchapp.Fridge;
import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;

public class AddItemFragment extends Fragment {
    //Properties
    private EditText inputName, inputNumber;
    private final Fridge fridge = MainActivity.fridge;

    //Constructors
    public AddItemFragment() {
    }
    /**
     * onCreateView provides the connection between this class and xml
     * @parameter inflater,container,savedInstanceState
     *
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_fridge, container, false);

        inputName = view.findViewById(R.id.inputName);
        inputNumber = view.findViewById(R.id.inputNumber);

        Button btSave = view.findViewById(R.id.buttonSave);

        btSave.setOnClickListener(new View.OnClickListener() {
            /**
             * onClick is used to add item
             * @parameter v
             *
             */
            @Override
            public void onClick(View v) {
                int number = 0;

                String name = inputName.getText().toString();
                try {
                    number = Integer.parseInt(inputNumber.getText().toString());
                }catch(NumberFormatException nfe){
                    System.out.println("Invalid number");
                }

                fridge.addToFridge(name, number);

                Toast.makeText(getActivity(), "Successfully saved.", Toast.LENGTH_LONG).show();

                inputName.setText("");
                inputNumber.setText("");

                getActivity().onBackPressed();
            }
        });

        return view;
    }
}