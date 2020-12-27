package com.example.kitchapp.ui.shoppinglist;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitchapp.Ingredient;
import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;
import com.example.kitchapp.ShoppingList;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final List<Ingredient> list;
    private final ShoppingList shoppingList = MainActivity.shoppingList;
    boolean[] itemStateArray;

    public RecyclerAdapter(List<Ingredient> items) {
        list = items;
        itemStateArray = new boolean[items.size()];
    }

    public boolean[] getItemStateArray() {
        return itemStateArray;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_shoppinglist_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.ingredient = list.get(position);
        holder.checkBox.setText(list.get(position).getName());
        holder.number.setText(Integer.toString(list.get(position).getBuyValue()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final View mView;
        public Ingredient ingredient;
        public ImageButton plusButton, minusButton, deleteButton;
        public EditText number;
        public CheckBox checkBox;

        public ViewHolder(View view) {

            super(view);

            mView = view;
            plusButton = view.findViewById(R.id.plus_in_shopping);
            minusButton = view.findViewById(R.id.minus_in_shopping);
            deleteButton = view.findViewById(R.id.deleteButton);
            deleteButton.setOnClickListener(this);
            number = view.findViewById(R.id.number_in_shopping);
            checkBox = view.findViewById(R.id.shop_checkbox);

            plusButton.setOnClickListener(this);
            minusButton.setOnClickListener(this);
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemStateArray[getAdapterPosition()] = checkBox.isChecked();
                    if(!checkBox.isChecked())
                        checkBox.setPaintFlags(checkBox.getPaintFlags() ^ Paint.STRIKE_THRU_TEXT_FLAG);
                    else
                        checkBox.setPaintFlags(checkBox.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
            });

            number.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    //int newValue;// = Integer.parseInt(number.getText().toString().trim());
                    String name = list.get(getAdapterPosition()).getName();
                    int buyValue = 0;

                    try {
                        if (!number.getText().toString().equals(""))
                            buyValue = Integer.parseInt( number.getText().toString() );
                        else
                            buyValue = 0;
                    }catch (NumberFormatException numberFormatException){
                        System.out.println("Invalid Input!");
                    }
                    shoppingList.setBuyValue(name, buyValue);
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
        }

        public void onClick(View v) {
            String name = list.get(getAdapterPosition()).getName();
            Ingredient ingredient = shoppingList.findByName(name);

            switch (v.getId()) {

                case (R.id.deleteButton):
                    shoppingList.removeFromShoppingList(name);
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.Container,
                            new ShoppingListFragment(), null).commit();
                    break;

                case (R.id.plus_in_shopping):
                    shoppingList.setBuyValue(name, ingredient.getBuyValue() + 1 );
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.Container,
                            new ShoppingListFragment(), null).commit();
                    break;

                case (R.id.minus_in_shopping):
                    shoppingList.setBuyValue(name, ingredient.getBuyValue() - 1 );
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