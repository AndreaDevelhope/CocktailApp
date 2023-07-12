package com.example.cocktailapp.ui

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocktailapp.domain.models.Cocktail
import com.example.cocktailapp.domain.usecase.GetRandomCocktailUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch


const val KEY_FIRST_TIME_USER = "first_time_user"


class CocktailViewModel(private val getRandomCocktailUseCase: GetRandomCocktailUseCase, private val preferences: SharedPreferences) :
    ViewModel() {
    private val _cocktailFlow = MutableSharedFlow<Cocktail>()
    val cocktailFlow: SharedFlow<Cocktail> = _cocktailFlow

    private val _firstTimeUserLiveData = MutableLiveData<Boolean>()
    val firstTimeUserLiveData: LiveData<Boolean> = _firstTimeUserLiveData

    init {
        checkFirstTimeUser(preferences)
    }

    private fun checkFirstTimeUser(preferences: SharedPreferences) {
        val firstTimeUser = preferences.getBoolean(KEY_FIRST_TIME_USER, true)
        if (firstTimeUser){
            preferences.edit().putBoolean(KEY_FIRST_TIME_USER,false).apply()
            _firstTimeUserLiveData.postValue(true)
            return
        }
        _firstTimeUserLiveData.postValue(false)
    }

    fun getRandomCocktailFromApi() {
        CoroutineScope(Dispatchers.IO).launch {
            val randomCocktail = getRandomCocktailUseCase.invoke()
            _cocktailFlow.emit(randomCocktail)
        }
    }

}