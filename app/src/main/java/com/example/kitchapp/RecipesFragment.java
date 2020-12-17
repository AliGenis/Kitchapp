    package com.example.kitchapp;

    import android.content.Context;
    import android.os.Bundle;

    import androidx.fragment.app.Fragment;
    import androidx.recyclerview.widget.GridLayoutManager;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;

    import com.example.kitchapp.dummy.DummyContent;

    /**
     * A fragment representing a list of Items.
     */
    public class RecipesFragment extends AppCompatActivity {
        SearchView searchView;
        ListView listView;
        ArrayList<String> list;
        ArrayList<Recipe> recipes;
        ArrayAdapter<String> adapter;
        CustomListViewAdapter listViewAdapter;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            list = new ArrayList<String>();

            list.add("Apple");
            list.add("Banana");
            list.add("Pineapple");
            list.add("Orange");
            list.add("Lychee");
            list.add("Gavava");

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            initialize();
            fillArrayList(recipes);

            searchView = (SearchView) findViewById(R.id.searchView);
            listView = (ListView) findViewById(R.id.lv1);
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
            listView.setAdapter(adapter);



            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {

                    if (list.contains(query)) {
                        adapter.getFilter().filter(query);
                    } else {
                        Toast.makeText(MainActivity.this, "No Match found", Toast.LENGTH_LONG).show();
                    }
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }

            });



        }



        private void initialize() {
            recipes = new ArrayList<Recipe>();
            listView = (ListView) findViewById(R.id.lv1);
            listViewAdapter = new CustomListViewAdapter(MainActivity.this,recipes);
            listView.setAdapter(listViewAdapter);
        }

        private void fillArrayList(ArrayList<Recipe>recipes){
            for (int index = 0; index < 20; index++) {
                Recipe recipe = new Recipe("Mr. Android " + index, "Nowhere", R.drawable.android_icon);
                recipes.add(recipe);
            }

        }


    }