package com.example.kitchapp.ui.fridge;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitchapp.Ingredient;
import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.FridgeViewHolder> {

    private final List<Ingredient> list;

    public RecyclerAdapter(List<Ingredient> items) {
        list = items;
    }

    @NonNull
    @Override
    public FridgeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_fridge_item, parent, false);
        FridgeViewHolder fridgeViewHolder = new FridgeViewHolder(view);
        return fridgeViewHolder;
    }

    @Override
    public void onBindViewHolder(final FridgeViewHolder holder, int position) {
        holder.ingredient = list.get(position);
        holder.tvName.setText(list.get(position).getName());
        holder.tvNumber.setText(Integer.toString(list.get(position).getNumber()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FridgeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView tvName;
        public final TextView tvNumber;
        public Ingredient ingredient;
        public ImageButton btDelete, plusButton, minusButton;

        public FridgeViewHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.fridgeItemName);
            tvNumber = (TextView) view.findViewById(R.id.fridgeItemNumber);
            btDelete = view.findViewById(R.id.fridgeDeleteButton);
            plusButton = view.findViewById(R.id.plusButton);
            minusButton = view.findViewById(R.id.minusButton);
            btDelete.setOnClickListener(this);
            plusButton.setOnClickListener(this);
            minusButton.setOnClickListener(this);
        }

        public TextView getTvName() {
            return tvName;
        }

        public TextView getTvNumber() {
            return tvNumber;
        }

        public Ingredient getIngredient() {
            return ingredient;
        }

        @Override
        public String toString() {
            return super.toString() + "'" + tvName.getText() + "'"
                    + " '" + tvNumber.getText() + "'";
        }

        @Override
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
                case (R.id.fridgeDeleteButton):
                    MainActivity.roomDatabaseClass.ingredientDao().deleteIngredient(ingredient);
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.Container,
                            new FridgeFragment(), null).commit();
                    break;
                case (R.id.plusButton):
                    number++;
                    ingredient.setNumber(number);
                    MainActivity.roomDatabaseClass.ingredientDao().updateIngredient(ingredient);
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.Container,
                            new FridgeFragment(), null).commit();
                    break;
                case (R.id.minusButton):
                    number--;
                    ingredient.setNumber(number);
                    MainActivity.roomDatabaseClass.ingredientDao().updateIngredient(ingredient);
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.Container,
                            new FridgeFragment(), null).commit();
                    break;

            }
        }
    }
}