package com.example.kitchapp.ui.suggestion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.kitchapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SuggestionScreen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SuggestionScreen extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    //ImageButton tick = rootView.R.id.suggestion_tick_button;
    TabHost tab;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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
        //TextView textView = (TextView)findViewById(R.id.timeText);
        //textView.setText("Deneme");
        //setContentView(R.layout.fragment_suggestion_screen);


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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView timeText = view.findViewById(R.id.timeText);
        timeText.setText("20min");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_suggestion_screen, container, false);
        //TextView textView = textView.findViewById(R.id.timeText);
        //textView.setText("Deneme");
        //setContentView(R.layout.fragment_suggestion_screen);

    }
}