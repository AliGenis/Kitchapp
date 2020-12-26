package com.example.kitchapp.ui.suggestion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;
import com.example.kitchapp.Recipe;
import com.example.kitchapp.ui.recipes.OneRecipeFragment;
import com.example.kitchapp.ui.suggestion.tabs.IngredientsFragment;
import com.example.kitchapp.ui.suggestion.tabs.RecipeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class SuggestionFragment extends Fragment implements View.OnClickListener{

    ViewPager viewPager;
    TabLayout tabLayout;
    ImageButton btAccept, btReject;
    TextView recipeTitle, recipeInfo, calorieInfo, prepTime;
    List<Recipe> suggestionList = MainActivity.roomDatabaseClass.recipeDao().getRecipe();;
    Recipe suggestion;
    int recipeID;

    public SuggestionFragment() {
    }

    public static SuggestionFragment getInstance() {
        return new SuggestionFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_suggestion, container, false);

        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);

        btAccept = view.findViewById(R.id.acceptButton);
        btReject = view.findViewById(R.id.rejectButton);
        recipeTitle = view.findViewById(R.id.suggestionTitle);
        calorieInfo = view.findViewById(R.id.calorieInfo);
        prepTime = view.findViewById(R.id.prepTimeInfo);

        btReject.setOnClickListener(this);
        btAccept.setOnClickListener(this);
        
        if( !suggestionList.isEmpty() ){
            suggestion = suggestionList.get(0);
            suggestionList.remove(0);
            recipeTitle.setText(suggestion.getName());
            calorieInfo.setText(Double.toString(suggestion.getCalorie()));
            prepTime.setText(Integer.toString(suggestion.getPrepTime()));
            calorieInfo.setText(Double.toString(suggestion.getCalorie()));
            prepTime.setText(Integer.toString(suggestion.getPrepTime()));
            recipeID = suggestion.getRecipeID();
        }
        else{
            recipeTitle.setText("No suggestion.");
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }

        });
    }

    private void setUpViewPager(ViewPager viewPager) {

        SectionPagerAdapter adapter = new SectionPagerAdapter(getChildFragmentManager());

        adapter.addFragment(new IngredientsFragment(), "Ingredients");
        adapter.addFragment(new RecipeFragment(), "Recipe");

        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case(R.id.acceptButton):
                MainActivity.fragmentManager.beginTransaction().replace(R.id.Container, OneRecipeFragment.newInstance(recipeID), null).addToBackStack(null).commit();
                break;
            case(R.id.rejectButton):
                if( !suggestionList.isEmpty() ){
                    suggestion = suggestionList.get(0);
                    suggestionList.remove(0);
                    recipeTitle.setText(suggestion.getName());
                    calorieInfo.setText(Double.toString(suggestion.getCalorie()));
                    prepTime.setText(Integer.toString(suggestion.getPrepTime()));
                    calorieInfo.setText(Double.toString(suggestion.getCalorie()));
                    prepTime.setText(Integer.toString(suggestion.getPrepTime()));
                    recipeID = suggestion.getRecipeID();
                } else{
                    recipeTitle.setText("No suggestion.");
                }
        }
    }
}