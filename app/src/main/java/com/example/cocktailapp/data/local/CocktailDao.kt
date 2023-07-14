package com.example.cocktailapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CocktailDao {

    @Query("SELECT * FROM Cocktails ORDER BY RANDOM() LIMIT 1")
    suspend fun getCocktail(): CocktailLocal

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCocktail(vararg cocktails: CocktailLocal)
}