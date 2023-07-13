package com.example.cocktailapp.data.remote

import retrofit2.http.GET

interface TheCocktailDBAPI {
    @GET("1/random.php")
    suspend fun getRandomCocktail(): CocktailListRemote
}