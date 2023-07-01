package com.example.cocktailapp.domain

import com.example.cocktailapp.data.DataDependencyInjection
import com.example.cocktailapp.domain.usecase.GetRandomCocktailUseCase

object DomainDependencyInjection {
    val getRandomCocktailUseCase = GetRandomCocktailUseCase(DataDependencyInjection.cocktailRepository)
}