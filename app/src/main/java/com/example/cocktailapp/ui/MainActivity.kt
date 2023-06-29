package com.example.cocktailapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import coil.api.load
import com.example.cocktailapp.data.Drink
import com.example.cocktailapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: DrinkViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[DrinkViewModel::class.java]
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.getDrink.setOnClickListener {
            viewModel.getRandomDrinkFromApi()
        }
        viewModel.drinkLiveData.observe(this) {
            showDrink(it.drinks[0])
        }
    }

    private fun showDrink(drink: Drink) {
        binding.drinkImage.load(drink.strDrinkThumb)
        binding.drinkName.text = drink.strDrink
        binding.drinkIsAlcholic.text = drink.strAlcoholic
        binding.drinkInstructionsIt.text = drink.strInstructionsIT
    }

}