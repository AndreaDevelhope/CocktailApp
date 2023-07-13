package com.example.cocktailapp.data.remote

import com.example.cocktailapp.domain.models.Cocktail


data class CocktailListRemote(val drinks: List<CocktailRemote>)

data class CocktailRemote(
    val strDrink: String,
    val strInstructionsIT: String,
    val strAlcoholic: String,
    val strDrinkThumb: String,
    val strIngredient1: String?,
    val strIngredient2: String?,
    val strIngredient3: String?,
    val strIngredient4: String?,
    val strIngredient5: String?,
    val strIngredient6: String?,
    val strIngredient7: String?,
    val strIngredient8: String?,
    val strIngredient9: String?,
    val strIngredient10: String?,
    val strIngredient11: String?,
    val strIngredient12: String?,
    val strIngredient13: String?,
    val strIngredient14: String?,
    val strIngredient15: String?,
)

fun CocktailRemote.toCocktail(): Cocktail {
    return Cocktail(
        cocktailName = strDrink,
        cocktailInstructionsIT = strInstructionsIT,
        cocktailIsAlcoholic = strAlcoholic,
        cocktailThumbnail = strDrinkThumb,
        ingredients = getIngredientsList()
    )
}

fun CocktailRemote.getIngredientsList(): List<String> {
    val ingredientsList = mutableListOf<String>()
    strIngredient1?.let { ingredientsList.add(it) }
    strIngredient2?.let { ingredientsList.add(it) }
    strIngredient3?.let { ingredientsList.add(it) }
    strIngredient4?.let { ingredientsList.add(it) }
    strIngredient5?.let { ingredientsList.add(it) }
    strIngredient6?.let { ingredientsList.add(it) }
    strIngredient7?.let { ingredientsList.add(it) }
    strIngredient8?.let { ingredientsList.add(it) }
    strIngredient9?.let { ingredientsList.add(it) }
    strIngredient10?.let { ingredientsList.add(it) }
    strIngredient11?.let { ingredientsList.add(it) }
    strIngredient12?.let { ingredientsList.add(it) }
    strIngredient13?.let { ingredientsList.add(it) }
    strIngredient14?.let { ingredientsList.add(it) }
    strIngredient15?.let { ingredientsList.add(it) }
    return ingredientsList
}
