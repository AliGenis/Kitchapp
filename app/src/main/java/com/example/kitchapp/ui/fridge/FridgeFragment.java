package com.example.kitchapp.ui.fridge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitchapp.Fridge;
import com.example.kitchapp.Ingredient;
import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;

import java.util.List;

public class FridgeFragment extends Fragment implements View.OnClickListener {

    RecyclerAdapter recyclerAdapter;
    Button btAddData;
    List<Ingredient> list;
    private final Fridge fridge = MainActivity.fridge;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fridge, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.fridgeRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        list = fridge.getInFridge();
        System.out.println(list.size()); //test case

        recyclerAdapter = new RecyclerAdapter(list);
        recyclerView.setAdapter(recyclerAdapter);

        btAddData = view.findViewById(R.id.addToFridgeButton);
        btAddData.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addToFridgeButton) {
            MainActivity.fragmentManager.beginTransaction().replace(R.id.Container, new AddItemFragment()
                    , null).addToBackStack(null).commit();
        }
    }
}