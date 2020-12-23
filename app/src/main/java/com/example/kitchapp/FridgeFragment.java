package com.example.kitchapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FridgeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FridgeFragment extends AppCompatActivity implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "FRIDGEFRAGMENT";

    private static final String KEY_Ingredient1 = "Title";
    private static final String KEY_Ingredient2 = "Title";
    private static final String KEY_Ingredient3 = "Title";
    private static final String KEY_Ingredient4 = "Title";
    private static final String KEY_Ingredient5 = "Title";
    private static final String KEY_Ingredient6 = "Title";
    private static final String KEY_Ingredient7 = "Title";
    private static final String KEY_Ingredient8 = "Title";
    private static final String KEY_Ingredient9 = "Title";
    private static final String KEY_Ingredient10 = "Title";
    private static final String KEY_Ingredient11 = "Title";
    private static final String KEY_Ingredient12 = "Title";//when we save data to firebase we need key for them

    private FirebaseFirestore database = FirebaseFirestore.getInstance();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageButton button;
    private String plusName;
    private FragmentAListener listener;

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
        return fragment;
    }

    public interface FragmentAListener{
        void onInputASent(CharSequence input);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_fridge); //niye bilmiyorum
    }


    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fridge,container,true); //to make operations on design (another roots will be connected to it)

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

        plusButton1.setOnClickListener(this);
        plusButton2.setOnClickListener(this);
        plusButton3.setOnClickListener(this);
        plusButton4.setOnClickListener(this);
        plusButton5.setOnClickListener(this);
        plusButton6.setOnClickListener(this);
        plusButton7.setOnClickListener(this);
        plusButton8.setOnClickListener(this);
        plusButton9.setOnClickListener(this);
        plusButton10.setOnClickListener(this);
        plusButton11.setOnClickListener(this);
        plusButton12.setOnClickListener(this);

        ImageButton minusButton1 = rootView.findViewById(R.id.min1);
        ImageButton minusButton2 = rootView.findViewById(R.id.min2);
        ImageButton minusButton3 = rootView.findViewById(R.id.min3);
        ImageButton minusButton4 = rootView.findViewById(R.id.min4);
        ImageButton minusButton5 = rootView.findViewById(R.id.min5);
        ImageButton minusButton6 = rootView.findViewById(R.id.min6);
        ImageButton minusButton7 = rootView.findViewById(R.id.min7);
        ImageButton minusButton8 = rootView.findViewById(R.id.min8);
        ImageButton minusButton9 = rootView.findViewById(R.id.min9);
        ImageButton minusButton10 = rootView.findViewById(R.id.min10);
        ImageButton minusButton11 = rootView.findViewById(R.id.min11);
        ImageButton minusButton12 = rootView.findViewById(R.id.min12);

        minusButton1.setOnClickListener(this);
        minusButton2.setOnClickListener(this);
        minusButton3.setOnClickListener(this);
        minusButton4.setOnClickListener(this);
        minusButton5.setOnClickListener(this);
        minusButton6.setOnClickListener(this);
        minusButton7.setOnClickListener(this);
        minusButton8.setOnClickListener(this);
        minusButton9.setOnClickListener(this);
        minusButton10.setOnClickListener(this);
        minusButton11.setOnClickListener(this);
        minusButton12.setOnClickListener(this);

        ImageButton starLogoButton1 = rootView.findViewById(R.id.star_logo3);
        ImageButton starLogoButton2 = rootView.findViewById(R.id.star_logo4);
        ImageButton starLogoButton3 = rootView.findViewById(R.id.star_logo5);
        ImageButton starLogoButton4 = rootView.findViewById(R.id.star_logo6);
        ImageButton starLogoButton5 = rootView.findViewById(R.id.star_logo7);
        ImageButton starLogoButton6 = rootView.findViewById(R.id.star_logo8);
        ImageButton starLogoButton7 = rootView.findViewById(R.id.star_logo9);
        ImageButton starLogoButton8 = rootView.findViewById(R.id.star_logo10);
        ImageButton starLogoButton9 = rootView.findViewById(R.id.star_logo11);
        ImageButton starLogoButton10 = rootView.findViewById(R.id.star_logo12);
        ImageButton starLogoButton11 = rootView.findViewById(R.id.star_logo13);
        ImageButton starLogoButton12 = rootView.findViewById(R.id.star_logo14);

        starLogoButton1.setOnClickListener(this);
        starLogoButton2.setOnClickListener(this);
        starLogoButton3.setOnClickListener(this);
        starLogoButton4.setOnClickListener(this);
        starLogoButton5.setOnClickListener(this);
        starLogoButton6.setOnClickListener(this);
        starLogoButton7.setOnClickListener(this);
        starLogoButton8.setOnClickListener(this);
        starLogoButton9.setOnClickListener(this);
        starLogoButton10.setOnClickListener(this);
        starLogoButton11.setOnClickListener(this);
        starLogoButton12.setOnClickListener(this);

        TextView nameOfIng1 = rootView.findViewById(R.id.textView6);
        TextView nameOfIng2 = rootView.findViewById(R.id.textView8);
        TextView nameOfIng3 = rootView.findViewById(R.id.textView9);
        TextView nameOfIng4 = rootView.findViewById(R.id.textView2);
        TextView nameOfIng5 = rootView.findViewById(R.id.textView3);
        TextView nameOfIng6 = rootView.findViewById(R.id.textView4);
        TextView nameOfIng7 = rootView.findViewById(R.id.textView5);
        TextView nameOfIng8 = rootView.findViewById(R.id.textView10);
        TextView nameOfIng9 = rootView.findViewById(R.id.textView12);
        TextView nameOfIng10 = rootView.findViewById(R.id.textView13);
        TextView nameOfIng11 = rootView.findViewById(R.id.textView11);
        TextView nameOfIng12 = rootView.findViewById(R.id.textView14);



        return rootView;
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.star_logo3){
        //Toast.makeText(this,"Button 1 is clicked",Toast.LENGTH_SHORT).show();
        }
        else if(v.getId() == R.id.star_logo4){

        }
        else if(v.getId() == R.id.star_logo5){

        }
        else if(v.getId() == R.id.star_logo6){

        }
        else if(v.getId() == R.id.star_logo7){

        }
        else if(v.getId() == R.id.star_logo8){

        }
        else if(v.getId() == R.id.star_logo9){

        }
        else if(v.getId() == R.id.star_logo10){

        }
        else if(v.getId() == R.id.star_logo11){

        }
        else if(v.getId() == R.id.star_logo12){

        }
        else if(v.getId() == R.id.star_logo13){

        }
        else if(v.getId() == R.id.star_logo14){

        }

        if(v.getId() == R.id.plus1){

        }
        else if(v.getId() == R.id.plus2){

        }
       else if(v.getId() == R.id.plus3){

        }
       else if(v.getId() == R.id.plus4){

        }
       else if(v.getId() == R.id.plus5){

        }
       else if(v.getId() == R.id.plus6){

        }
        else if(v.getId() == R.id.plus7){

        }
        else if(v.getId() == R.id.plus8){

        }
        else if(v.getId() == R.id.plus9){

        }
        else if(v.getId() == R.id.plus10){

        }
        else if(v.getId() == R.id.plus11){

        }
        else if(v.getId() == R.id.plus12){

        }

        if(v.getId() == R.id.min1){

        }
        else if(v.getId() == R.id.min2){

        }
        else if(v.getId() == R.id.min3){

        }
        else if(v.getId() == R.id.min4){

        }
        else if(v.getId() == R.id.min5){

        }
        else if(v.getId() == R.id.min6){

        }
        else if(v.getId() == R.id.min7){

        }
        else if(v.getId() == R.id.min8){

        }
        else if(v.getId() == R.id.min9){

        }
        else if(v.getId() == R.id.min10){

        }
        else if(v.getId() == R.id.min11){

        }
        else if(v.getId() == R.id.min12){

        }


    }

    // Inflate the layout for this fragment
    //  return inflater.inflate(R.layout.fragment_fridge, container, false);
}