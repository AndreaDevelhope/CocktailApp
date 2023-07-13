package com.example.cocktailapp.data

import android.content.Context
import androidx.room.Room
import com.example.cocktailapp.data.local.CocktailDao
import com.example.cocktailapp.data.local.CocktailDatabase
import com.example.cocktailapp.data.remote.NetworkManager
import com.example.cocktailapp.data.remote.TheCocktailDBAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/"

object DataDependencyInjection {


    fun inject(appContext: Context) {
        NetworkManager.start(appContext)
        cocktailRepository = CocktailRepository(
            createCocktailAPI(),
            createBeerDao(appContext)
        )

    }

    lateinit var cocktailRepository: CocktailRepository
        private set


    private fun createCocktailAPI(): TheCocktailDBAPI {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(TheCocktailDBAPI::class.java)
    }

    private fun createBeerDao(appContext: Context): CocktailDao {
        val db = Room.databaseBuilder(
            appContext,
            CocktailDatabase::class.java, "database-beer"
        ).build()

        return db.cocktailDao()
    }
}