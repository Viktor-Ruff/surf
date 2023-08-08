package com.ruff.mycocktails;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

/**
 * Created by Viktor-Ruff
 * Date: 08.08.2023
 * Time: 16:46
 */
public class CocktailsAdapter extends RecyclerView.Adapter<CocktailsAdapter.CocktailViewHolder> {

    private LayoutInflater layoutInflater;
    private ArrayList<Cocktail> cocktailArrayList;
    private Context context;
    private OnItemClick onItemClick;


    public CocktailsAdapter(Context context, ArrayList<Cocktail> cocktailArrayList, OnItemClick onItemClick) {
        this.context = context;
        this.cocktailArrayList = cocktailArrayList;
        this.layoutInflater = LayoutInflater.from(context);
        this.onItemClick = onItemClick;
    }


    public interface OnItemClick {

        public void lookDetails(int position);
    }


    public static class CocktailViewHolder extends RecyclerView.ViewHolder {

        ShapeableImageView cocktailImage;
        TextView cocktailName;


        public CocktailViewHolder(@NonNull View itemView) {
            super(itemView);
            cocktailImage = itemView.findViewById(R.id.siv_cocktail_image);
            cocktailName = itemView.findViewById(R.id.tv_cocktail_name);
        }
    }


    @NonNull
    @Override
    public CocktailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_cocktail, parent, false);
        return new CocktailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CocktailViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Cocktail cocktail = cocktailArrayList.get(position);
        holder.cocktailName.setText(cocktail.getCocktailName());

        Glide.with(context)
                .load(cocktail.getCocktailImage())
                .into(holder.cocktailImage);

        holder.cocktailImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.lookDetails(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cocktailArrayList.size();
    }

}
