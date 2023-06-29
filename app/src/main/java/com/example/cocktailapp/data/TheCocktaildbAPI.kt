package com.example.cocktailapp.data

import retrofit2.http.GET

interface TheCocktaildbAPI {
    @GET("1/random.php")
    suspend fun getRandomCocktail(): CocktailRemote
}