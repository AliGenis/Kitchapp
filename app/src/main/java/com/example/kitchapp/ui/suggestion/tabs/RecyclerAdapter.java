package com.example.kitchapp.ui.suggestion.tabs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.kitchapp.Ingredient;
import com.example.kitchapp.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final List<Ingredient> list;

    public RecyclerAdapter(List<Ingredient> items) {
        list = items;
    }


    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_suggestion_tab_ingredients_item, parent, false);
        return new RecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerAdapter.ViewHolder holder, int position) {
        holder.ingredient = list.get(position);
        holder.name.setText(list.get(position).getName());
        holder.number.setText(Integer.toString(list.get(position).getNumber()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public Ingredient ingredient;
        public TextView number;
        public TextView name;

        public ViewHolder(View view) {
            super(view);

            mView = view;
            name = view.findViewById(R.id.ingredients_tab_name);
            number = view.findViewById(R.id.ingredients_tab_number);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + number.getText() + "'";
        }
    }
}
