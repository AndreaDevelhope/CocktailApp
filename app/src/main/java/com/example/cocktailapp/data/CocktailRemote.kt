package com.example.cocktailapp.data


data class CocktailRemote(val drinks: List<Drink>)

data class Drink(
    val strDrink: String,
    val strInstructionsIT: String,
    val strAlcoholic: String,
    val strDrinkThumb: String
)

