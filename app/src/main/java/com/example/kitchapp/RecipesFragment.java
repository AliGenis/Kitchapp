    package com.example.kitchapp;

    import android.os.Bundle;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.ArrayAdapter;
    import android.widget.ListView;
    import android.widget.TextView;
    import android.widget.Toast;

    import androidx.annotation.Nullable;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.appcompat.widget.SearchView;

    import java.util.ArrayList;


    /**
     * A fragment representing a list of Items.
     */
    public class RecipesFragment extends AppCompatActivity {
        SearchView searchView;
        ListView listView;
        ArrayList<String> list;
        ArrayAdapter<String> adapter;


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

            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_recipes_list);


            searchView = (SearchView) findViewById(R.id.searchView);
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






    }