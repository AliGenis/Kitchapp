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
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;
import com.example.kitchapp.Recipe;
import com.example.kitchapp.ui.recipes.AddRecipeFragment;
import com.example.kitchapp.ui.recipes.OneRecipeFragment;
import com.example.kitchapp.ui.recipes.RecyclerAdapter;
import com.example.kitchapp.ui.suggestion.tabs.IngredientsFragment;
import com.example.kitchapp.ui.suggestion.tabs.RecipeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class SuggestionFragment extends Fragment {
    ViewPager viewPager;
    TabLayout tabLayout;
    ImageButton btAccept, btReject;
    TextView recipeTitle, recipeInfo, calorieInfo, prepTime;
    List<Recipe> suggestionList;
    private RecyclerView.LayoutManager layoutManager;

    public SuggestionFragment() {
    }

    public static SuggestionFragment getInstance() {
        return new SuggestionFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_suggestion, container, false);
        List<Recipe> recipeList = MainActivity.roomDatabaseClass.recipeDao().getRecipe();


        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);

        btAccept = view.findViewById(R.id.acceptButton);
        btReject = view.findViewById(R.id.rejectButton);
        recipeTitle = view.findViewById(R.id.suggestionTitle);
        calorieInfo = view.findViewById(R.id.calorieInfo);
        prepTime = view.findViewById(R.id.prepTimeInfo);

        btReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recipe suggestion;
                if( !suggestionList.isEmpty() ){
                    suggestion = suggestionList.get(0);
                    suggestionList.remove(0);
                    recipeTitle.setText(suggestion.getName());
                    calorieInfo.setText(Double.toString(suggestion.getCalorie()));
                    prepTime.setText(Integer.toString(suggestion.getPrepTime()));
                } else{
                    recipeTitle.setText("No suggestion.");
                }
            }
        });
        btAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case (R.id.acceptButton):
                      Fragment oneRecipe = new OneRecipeFragment();
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.Container,oneRecipe);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                 //       MainActivity.fragmentManager.beginTransaction().replace(R.id.Container, new OneRecipeFragment()
                     //           , null).addToBackStack(null).commit();
                      break;
                }
            }
        });

        suggestionList = MainActivity.roomDatabaseClass.recipeDao().getRecipe();


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
}