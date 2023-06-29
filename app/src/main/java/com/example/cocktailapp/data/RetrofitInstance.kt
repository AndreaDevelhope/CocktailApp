package com.example.cocktailapp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
private const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/"

object RetrofitInstance {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val cocktailService = retrofit.create(TheCocktaildbAPI::class.java)

    val cocktailRepository = CocktailRepository(cocktailService)
}