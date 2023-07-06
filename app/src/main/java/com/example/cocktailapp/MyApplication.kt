package com.example.cocktailapp

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.cocktailapp.ui.CocktailViewModelFactory

class MyApplication : Application() {
    lateinit var preferences: SharedPreferences
    lateinit var cocktailViewModelFactory: CocktailViewModelFactory
    override fun onCreate() {
        super.onCreate()
        preferences = getSharedPreferences("app", Context.MODE_PRIVATE)
        cocktailViewModelFactory = CocktailViewModelFactory(preferences)
    }
}