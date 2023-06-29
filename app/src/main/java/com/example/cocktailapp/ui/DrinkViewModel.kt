package com.example.cocktailapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocktailapp.data.CocktailRemote
import com.example.cocktailapp.data.RetrofitInstance.cocktailRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class DrinkViewModel : ViewModel() {
    private val _drinkLiveData = MutableLiveData<CocktailRemote>()
    val drinkLiveData: LiveData<CocktailRemote> = _drinkLiveData


    fun getRandomDrinkFromApi() {
        CoroutineScope(Dispatchers.IO).launch {
            val randomDrink = cocktailRepository.getRandomDrinkFromApi()
            _drinkLiveData.postValue(randomDrink)
        }
    }

}