package com.example.kitchapp.ui.suggestion.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.kitchapp.R;

public class IngredientsFragment extends Fragment {

    public static IngredientsFragment newInstance() {
        return new IngredientsFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_suggestion_tab_ingredients, container, false);
        return root;
    }
}