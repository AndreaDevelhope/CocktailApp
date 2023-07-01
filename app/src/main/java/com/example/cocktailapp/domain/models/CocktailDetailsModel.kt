package com.example.cocktailapp.domain.models

data class CocktailDetailsModel(
    val cocktailName: String,
    val cocktailInstructionsIT: String,
    val cocktailIsAlcoholic: String,
    val cocktailThumbnail: String,
    val ingredients: List<String>
    )
