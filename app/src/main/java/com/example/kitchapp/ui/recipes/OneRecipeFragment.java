package com.example.kitchapp.ui.recipes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kitchapp.Ingredient;
import com.example.kitchapp.MainActivity;
import com.example.kitchapp.R;
import com.example.kitchapp.Recipe;
import com.example.kitchapp.ui.fridge.RecyclerAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OneRecipeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OneRecipeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageView imageOfRecipe;
    private TextView recipeTitle;
    private TextView recipeWindow;
    private TextView timeText;
    private TextView calText;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter recyclerAdapter;

    public OneRecipeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OneRecipeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OneRecipeFragment newInstance(String param1, String param2) {
        OneRecipeFragment fragment = new OneRecipeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one_recipe, container, false);

        recipeTitle = view.findViewById(R.id.recipeTitle);
        recipeWindow = view.findViewById(R.id.recipeText);
        calText = view.findViewById(R.id.calText);
        imageOfRecipe = view.findViewById(R.id.imageOfRecipe);
        timeText = view.findViewById(R.id.timeText);

        recyclerView = view.findViewById(R.id.recipesRecyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        List<Recipe> list2 = MainActivity.roomDatabaseClass.recipeDao().getRecipe();
       // recyclerAdapter = new com.example.kitchapp.ui.recipes.RecyclerAdapter(list2);
        recyclerView.setAdapter(recyclerAdapter);

        return view;
    }
}