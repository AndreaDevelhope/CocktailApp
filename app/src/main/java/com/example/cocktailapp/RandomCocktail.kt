package com.example.cocktailapp

data class RandomCocktail(val drinks: List<Drink>)

data class Drink(
    val strDrink: String,
    val strInstructionsIT: String,
    val strAlcoholic: String,
    val strDrinkThumb: String
)