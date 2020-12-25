package com.example.kitchapp.ui.shoppinglist;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kitchapp.Ingredient;
import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;

import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class ShoppingListFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    MyShoppingListRecyclerViewAdapter recyclerAdapter;
    Button btAddData;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fridge, container, false);

        recyclerView = view.findViewById(R.id.list);
        layoutManager = new LinearLayoutManager(getActivity());//
        //recyclerView.setLayoutManager(layoutManager);
        List<Ingredient> ingredientList = MainActivity.roomDatabaseClass.shoppingIngredientDao().getIngredient();
        recyclerAdapter = new MyShoppingListRecyclerViewAdapter(ingredientList);
        //recyclerView.setAdapter(recyclerAdapter);

        //btAddData = view.findViewById(R.id.addToFridgeButton);
        //btAddData.setOnClickListener(this);

        return view;
    }
    /*
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case (R.id.addToFridgeButton):
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AddDataFragment()
                        , null).addToBackStack(null).commit();
                break;
        }
    }*/
}