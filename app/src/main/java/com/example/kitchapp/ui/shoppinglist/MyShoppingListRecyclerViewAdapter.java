package com.example.kitchapp.ui.shoppinglist;

import android.text.Editable;
import android.text.TextWatcher;
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
                .inflate(R.layout.fragment_shoppinglist_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.ingredient = list.get(position);
        holder.checkBox.setText(list.get(position).getName());
        holder.number.setText(Integer.toString(list.get(position).getDefaultBuyValue()));
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
            //number.setOnClickListener(this);
            number.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    //int newValue;// = Integer.parseInt(number.getText().toString().trim());
                    Ingredient ingredient;
                    int ID, amount;
                    String name;
                    ingredient = new Ingredient();
                    ID = list.get(getAdapterPosition()).getId();
                    name = list.get(getAdapterPosition()).getName();
                    amount = list.get(getAdapterPosition()).getNumber();

                    ingredient.setId(ID);
                    ingredient.setName(name);
                    ingredient.setNumber(amount);
                    try {
                        if (number.getText().toString() != "")
                            ingredient.setDefaultBuyValue(Integer.parseInt(number.getText().toString()));
                        else
                            ingredient.setDefaultBuyValue(0);
                    }catch (NumberFormatException numberFormatException){
                        System.out.println("Invalid İnput!");
                    }

                    MainActivity.roomDatabaseClass.ingredientDao().updateIngredient(ingredient);
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            checkBox.setOnClickListener(this);

        }

        public void onClick(View v) {
            Ingredient ingredient;
            int ID, number, defBuyValue;
            String name;
            ingredient = new Ingredient();
            ID = list.get(getAdapterPosition()).getId();
            name = list.get(getAdapterPosition()).getName();
            number = list.get(getAdapterPosition()).getNumber();
            defBuyValue = list.get(getAdapterPosition()).getDefaultBuyValue();
            ingredient.setId(ID);
            ingredient.setName(name);
            ingredient.setNumber(number);
            ingredient.setDefaultBuyValue(defBuyValue);

            switch (v.getId()) {

                case (R.id.plus_in_shopping):
                    defBuyValue++;
                    ingredient.setDefaultBuyValue(defBuyValue);
                    MainActivity.roomDatabaseClass.ingredientDao().updateIngredient(ingredient);
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.Container,
                            new ShoppingListFragment(), null).commit();
                    break;

                case (R.id.minus_in_shopping):
                    defBuyValue--;
                    ingredient.setDefaultBuyValue(defBuyValue);
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