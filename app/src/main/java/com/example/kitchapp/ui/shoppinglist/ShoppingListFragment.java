package com.example.kitchapp.ui.shoppinglist;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

    RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ImageButton addButton;
    private Button buyButton;
    private List<Ingredient> ingredientList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shoppinglist, container, false);

        recyclerView = view.findViewById(R.id.list);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        ingredientList = MainActivity.roomDatabaseClass.ingredientDao().getInShoppingList();
        System.out.println(ingredientList.size());
        recyclerAdapter = new RecyclerAdapter(ingredientList);
        recyclerView.setAdapter(recyclerAdapter);

        addButton = view.findViewById(R.id.shoppingListAddDataButton);
        buyButton = view.findViewById(R.id.buyButton);
        addButton.setOnClickListener(this);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:add checked items to fridge and remove them from shopping list...
                boolean[] checkedItems = recyclerAdapter.getItemStateArray();
                System.out.println(checkedItems.length);
                for (int i = 0; i < checkedItems.length; i++) {
                    if(checkedItems[i]){
                        System.out.println(checkedItems.length);
                        Ingredient ingredient = ingredientList.get(i);
                        ingredient.setNumber( ingredient.getNumber() + ingredient.getDefaultBuyValue() );
                        ingredient.setInFridge(true);
                        ingredient.setInShoppingList(false);
                        MainActivity.roomDatabaseClass.ingredientDao().updateIngredient(ingredient);
                    }
                }
                MainActivity.fragmentManager.beginTransaction().replace(R.id.Container, new ShoppingListFragment()
                        , null).addToBackStack(null).commit();
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.shoppingListAddDataButton):
                MainActivity.fragmentManager.beginTransaction().replace(R.id.Container, new AddItemFragment()
                        , null).addToBackStack(null).commit();
                break;
        }
    }
}