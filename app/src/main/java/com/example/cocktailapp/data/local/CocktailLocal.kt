package com.example.cocktailapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cocktailapp.domain.models.Cocktail

@Entity(tableName = "Cocktails")
data class CocktailLocal(
    @PrimaryKey val cocktailName: String,
    val cocktailInstructionsIT: String,
    val cocktailIsAlcoholic: String,
    val cocktailThumbnail: String,
    val ingredients: List<String>
)


fun CocktailLocal.toCocktail() = Cocktail(cocktailName,cocktailInstructionsIT,cocktailIsAlcoholic,cocktailThumbnail,ingredients)
