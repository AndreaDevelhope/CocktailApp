package com.example.cocktailapp.ui

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cocktailapp.domain.DomainDependencyInjection

class CocktailViewModelFactory(private val preferences: SharedPreferences) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CocktailViewModel(
            DomainDependencyInjection.getRandomCocktailUseCase ,preferences
        ) as T
    }
}