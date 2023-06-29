package com.example.cocktailapp

import retrofit2.http.GET

interface TheCocktaildbAPI {
    @GET("1/random.php")
    suspend fun getRandomCocktail(): CocktailRemote
}