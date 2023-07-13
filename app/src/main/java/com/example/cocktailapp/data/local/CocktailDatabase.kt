package com.example.cocktailapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CocktailLocal::class], version = 1, exportSchema = false)
abstract class CocktailDatabase : RoomDatabase(){
    abstract fun cocktailDao(): CocktailDao
}