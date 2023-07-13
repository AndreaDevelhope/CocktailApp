package com.example.cocktailapp.domain.usecase

import com.example.cocktailapp.data.CocktailRepository
import com.example.cocktailapp.domain.models.Cocktail

class GetRandomCocktailUseCase(private val cocktailRepository: CocktailRepository) {

    suspend operator fun invoke(): Cocktail = cocktailRepository.getRandomCocktailFromApi()

}