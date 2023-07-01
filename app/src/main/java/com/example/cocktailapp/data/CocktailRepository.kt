package com.example.cocktailapp.data

class CocktailRepository(private val theCocktailDBAPI: TheCocktailDBAPI) {

    suspend fun getRandomCocktailFromApi() = theCocktailDBAPI.getRandomCocktail()
}