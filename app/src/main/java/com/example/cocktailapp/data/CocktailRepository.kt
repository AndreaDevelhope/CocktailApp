package com.example.cocktailapp.data

import com.example.cocktailapp.domain.models.Cocktail

class CocktailRepository(private val theCocktailDBAPI: TheCocktailDBAPI) {

    suspend fun getRandomCocktailFromApi() = theCocktailDBAPI.getRandomCocktail().drinks[0]
    fun toCocktail(cocktailRemote: CocktailRemote): Cocktail {
        return Cocktail(
            cocktailName = cocktailRemote.strDrink,
            cocktailInstructionsIT = cocktailRemote.strInstructionsIT,
            cocktailIsAlcoholic = cocktailRemote.strAlcoholic,
            cocktailThumbnail = cocktailRemote.strDrinkThumb,
            ingredients = getIngredientsList(cocktailRemote)
        )
    }
}


private fun getIngredientsList(remoteCocktail: CocktailRemote): List<String> {
    val ingredientsList = mutableListOf<String>()
    remoteCocktail.strIngredient1?.let { ingredientsList.add(it) }
    remoteCocktail.strIngredient2?.let { ingredientsList.add(it) }
    remoteCocktail.strIngredient3?.let { ingredientsList.add(it) }
    remoteCocktail.strIngredient4?.let { ingredientsList.add(it) }
    remoteCocktail.strIngredient5?.let { ingredientsList.add(it) }
    remoteCocktail.strIngredient6?.let { ingredientsList.add(it) }
    remoteCocktail.strIngredient7?.let { ingredientsList.add(it) }
    remoteCocktail.strIngredient8?.let { ingredientsList.add(it) }
    remoteCocktail.strIngredient9?.let { ingredientsList.add(it) }
    remoteCocktail.strIngredient10?.let { ingredientsList.add(it) }
    remoteCocktail.strIngredient11?.let { ingredientsList.add(it) }
    remoteCocktail.strIngredient12?.let { ingredientsList.add(it) }
    remoteCocktail.strIngredient13?.let { ingredientsList.add(it) }
    remoteCocktail.strIngredient14?.let { ingredientsList.add(it) }
    remoteCocktail.strIngredient15?.let { ingredientsList.add(it) }
    return ingredientsList
}