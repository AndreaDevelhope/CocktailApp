package com.example.cocktailapp.ui

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    private val _firstTimeUserLiveData = MutableSharedFlow<Boolean>(1)
    val firstTimeUserLiveData:  SharedFlow<Boolean> = _firstTimeUserLiveData

    init {
        checkFirstTimeUser(preferences)
    }

    private fun checkFirstTimeUser(preferences: SharedPreferences) {
        val firstTimeUser = preferences.getBoolean(KEY_FIRST_TIME_USER, true)
        if (firstTimeUser){
            preferences.edit().putBoolean(KEY_FIRST_TIME_USER,false).apply()
            viewModelScope.launch {

            _firstTimeUserLiveData.emit(true)
            }
            return
        }
        viewModelScope.launch {

        _firstTimeUserLiveData.emit(false)
        }
    }

    fun getRandomCocktailFromApi() {
        CoroutineScope(Dispatchers.IO).launch {
            val randomCocktail = getRandomCocktailUseCase.invoke()
            _cocktailFlow.emit(randomCocktail)
        }
    }

}