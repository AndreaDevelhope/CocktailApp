package com.example.cocktailapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [CocktailLocal::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CocktailDatabase : RoomDatabase(){
    abstract fun cocktailDao(): CocktailDao
}