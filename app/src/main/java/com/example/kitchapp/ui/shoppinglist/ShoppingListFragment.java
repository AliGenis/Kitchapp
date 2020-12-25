package com.example.kitchapp.ui.shoppinglist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitchapp.Ingredient;
import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;

import java.util.List;

public class ShoppingListFragment extends Fragment {

    MyShoppingListRecyclerViewAdapter recyclerAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_item_list, container, false);

        recyclerView = view.findViewById(R.id.list);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        List<Ingredient> ingredientList = MainActivity.roomDatabaseClass.ingredientDao().getIngredient();
        recyclerAdapter = new MyShoppingListRecyclerViewAdapter(ingredientList);
        recyclerView.setAdapter(recyclerAdapter);

        return view;
    }
}