package com.example.kitchapp.ui.recipes;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kitchapp.Fridge;
import com.example.kitchapp.Ingredient;
import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;
import com.example.kitchapp.Recipe;
import com.example.kitchapp.ui.fridge.AddItemFragment;
import com.example.kitchapp.ui.fridge.FridgeFragment;
import com.example.kitchapp.ui.suggestion.SectionPagerAdapter;
import com.example.kitchapp.ui.suggestion.tabs.IngredientsFragment;
import com.example.kitchapp.ui.suggestion.tabs.RecipeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.List;
import java.util.Objects;

import static com.example.kitchapp.MainActivity.fridge;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OneRecipeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OneRecipeFragment extends Fragment implements View.OnClickListener{

    private TextView recipeTitle;
    private TextView timeText;
    private TextView calText;
    private int recipeID;
    private Recipe recipe;
    ViewPager viewPager;
    TabLayout tabLayout;
    Button eatButton;

    public OneRecipeFragment() {
        // Required empty public constructor
    }

    public static OneRecipeFragment newInstance(int id) {
        OneRecipeFragment fragment = new OneRecipeFragment();
        Bundle args = new Bundle();
        args.putInt("idOfRecipe", id);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("UseRequireInsteadOfGet")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one_recipe, container, false);

        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);

       recipeID = getArguments().getInt("idOfRecipe",0);
        List<Recipe> recipes = MainActivity.roomDatabaseClass.recipeDao().getRecipe();
        for(int i = 0; i < recipes.size();i++) {
            if(recipeID == recipes.get(i).getRecipeID() )
                recipe = recipes.get(i);
        }

        eatButton = view.findViewById(R.id.eatIt);
        recipeTitle = view.findViewById(R.id.recipeTitle);
        calText = view.findViewById(R.id.calText);
        timeText = view.findViewById(R.id.timeText);

        recipeTitle.setText(recipe.getName());
        calText.setText(Double.toString(recipe.getCalorie()));
        timeText.setText(Integer.toString(recipe.getPrepTime()));
        eatButton.setOnClickListener(this);

        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

    }
    private void setUpViewPager(ViewPager viewPager) {

        SectionPagerAdapter adapter = new SectionPagerAdapter(getChildFragmentManager());

        adapter.addFragment(IngredientsFragment.newInstance(recipeID), "Ingredients");
        adapter.addFragment(RecipeFragment.newInstance(recipeID), "Recipe");

        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case(R.id.eatIt):
                fridge.eatMeal(recipe);
                Toast.makeText(getActivity(), "Bon appatit!", Toast.LENGTH_LONG).show();
                MainActivity.fragmentManager.beginTransaction().replace(R.id.Container, new FridgeFragment()
                        , null).addToBackStack(null).commit();
                break;
        }
    }
}