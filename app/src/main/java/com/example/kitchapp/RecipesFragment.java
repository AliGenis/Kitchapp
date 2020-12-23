    package com.example.kitchapp;

    import android.os.Bundle;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.AdapterView;
    import android.widget.ArrayAdapter;
    import android.widget.ListView;
    import android.widget.TextView;
    import android.widget.Toast;

    import androidx.annotation.Nullable;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.appcompat.widget.SearchView;
    import androidx.fragment.app.Fragment;

    import java.util.ArrayList;


    /**
     * A fragment representing a list of Items.
     */
    public class RecipesFragment extends Fragment {
        SearchView searchView;
        ListView listView;
        ArrayList<String> list = new ArrayList<String>();
        RecipeList recipes = new RecipeList();
        ArrayAdapter<String> adapter;

        /** TODO change methods according to fragment class
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {

            list = new ArrayList<String>();
            //FixMe-- list arrayList implemented for testing purposes fix it for the final product
            list.add("Apple");
            list.add("Banana");
            list.add("Pineapple");
            list.add("Orange");
            list.add("Lychee");
            list.add("Gavava");


            //list = recipes.toArray();

            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_recipes_list);


            searchView = findViewById(R.id.searchView);
            listView = (ListView) findViewById(R.id.lv1);
            listView.setClickable(true);
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
            listView.setAdapter(adapter);



            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {

                    if (list.contains(query)) {
                        adapter.getFilter().filter(query);
                    } else {
                        Toast.makeText(RecipesFragment.this, "No Match found", Toast.LENGTH_LONG).show();
                    }
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }

            });
            //FIXME: there is possible bug in line below

            ListView lv = listView; // old version ListView lv = getListView();
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {  Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
                        Toast.LENGTH_SHORT).show();
                    // When clicked perform some action...
                }
            });
        }
        /*
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_recipes, container, false);
        }


        public RecipesFragment() {
            // Required empty public constructor
        }
**/


    }