package com.example.kitchapp.ui.fridge;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.kitchapp.R;
import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FridgeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FridgeFragment extends Fragment //implements View.OnClickListener
{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "FridgeFragment";

    private static final String KEY_Ingredient1 = "ing1";
    private static final String KEY_Ingredient2 = "ing2";
    private static final String KEY_Ingredient3 = "ing3";
    private static final String KEY_Ingredient4 = "ing4";
    private static final String KEY_Ingredient5 = "ing5";
    private static final String KEY_Ingredient6 = "ing6";
    private static final String KEY_Ingredient7 = "ing7";
    private static final String KEY_Ingredient8 = "ing8";
    private static final String KEY_Ingredient9 = "ing9";
    private static final String KEY_Ingredient10 = "ing10";
    private static final String KEY_Ingredient11 = "ing11";
    private static final String KEY_Ingredient12 = "ing12";//when we save data to firebase we need key for them
    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageButton button;
    private String plusName;
    private FragmentAListener listener;

    ImageButton plusButton1;
    ImageButton plusButton2;
    ImageButton plusButton3;
    ImageButton plusButton4;
    ImageButton plusButton5;
    ImageButton plusButton6;
    ImageButton plusButton7;
    ImageButton plusButton8;
    ImageButton plusButton9;
    ImageButton plusButton10;
    ImageButton plusButton11;
    ImageButton plusButton12;

    ImageButton minusButton1;
    ImageButton minusButton2;
    ImageButton minusButton3;
    ImageButton minusButton4;
    ImageButton minusButton5;
    ImageButton minusButton6;
    ImageButton minusButton7;
    ImageButton minusButton8;
    ImageButton minusButton9;
    ImageButton minusButton10;
    ImageButton minusButton11;
    ImageButton minusButton12;

    ImageButton starLogoButton1;
    ImageButton starLogoButton2;
    ImageButton starLogoButton3;
    ImageButton starLogoButton4;
    ImageButton starLogoButton5;
    ImageButton starLogoButton6;
    ImageButton starLogoButton7;
    ImageButton starLogoButton8;
    ImageButton starLogoButton9;
    ImageButton starLogoButton10;
    ImageButton starLogoButton11;
    ImageButton starLogoButton12;

    TextView nameOfIng1;
    TextView nameOfIng2;
    TextView nameOfIng3;
    TextView nameOfIng4;
    TextView nameOfIng5;
    TextView nameOfIng6;
    TextView nameOfIng7;
    TextView nameOfIng8;
    TextView nameOfIng9;
    TextView nameOfIng10;
    TextView nameOfIng11;
    TextView nameOfIng12;




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

    public FridgeFragment(){

    }
    public interface FragmentAListener{
        void onInputASent(CharSequence input);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_fridge);
        plusButton1 = view.findViewById(R.id.plus1); //to reach to button
        plusButton2 = view.findViewById(R.id.plus2);
        plusButton3 = view.findViewById(R.id.plus3);
        plusButton1 = view.findViewById(R.id.plus4);//to reach to button
        plusButton2 = view.findViewById(R.id.plus5);
        plusButton3 = view.findViewById(R.id.plus6);
        plusButton1 = view.findViewById(R.id.plus7);//to reach to button
        plusButton2 = view.findViewById(R.id.plus8);
        plusButton3 = view.findViewById(R.id.plus9);
        plusButton1 = view.findViewById(R.id.plus10); //to reach to button
        plusButton2 = view.findViewById(R.id.plus11);
        plusButton3 = view.findViewById(R.id.plus12);

        /*
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

         */


        minusButton1 = view.findViewById(R.id.min1);
        minusButton2 = view.findViewById(R.id.min2);
        minusButton3 = view.findViewById(R.id.min3);
        minusButton4 = view.findViewById(R.id.min4);
        minusButton5 = view.findViewById(R.id.min5);
        minusButton6 = view.findViewById(R.id.min6);
        minusButton7 = view.findViewById(R.id.min7);
        minusButton8 = view.findViewById(R.id.min8);
        minusButton9 = view.findViewById(R.id.min9);
        minusButton10 = view.findViewById(R.id.min10);
        minusButton11 = view.findViewById(R.id.min11);
        minusButton12 = view.findViewById(R.id.min12);

        /*
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

         */

        starLogoButton1 = view.findViewById(R.id.star_logo3);
        starLogoButton2 = view.findViewById(R.id.star_logo4);
        starLogoButton3 = view.findViewById(R.id.star_logo5);
        starLogoButton4 = view.findViewById(R.id.star_logo6);
        starLogoButton5 = view.findViewById(R.id.star_logo7);
        starLogoButton6 = view.findViewById(R.id.star_logo8);
        starLogoButton7 = view.findViewById(R.id.star_logo9);
        starLogoButton8 = view.findViewById(R.id.star_logo10);
        starLogoButton9 = view.findViewById(R.id.star_logo11);
        starLogoButton10 = view.findViewById(R.id.star_logo12);
        starLogoButton11 = view.findViewById(R.id.star_logo13);
        starLogoButton12 = view.findViewById(R.id.star_logo14);

        /*
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

         */

        nameOfIng1 = view.findViewById(R.id.textView6);
        nameOfIng2 = view.findViewById(R.id.textView8);
        nameOfIng3 = view.findViewById(R.id.textView9);
        nameOfIng4 = view.findViewById(R.id.textView2);
        nameOfIng5 = view.findViewById(R.id.textView3);
        nameOfIng6 = view.findViewById(R.id.textView4);
        nameOfIng7 = view.findViewById(R.id.textView5);
        nameOfIng8 = view.findViewById(R.id.textView10);
        nameOfIng9 = view.findViewById(R.id.textView12);
        nameOfIng10 = view.findViewById(R.id.textView13);
        nameOfIng11 = view.findViewById(R.id.textView11);
        nameOfIng12 = view.findViewById(R.id.textView14);

    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void saveNote(View v){
        String ing1 = nameOfIng1.getText().toString();
        String ing2 = nameOfIng1.getText().toString();
        String ing3 = nameOfIng1.getText().toString();
        String ing4 = nameOfIng1.getText().toString();
        String ing5 = nameOfIng1.getText().toString();
        String ing6 = nameOfIng1.getText().toString();
        String ing7 = nameOfIng1.getText().toString();
        String ing8 = nameOfIng1.getText().toString();
        String ing9 = nameOfIng1.getText().toString();
        String ing10 = nameOfIng1.getText().toString();
        String ing11 = nameOfIng1.getText().toString();
        String ing12= nameOfIng1.getText().toString();

        Map<String,Object> ingredient = new HashMap<>();
        ingredient.put(KEY_Ingredient1,ing1);
        ingredient.put(KEY_Ingredient2,ing2);
        ingredient.put(KEY_Ingredient3,ing3);
        ingredient.put(KEY_Ingredient4,ing4);
        ingredient.put(KEY_Ingredient5,ing5);
        ingredient.put(KEY_Ingredient6,ing6);
        ingredient.put(KEY_Ingredient7,ing7);
        ingredient.put(KEY_Ingredient8,ing8);
        ingredient.put(KEY_Ingredient9,ing9);
        ingredient.put(KEY_Ingredient10,ing10);
        ingredient.put(KEY_Ingredient11,ing11);
        ingredient.put(KEY_Ingredient12,ing12);

        /*
        database.collection("Ingredients").document("My first ingredient").set(ingredient).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {//either succsesfull or not
            Toast.makeText(FridgeFragment.this,"Ingredient saved",Toast.LENGTH_SHORT).show();
            }
        })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(FridgeFragment.this,"Error!",Toast.LENGTH_SHORT).show();
                Log.d(TAG,e.toString());
            }
        });*/
    }



    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fridge,container,false); //to make operations on design (another roots will be connected to it)

        return rootView;
    }


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