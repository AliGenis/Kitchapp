package com.example.kitchapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FridgeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FridgeFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageButton button;
    private String plusName;
    public FridgeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FridgeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FridgeFragment newInstance(String param1, String param2) {
        FridgeFragment fragment = new FridgeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/**
        ImageButton plusButton1 = rootView.findViewById(R.id.plus1); //to reach to button
        ImageButton plusButton2 = rootView.findViewById(R.id.plus2);
        ImageButton plusButton3 = rootView.findViewById(R.id.plus3);
        ImageButton plusButton4 = rootView.findViewById(R.id.plus4);
        ImageButton plusButton5 = rootView.findViewById(R.id.plus5);
        ImageButton plusButton6 = rootView.findViewById(R.id.plus6);
        ImageButton plusButton7 = rootView.findViewById(R.id.plus7);
        ImageButton plusButton8= rootView.findViewById(R.id.plus8);
        ImageButton plusButton9 = rootView.findViewById(R.id.plus9);
        ImageButton plusButton10 = rootView.findViewById(R.id.plus10);
        ImageButton plusButton11 = rootView.findViewById(R.id.plus11);
        ImageButton plusButton12 = rootView.findViewById(R.id.plus12);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
 }
        **/
        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fridge,container,true); //to make operations on design (another roots will be connected to it)



        return rootView;
    }

    @Override
    public void onClick(View view) {

    }

    // Inflate the layout for this fragment
    //  return inflater.inflate(R.layout.fragment_fridge, container, false);
}