package com.example.cocktailapp.data

import com.example.cocktailapp.data.local.CocktailDao
import com.example.cocktailapp.data.remote.TheCocktailDBAPI
import com.example.cocktailapp.data.remote.toCocktail


class CocktailRepository(
    private val theCocktailDBAPI: TheCocktailDBAPI,
    private val cocktailDao: CocktailDao
) {

    suspend fun getRandomCocktailFromApi() =
        theCocktailDBAPI.getRandomCocktail().drinks[0].toCocktail()
//    } else {
//        cocktailDao.getCocktail()
}




