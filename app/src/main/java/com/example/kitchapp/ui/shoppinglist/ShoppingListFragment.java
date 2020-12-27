package com.example.kitchapp.ui.shoppinglist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitchapp.Ingredient;
import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;
import com.example.kitchapp.ShoppingList;

import java.util.List;

public class ShoppingListFragment extends Fragment implements View.OnClickListener{

    RecyclerAdapter recyclerAdapter;
    private List<Ingredient> list;
    private final ShoppingList shoppingList = MainActivity.shoppingList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shoppinglist, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        list = shoppingList.getInShoppingList();
        System.out.println(list.size());

        recyclerAdapter = new RecyclerAdapter(list);
        recyclerView.setAdapter(recyclerAdapter);

        ImageButton addButton = view.findViewById(R.id.shoppingListAddDataButton);
        Button buyButton = view.findViewById(R.id.buyButton);

        addButton.setOnClickListener(this);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean[] checkedItems = recyclerAdapter.getItemStateArray();

                System.out.println(checkedItems.length); //test case

                shoppingList.buy(checkedItems, list);

                Toast.makeText(getActivity(), "Money brings you food, but not appetite " +
                        "(Henrik Ibsen). But Kitchapp brings you appetite.", Toast.LENGTH_LONG).show();

                MainActivity.fragmentManager.beginTransaction().replace(R.id.Container, new ShoppingListFragment()
                        , null).addToBackStack(null).commit();

            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.shoppingListAddDataButton) {
            MainActivity.fragmentManager.beginTransaction().replace(R.id.Container, new AddItemFragment()
                    , null).addToBackStack(null).commit();
        }
    }
}