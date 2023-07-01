package com.example.cocktailapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cocktailapp.domain.DomainDependencyInjection

class CocktailViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CocktailViewModel(
            DomainDependencyInjection.getRandomCocktailUseCase
        ) as T
    }
}