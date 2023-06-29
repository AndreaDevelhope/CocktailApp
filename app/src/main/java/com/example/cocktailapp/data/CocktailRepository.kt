package com.example.cocktailapp.data

class CocktailRepository(private val theCocktaildbAPI: TheCocktaildbAPI) {

    suspend fun getRandomDrinkFromApi() = theCocktaildbAPI.getRandomCocktail()
}