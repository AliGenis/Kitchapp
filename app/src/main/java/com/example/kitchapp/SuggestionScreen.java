package com.example.kitchapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SuggestionScreen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SuggestionScreen extends AppCompatActivity{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    /*private String mParam1;
    private String mParam2;
    TabHost tab;

    public SuggestionScreen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SuggestionScreen.
     */
    /*
    // TODO: Rename and change types and number of parameters
    public static SuggestionScreen newInstance(String param1, String param2) {
        SuggestionScreen fragment = new SuggestionScreen();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_suggestion_screen);
        TextView textView = (TextView)findViewById(R.id.suggestedMealName);
        textView.setText("Deneme");
        /*Trying to add functional tabs
        tab=(TabHost)findViewById(R.id.tabs);
        tab.setup();
        TabHost.TabSpec s1=tab.newTabSpec("Sayfa-1");
        TabHost.TabSpec s2=tab.newTabSpec("Sayfa-2");

        s1.setContent(R.id.Ingredients);
        s2.setContent(R.id.tab2);
        s1.setIndicator("Sayfa-1");
        s2.setIndicator("Sayfa-2");
        tab.addTab(s1);
        tab.addTab(s2);
        */
        /*
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
    }

    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_suggestion_screen, container, false);
    }*/
}