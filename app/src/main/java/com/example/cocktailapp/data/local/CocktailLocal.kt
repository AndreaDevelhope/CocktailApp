package com.example.cocktailapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cocktails")
data class CocktailLocal(
    @PrimaryKey val strDrink : String
)
