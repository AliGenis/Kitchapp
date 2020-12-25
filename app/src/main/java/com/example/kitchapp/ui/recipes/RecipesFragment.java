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



