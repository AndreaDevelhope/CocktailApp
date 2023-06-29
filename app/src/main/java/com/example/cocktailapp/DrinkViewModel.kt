package com.example.cocktailapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/"

class DrinkViewModel : ViewModel() {
    private val _drinkLiveData = MutableLiveData<CocktailRemote>()
    val drinkLiveData: LiveData<CocktailRemote> = _drinkLiveData

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val cocktailService = retrofit.create(TheCocktaildbAPI::class.java)


    fun getRandomDrinkFromApi() {
        CoroutineScope(Dispatchers.IO).launch {
            val randomDrink = cocktailService.getRandomCocktail()
            _drinkLiveData.postValue(randomDrink)
        }
    }


}