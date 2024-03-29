package com.example.kitchapp.ui.suggestion;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.kitchapp.Ingredient;
import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;
import com.example.kitchapp.Recipe;
import com.example.kitchapp.ui.recipes.OneRecipeFragment;
import com.example.kitchapp.ui.suggestion.tabs.IngredientsFragment;
import com.example.kitchapp.ui.suggestion.tabs.RecipeFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SuggestionFragment extends Fragment implements View.OnClickListener {

    ViewPager viewPager;
    TabLayout tabLayout;
    ImageButton btAccept, btReject;
    TextView recipeTitle;
    TextView calorieInfo;
    TextView prepTime;
    List<Recipe> suggestionList;
    Recipe suggestion;
    int recipeID;
    Random random = new Random();
    private String[] listOfQuotes = {"So, you do not like it, ha?!"
            , "How could you dare to not like it!"
            , "Dammit Jacob, You are very hard to please!"
            , "私はこれが嫌いです!!!"
            , "Comment me rejetez-vous"
            , "Bu gezek bolmady!"
            , "Come puoi rifiutarmi \uD83D\uDC4C"};
    private String[] listOfQuotes2 = {"I see you liked it."
            , "I love you too!"
            , "Dammit Jacob, You are very easy to please!"
            , "どうもありがとう!!!"
            , "haha je vois que tu as aimé"
            , "Bu gezek boldy!"
            , "ti amo tanto ♥️\uD83D\uDC4C"};

    public SuggestionFragment() {
    }

    public static SuggestionFragment newInstance(List<Recipe> recList) {
        SuggestionFragment fragment = new SuggestionFragment();
        if (!recList.isEmpty()) {
            Bundle args = new Bundle();
            Gson gson = new Gson();
            String ingredients = gson.toJson(recList);
            args.putString("suggestionRec", ingredients);

            fragment.setArguments(args);
        }

        return fragment;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_suggestion, container, false);

        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);
        btAccept = view.findViewById(R.id.acceptButton);
        btReject = view.findViewById(R.id.rejectButton);
        recipeTitle = view.findViewById(R.id.recipeTitle);
        calorieInfo = view.findViewById(R.id.calText);
        prepTime = view.findViewById(R.id.timeText);


        if (getArguments() != null) {

            Type listType = new TypeToken<ArrayList<Recipe>>() {
            }.getType();
            suggestionList = new Gson().fromJson(getArguments().getString("suggestionRec"), listType);

            if (!suggestionList.isEmpty()) {
                Collections.shuffle(suggestionList);
                suggestion = suggestionList.get(0);

                recipeTitle.setText(suggestion.getName());
                calorieInfo.setText(Double.toString(suggestion.getCalorie()));
                prepTime.setText(Integer.toString(suggestion.getPrepTime()));
                calorieInfo.setText(Double.toString(suggestion.getCalorie()));
                prepTime.setText(Integer.toString(suggestion.getPrepTime()));
                btReject.setOnClickListener(this);
                btAccept.setOnClickListener(this);
                recipeID = suggestion.getRecipeID();
                setUpViewPager(viewPager);
                tabLayout.setupWithViewPager(viewPager);
            } else {
                recipeTitle.setText("No suggestion.");
                btAccept.setOnClickListener(null);
                btReject.setOnClickListener(null);
            }
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void setUpViewPager(ViewPager viewPager) {

        SectionPagerAdapter adapter = new SectionPagerAdapter(getChildFragmentManager());

        adapter.addFragment(IngredientsFragment.newInstance(recipeID), "Ingredients");
        adapter.addFragment(RecipeFragment.newInstance(recipeID), "Recipe");

        viewPager.setAdapter(adapter);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.acceptButton):
                Toast.makeText(getActivity(), listOfQuotes2[random.nextInt(7)], Toast.LENGTH_LONG).show();
                MainActivity.fragmentManager.beginTransaction().replace(R.id.Container, OneRecipeFragment.newInstance(recipeID), null).addToBackStack(null).commit();
                break;
            case (R.id.rejectButton):
                if (!suggestionList.isEmpty()) {
                    suggestion = suggestionList.get(0);
                    suggestionList.remove(0);
                    Collections.shuffle(suggestionList);
                    Toast.makeText(getActivity(), listOfQuotes[random.nextInt(7)], Toast.LENGTH_LONG).show();
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.Container, SuggestionFragment.newInstance(suggestionList), null).addToBackStack(null).commit();

                } else {
                    recipeTitle.setText("No suggestion.");
                }
        }
    }
}