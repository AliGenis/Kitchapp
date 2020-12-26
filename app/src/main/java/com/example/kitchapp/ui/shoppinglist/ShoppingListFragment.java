package com.example.kitchapp.ui.shoppinglist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitchapp.Ingredient;
import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;

import java.util.List;

public class ShoppingListFragment extends Fragment implements View.OnClickListener{

    MyShoppingListRecyclerViewAdapter recyclerAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ImageButton addButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shoppinglist, container, false);

        recyclerView = view.findViewById(R.id.list);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        List<Ingredient> ingredientList = MainActivity.roomDatabaseClass.ingredientDao().getInShoppingList();
        recyclerAdapter = new MyShoppingListRecyclerViewAdapter(ingredientList);
        recyclerView.setAdapter(recyclerAdapter);

        addButton = view.findViewById(R.id.shop_add_button);
        addButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.shop_add_button):
                MainActivity.fragmentManager.beginTransaction().replace(R.id.Container, new AddShoppingFragment()
                        , null).addToBackStack(null).commit();
                break;
        }
    }
}