package com.example.cocktailapp.data

import com.example.cocktailapp.data.local.CocktailDao
import com.example.cocktailapp.data.local.toCocktail
import com.example.cocktailapp.data.remote.NetworkManager
import com.example.cocktailapp.data.remote.TheCocktailDBAPI
import com.example.cocktailapp.data.remote.toCocktail
import com.example.cocktailapp.data.remote.toCocktailLocal
import com.example.cocktailapp.domain.models.Cocktail


class CocktailRepository(
    private val theCocktailDBAPI: TheCocktailDBAPI,
    private val cocktailDao: CocktailDao
) {

    suspend fun getRandomCocktailFromApi(): Cocktail {
        return if (NetworkManager.isConnected) {
            val cocktailRemote = theCocktailDBAPI.getRandomCocktail().drinks[0]
            val cocktailLocal = cocktailRemote.toCocktailLocal()
            cocktailDao.insertCocktail(cocktailLocal)
            cocktailRemote.toCocktail()
        } else {
            cocktailDao.getCocktail().toCocktail()
        }
    }
}




