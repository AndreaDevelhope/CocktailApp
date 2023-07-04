package com.example.cocktailapp.domain.models

data class Cocktail(
    val cocktailName: String,
    val cocktailInstructionsIT: String,
    val cocktailIsAlcoholic: String,
    val cocktailThumbnail: String,
    val ingredients: List<String>
    )
