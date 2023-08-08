package com.ruff.mycocktails;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.ruff.mycocktails.databinding.FragmentAddCocktailBinding;


public class AddCocktailFragment extends Fragment {

    private FragmentAddCocktailBinding binding;
    private ChipGroup chipGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAddCocktailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        chipGroup = binding.chipGroup;
        binding.sivAddIngredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(requireContext());
                LayoutInflater inflater = requireActivity().getLayoutInflater();
                View customView = inflater.inflate(R.layout.custom_dialog, null);

                alertDialog.setView(customView).show();

                /*CustomDialogFragment customDialogFragment = new CustomDialogFragment();
                customDialogFragment.show(getActivity().getSupportFragmentManager(), "custom");*/


                Button add = customView.findViewById(R.id.bt_add);
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText ingredientName = (EditText) customView.findViewById(R.id.tie_ingredient_name);
                        String text = ingredientName.getText().toString();
                        if (text == null || ingredientName.length() == 0) {
                            Toast.makeText(requireContext(), "Input ingredient please", Toast.LENGTH_SHORT).show();
                        } else {
                            Chip newChip = (Chip) inflater.inflate(R.layout.empty_chip, chipGroup, false);
                            newChip.setText(text);
                            chipGroup.addView(newChip);

                            newChip.setOnCloseIconClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    chipGroup.removeView(newChip);
                                }
                            });
                        }
                    }
                });


                Button cancel = customView.findViewById(R.id.bt_cancel);

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });


            }
        });

    }


}