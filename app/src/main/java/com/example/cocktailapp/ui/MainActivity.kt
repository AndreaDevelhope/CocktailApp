package com.example.cocktailapp.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import coil.api.load
import com.example.cocktailapp.databinding.ActivityMainBinding
import com.example.cocktailapp.domain.models.CocktailDetailsModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CocktailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, CocktailViewModelFactory())[CocktailViewModel::class.java]
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.getDrink.setOnClickListener {
            textVisibility()
            viewModel.getRandomCocktailFromApi()
        }
        viewModel.cocktailLiveData.observe(this) {
            showDrink(it[0])
        }
    }

    private fun showDrink(cocktail: CocktailDetailsModel) {
        binding.drinkImage.load(cocktail.cocktailThumbnail)
        binding.drinkName.text = cocktail.cocktailName
        binding.drinkIsAlcholic.text = cocktail.cocktailIsAlcoholic
        binding.recipeInstructionsIt.text = cocktail.cocktailInstructionsIT
        binding.ingredientsList.text = cocktail.ingredients.toString()
    }

    private fun textVisibility() {
        if (binding.ingredientsText.visibility == View.VISIBLE) return
        binding.ingredientsText.visibility = View.VISIBLE
        binding.recipeText.visibility = View.VISIBLE
    }

}