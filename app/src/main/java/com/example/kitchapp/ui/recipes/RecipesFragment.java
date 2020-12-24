    package com.example.kitchapp.ui.recipes;

    /**
     * A fragment representing a list of Items.
     */

    import android.annotation.SuppressLint;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.AdapterView;
    import android.widget.ArrayAdapter;
    import android.widget.ListView;

    import androidx.annotation.Nullable;
    import androidx.appcompat.widget.SearchView;
    import androidx.fragment.app.Fragment;

    import com.example.kitchapp.R;


    public class RecipesFragment extends Fragment {

        SearchView searchView;
        ListView listView;
        String[] nameList = {"Recipe1", "Recipe2", "Recipe3", "Recipe4", "Recipe5"};
        ArrayAdapter<String> arrayAdapter;

        @SuppressLint("NewApi")
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_recipes_list, container, false);

            searchView = view.findViewById(R.id.searchView);
            listView = view.findViewById(R.id.lv1);
            arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, nameList);
            listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = new Intent(getActivity().getApplicationContext(),RecipeScreen.class);
                    startActivity(i);

                }
            });

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    arrayAdapter.getFilter().filter(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    arrayAdapter.getFilter().filter(newText);

                    return false;
                }
            });

            return view;
        }
    }























   /* public class RecipesFragment extends Fragment {
        private SearchView searchView;
        ListView listView;
        ArrayList<String> list = new ArrayList<String>();
        RecipeList recipes = new RecipeList();
        ArrayAdapter<String> adapter;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

            list = new ArrayList<String>();
            //FixMe-- list arrayList implemented for testing purposes fix it for the final product
            list.add("Apple");
            list.add("Banana");
            list.add("Pineapple");
            list.add("Orange");
            list.add("Lychee");
            list.add("Gavava");


            //list = recipes.toArray();


            searchView = (SearchView)view.findViewById(R.id.searchView);
            listView = view.findViewById(R.id.lv1);
            //listView.setClickable(true);
            //adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
            //listView.setAdapter(adapter);



            /*searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {

                    if (list.contains(query)) {
                        adapter.getFilter().filter(query);
                    } else {
                        //Toast.makeText(RecipesFragment.this, "No Match found", Toast.LENGTH_LONG).show();
                    }
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }

            });*/
            //FIXME: there is possible bug in line below

           /* ListView lv = listView; // old version ListView lv = getListView();
            /*
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {  Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
                        Toast.LENGTH_SHORT).show();
                    // When clicked perform some action...
                }
            });*/
      //  }

       /* @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_recipes, container, false);
        }


        public RecipesFragment() {
            // Required empty public constructor
        }


*/
