package com.example.kitchapp.ui.recipes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitchapp.R;
import com.example.kitchapp.Recipe;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecipesViewHolder> {

    private final List<Recipe> list;

    public RecyclerAdapter(List<Recipe> items) {
        list = items;
    }

    @NonNull
    @Override
    public RecyclerAdapter.RecipesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_recipes_item, parent, false);
        com.example.kitchapp.ui.recipes.RecyclerAdapter.RecipesViewHolder recipesViewHolder = new RecyclerAdapter.RecipesViewHolder(view);
        return recipesViewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerAdapter.RecipesViewHolder holder, int position) {
        holder.recipe = list.get(position);
        holder.tvName.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecipesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView tvName;
        public Recipe recipe;

        public RecipesViewHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.recipeName);
        }

        public TextView getTvName() {
            return tvName;
        }

        public Recipe getRecipe() {
            return recipe;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvName.getText() + "'";
        }

        @Override
        public void onClick(View v) {
            //If button added, implement this...
        }
    }
}