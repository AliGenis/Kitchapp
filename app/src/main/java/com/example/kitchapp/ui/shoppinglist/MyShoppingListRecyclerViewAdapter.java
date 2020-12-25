package com.example.kitchapp.ui.shoppinglist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.recyclerview.widget.RecyclerView;

import com.example.kitchapp.Ingredient;
import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;

import java.util.List;

public class MyShoppingListRecyclerViewAdapter extends RecyclerView.Adapter<MyShoppingListRecyclerViewAdapter.ViewHolder> {

    private final List<Ingredient> list;

    public MyShoppingListRecyclerViewAdapter(List<Ingredient> items) {
        list = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_shopping_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.ingredient = list.get(position);
        holder.checkBox.setText(list.get(position).getName());
        holder.number.setText(list.get(position).getDefaultBuyValue());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final View mView;
        public Ingredient ingredient;
        public ImageButton plusButton, minusButton;
        public EditText number;
        public CheckBox checkBox;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            plusButton = view.findViewById(R.id.plus_in_shopping);
            minusButton = view.findViewById(R.id.minus_in_shopping);
            number = view.findViewById(R.id.number_in_shopping);
            checkBox = view.findViewById(R.id.shop_checkbox);

            plusButton.setOnClickListener(this);
            minusButton.setOnClickListener(this);
            number.setOnClickListener(this);
            checkBox.setOnClickListener(this);

        }

        public void onClick(View v) {
            Ingredient ingredient;
            int ID, number;
            String name;
            ingredient = new Ingredient();
            ID = list.get(getAdapterPosition()).getId();
            name = list.get(getAdapterPosition()).getName();
            number = list.get(getAdapterPosition()).getNumber();
            ingredient.setId(ID);
            ingredient.setName(name);
            ingredient.setNumber(number);

            switch (v.getId()) {

                case (R.id.plus_in_shopping):
                    number++;
                    ingredient.setNumber(number);
                    MainActivity.roomDatabaseClass.ingredientDao().updateIngredient(ingredient);
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.Container,
                            new ShoppingListFragment(), null).commit();
                    break;

                case (R.id.minus_in_shopping):
                    number--;
                    ingredient.setNumber(number);
                    MainActivity.roomDatabaseClass.ingredientDao().updateIngredient(ingredient);
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.Container,
                            new ShoppingListFragment(), null).commit();
                    break;

            }


        }

        @Override
        public String toString() {
            return super.toString() + " '" + checkBox.getText() + "'";
        }
    }
}