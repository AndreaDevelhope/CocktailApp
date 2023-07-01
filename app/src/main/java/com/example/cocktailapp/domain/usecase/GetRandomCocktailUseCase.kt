package com.example.cocktailapp.domain.usecase

import com.example.cocktailapp.data.CocktailRepository
import com.example.cocktailapp.data.Cocktail
import com.example.cocktailapp.domain.models.CocktailDetailsModel

class GetRandomCocktailUseCase(private val cocktailRepository: CocktailRepository) {

    suspend operator fun invoke(): List<CocktailDetailsModel> {
        val cocktailRemote = cocktailRepository.getRandomCocktailFromApi()
        return cocktailRemote.drinks.map {
            CocktailDetailsModel(
                it.strDrink,
                it.strInstructionsIT,
                it.strAlcoholic,
                it.strDrinkThumb,
                getIngredientsList(it)
            )
        }
    }


    private fun getIngredientsList(remoteCocktail: Cocktail): List<String> {
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
}