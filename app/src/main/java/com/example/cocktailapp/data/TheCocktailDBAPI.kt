package com.example.cocktailapp.data

import retrofit2.http.GET

interface TheCocktailDBAPI {
    @GET("1/random.php")
    suspend fun getRandomCocktail(): CocktailRemote
}