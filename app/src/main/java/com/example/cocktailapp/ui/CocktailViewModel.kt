package com.example.cocktailapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocktailapp.domain.models.CocktailDetailsModel
import com.example.cocktailapp.domain.usecase.GetRandomCocktailUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class CocktailViewModel(private val getRandomCocktailUseCase: GetRandomCocktailUseCase) : ViewModel() {
    private val _cocktailLiveData = MutableLiveData<List<CocktailDetailsModel>>()
    val cocktailLiveData: LiveData<List<CocktailDetailsModel>> = _cocktailLiveData


    fun getRandomCocktailFromApi() {
        CoroutineScope(Dispatchers.IO).launch {
            val randomCocktail = getRandomCocktailUseCase.invoke()
            _cocktailLiveData.postValue(randomCocktail)
        }
    }

}