package com.ruff.mycocktails;

/**
 * Created by Viktor-Ruff
 * Date: 08.08.2023
 * Time: 14:12
 */
public class Cocktail {

    private String cocktailName;
    private String cocktailDescription;
    private int cocktailImage;
    private String cocktailArrayIngredients;
    private String cocktailRecipe;


    public Cocktail(String cocktailName, String cocktailDescription, int cocktailImage, String cocktailArrayIngredients, String cocktailRecipe) {
        this.cocktailName = cocktailName;
        this.cocktailDescription = cocktailDescription;
        this.cocktailImage = cocktailImage;
        this.cocktailArrayIngredients = cocktailArrayIngredients;
        this.cocktailRecipe = cocktailRecipe;
    }

    public String getCocktailName() {
        return cocktailName;
    }

    public void setCocktailName(String cocktailName) {
        this.cocktailName = cocktailName;
    }

    public String getCocktailDescription() {
        return cocktailDescription;
    }

    public void setCocktailDescription(String cocktailDescription) {
        this.cocktailDescription = cocktailDescription;
    }

    public int getCocktailImage() {
        return cocktailImage;
    }

    public void setCocktailImage(int cocktailImage) {
        this.cocktailImage = cocktailImage;
    }

    public String getCocktailArrayIngredients() {
        return cocktailArrayIngredients;
    }

    public void setCocktailArrayIngredients(String cocktailArrayIngredients) {
        this.cocktailArrayIngredients = cocktailArrayIngredients;
    }

    public String getCocktailRecipe() {
        return cocktailRecipe;
    }

    public void setCocktailRecipe(String cocktailRecipe) {
        this.cocktailRecipe = cocktailRecipe;
    }
}
