package com.example.cocktailapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import coil.api.load
import com.example.cocktailapp.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val cocktailService = retrofit.create(CocktailService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.getDrink.setOnClickListener {
            getDrinksApi()
        }
    }

    private fun showDrink(randomCocktail: Drink){
        binding.drinkInstructionsIt.text = randomCocktail.strInstructionsIT
        binding.drinkName.text = randomCocktail.strDrink
        binding.drinkIsAlcholic.text = randomCocktail.strAlcoholic
        binding.drinkImage.load(randomCocktail.strDrinkThumb)
    }

    private fun getDrinksApi(){
        lifecycleScope.launch {
            val randomCocktail = cocktailService.getRandomCocktail()
            showDrink(randomCocktail.drinks[0])
        }
    }
}