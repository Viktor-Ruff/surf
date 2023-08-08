package com.ruff.mycocktails;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ruff.mycocktails.databinding.FragmentListCocktailsBinding;

import java.util.ArrayList;

public class ListCocktailsFragment extends Fragment implements CocktailsAdapter.OnItemClick {

    private RecyclerView recyclerView;
    private CocktailsAdapter cocktailsAdapter;
    private ArrayList<Cocktail> cocktailArrayList;
    private FragmentListCocktailsBinding binding;
    private FragmentManager fragmentManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentListCocktailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = binding.rvCocktails;
        cocktailArrayList = new ArrayList<>();

        Cocktail cocktail1 = new Cocktail("Pina colada", "description", R.drawable.im_girl_, "ingredients", "recipe");
        Cocktail cocktail2 = new Cocktail("Pina colada", "description", R.drawable.im_girl_, "ingredients", "recipe");
        Cocktail cocktail3 = new Cocktail("Pina colada", "description", R.drawable.im_girl_, "ingredients", "recipe");
        Cocktail cocktail4 = new Cocktail("Pina colada", "description", R.drawable.im_girl_, "ingredients", "recipe");


        /*cocktailArrayList.add(cocktail1);
        cocktailArrayList.add(cocktail2);
        cocktailArrayList.add(cocktail3);
        cocktailArrayList.add(cocktail4);
        cocktailArrayList.add(cocktail4);
        cocktailArrayList.add(cocktail4);
        cocktailArrayList.add(cocktail4);
        cocktailArrayList.add(cocktail4);
        cocktailArrayList.add(cocktail4);
        cocktailArrayList.add(cocktail4);
        cocktailArrayList.add(cocktail4);
        cocktailArrayList.add(cocktail4);
        cocktailArrayList.add(cocktail4);
        cocktailArrayList.add(cocktail4);
        cocktailArrayList.add(cocktail4);
        cocktailArrayList.add(cocktail4);
        cocktailArrayList.add(cocktail4);
        cocktailArrayList.add(cocktail4);
        cocktailArrayList.add(cocktail4);
        cocktailArrayList.add(cocktail4);
        cocktailArrayList.add(cocktail4);*/

        if (cocktailArrayList.isEmpty()) {
            fragmentManager = requireActivity().getSupportFragmentManager();
            CreateCocktailFragment createCocktailFragment = new CreateCocktailFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.my_fragment_container, createCocktailFragment)
                    .commit();
        }


        cocktailsAdapter = new CocktailsAdapter(requireContext(), cocktailArrayList, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(cocktailsAdapter);


        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = requireActivity().getSupportFragmentManager();
                AddCocktailFragment addCocktailFragment = new AddCocktailFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.my_fragment_container, addCocktailFragment)
                        .addToBackStack("")
                        .commit();
            }
        });


    }

    @Override
    public void lookDetails(int position) {

    }
}