package com.example.kitchapp.ui.recipes;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;
import com.example.kitchapp.Recipe;
import com.example.kitchapp.ui.suggestion.tabs.RecipeFragment;

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
        return new RecipesViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final RecyclerAdapter.RecipesViewHolder holder, int position) {
        holder.recipe = list.get(position);
        holder.tvName.setText(list.get(position).getName());
        holder.tvTime.setText(Integer.toString(list.get(position).getPrepTime()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecipesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView tvName;
        public Recipe recipe;
        public ImageButton deleteButton;
        public Button detailsButton;
        public TextView tvTime;


        public RecipesViewHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.recipeName);
            tvTime = (TextView) view.findViewById(R.id.recipes_time);
            detailsButton = (Button) view.findViewById(R.id.recipe_details_button);
            detailsButton.setOnClickListener(this);
            deleteButton = view.findViewById(R.id.deleteButton);
            deleteButton.setOnClickListener(this);

        }
        public void onClick(View v) {
            Recipe recipe;
            int ID, time;
            String name;
            recipe = new Recipe();
            ID = list.get(getAdapterPosition()).getRecipeID();
            name = list.get(getAdapterPosition()).getName();
            time = list.get(getAdapterPosition()).getPrepTime();
            recipe.setRecipeID(ID);
            recipe.setName(name);
            recipe.setPrepTime(time);

            switch (v.getId()) {
                case (R.id.recipe_details_button):
                    MainActivity.roomDatabaseClass.recipeDao().getRecipe();

                    MainActivity.fragmentManager.beginTransaction().replace(R.id.Container,
                            OneRecipeFragment.newInstance(ID), null).commit();
                    break;
                case (R.id.deleteButton):
                    MainActivity.roomDatabaseClass.recipeDao().deleteRecipe(recipe);
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.Container,
                            new RecipesFragment(), null).commit();
                    break;

            }
        }

        public Recipe getRecipe() {
            return recipe;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvName.getText() + "'";
        }

    }
}