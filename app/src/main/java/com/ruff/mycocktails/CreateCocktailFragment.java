package com.ruff.mycocktails;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ruff.mycocktails.databinding.FragmentCreateCocktailBinding;


public class CreateCocktailFragment extends Fragment {
    private FragmentManager fragmentManager;
    private FragmentCreateCocktailBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateCocktailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
}