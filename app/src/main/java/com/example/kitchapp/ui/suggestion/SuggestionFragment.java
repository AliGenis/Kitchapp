package com.example.kitchapp.ui.suggestion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;
import com.example.kitchapp.Recipe;
import com.example.kitchapp.ui.recipes.OneRecipeFragment;
import com.example.kitchapp.ui.suggestion.tabs.RecipeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuggestionFragment extends Fragment implements View.OnClickListener{

    ViewPager viewPager;
    TabLayout tabLayout;
    ImageButton btAccept, btReject;
    TextView recipeTitle, recipeInfo, calorieInfo, prepTime;
    List<Recipe> suggestionList = MainActivity.roomDatabaseClass.recipeDao().getRecipe();
    Recipe suggestion;
    int recipeID;

    public SuggestionFragment() {
    }

    public static SuggestionFragment getInstance() {
        return new SuggestionFragment();
    }

    public static SuggestionFragment newInstance(List<Recipe> recList) {
        SuggestionFragment fragment = new SuggestionFragment();
        Bundle args = new Bundle();
        ArrayList<Integer> recIDs = new ArrayList<Integer>();
        for(int i=0; i < recList.size();i++)
        {
            recIDs.add(recList.get(i).getRecipeID());
        }

        args.putIntegerArrayList("recIDs", recIDs);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_suggestion, container, false);

        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);
        ArrayList<Integer> recIDList = new ArrayList<>();
        List<Recipe> testList = MainActivity.roomDatabaseClass.recipeDao().getRecipe();
        List<Recipe> suggestedList = null;
        btAccept = view.findViewById(R.id.acceptButton);
        btReject = view.findViewById(R.id.rejectButton);
        recipeTitle = view.findViewById(R.id.recipeTitle);
        calorieInfo = view.findViewById(R.id.calText);
        prepTime = view.findViewById(R.id.timeText);

        if(getArguments() != null) {
            if (testList.get(0).getRecipe().equalsIgnoreCase(suggestionList.get(0).getName())) {
                recIDList = getArguments().getIntegerArrayList("recIDs");

                suggestedList = MainActivity.roomDatabaseClass.recipeDao().getRecipeByID(recIDList);
            }
            if (suggestedList != null)
                suggestionList = suggestedList;
        }

        btReject.setOnClickListener(this);
        btAccept.setOnClickListener(this);

        if( !suggestionList.isEmpty() ){
            Collections.shuffle(suggestionList);
            suggestion = suggestionList.get(0);

            recipeTitle.setText(suggestion.getName());
            calorieInfo.setText(Double.toString(suggestion.getCalorie()));
            prepTime.setText(Integer.toString(suggestion.getPrepTime()));
            calorieInfo.setText(Double.toString(suggestion.getCalorie()));
            prepTime.setText(Integer.toString(suggestion.getPrepTime()));
            recipeID = suggestion.getRecipeID();
        }
        else{
            recipeTitle.setText("No suggestion.");
            btAccept.setOnClickListener(null);
        }

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
            case(R.id.acceptButton):
                MainActivity.fragmentManager.beginTransaction().replace(R.id.Container, OneRecipeFragment.newInstance(recipeID), null).addToBackStack(null).commit();
                break;
            case(R.id.rejectButton):
                if( !suggestionList.isEmpty() ){
                    suggestion = suggestionList.get(0);
                    suggestionList.remove(0);
                    Collections.shuffle(suggestionList);
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.Container, SuggestionFragment.newInstance(suggestionList), null).addToBackStack(null).commit();

                } else{
                    recipeTitle.setText("No suggestion.");
                }
        }
    }
}