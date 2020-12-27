package com.example.kitchapp.ui.fridge;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitchapp.Fridge;
import com.example.kitchapp.Ingredient;
import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.FridgeViewHolder> {
    //Properties
    private final List<Ingredient> list;
    private final Fridge fridge = MainActivity.fridge;
    //Constructors
    public RecyclerAdapter(List<Ingredient> items) {
        list = items;
    }
    /**
     * onCreateViewHolder creates a new view holder when there is no view holder
     * @parameter parent,viewType
     *
     */
    @NonNull
    @Override
    public FridgeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_fridge_item, parent, false);
        return new FridgeViewHolder(view);
    }
    /**
     * onBindViewHolder recycle the old view data
     * @parameter holder,position
     *
     */
    @SuppressLint("SetTextI18n")
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
        public ImageButton btDelete, btPlus, btMinus;

        public FridgeViewHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.fridgeItemName);

            tvNumber = (TextView) view.findViewById(R.id.fridgeItemNumber);
            btDelete = view.findViewById(R.id.fridgeDeleteButton);
            btPlus = view.findViewById(R.id.plusButton);
            btMinus = view.findViewById(R.id.minusButton);

            btDelete.setOnClickListener(this);
            btPlus.setOnClickListener(this);
            btMinus.setOnClickListener(this);
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

            String name = list.get(getAdapterPosition()).getName();
            Ingredient ingredient = fridge.findByName(name);

            switch (v.getId()) {

                case (R.id.fridgeDeleteButton):
                    MainActivity.roomDatabaseClass.ingredientDao().deleteIngredient(ingredient);
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.Container,
                            new FridgeFragment(), null).commit();
                    break;

                case (R.id.plusButton):
                    ingredient.setNumber(ingredient.getNumber() + 1);
                    MainActivity.roomDatabaseClass.ingredientDao().updateIngredient(ingredient);
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.Container,
                            new FridgeFragment(), null).commit();
                    break;

                case (R.id.minusButton):
                    ingredient.setNumber(ingredient.getNumber() - 1);
                    MainActivity.roomDatabaseClass.ingredientDao().updateIngredient(ingredient);
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.Container,
                            new FridgeFragment(), null).commit();
                    break;
            }
        }
    }
}