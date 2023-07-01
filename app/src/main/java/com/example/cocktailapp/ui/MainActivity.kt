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
        binding.getCocktail.setOnClickListener {
            textVisibility()
            viewModel.getRandomCocktailFromApi()
        }
        viewModel.cocktailLiveData.observe(this) {
            showDrink(it[0])
        }
    }

    private fun showDrink(cocktail: CocktailDetailsModel) {
        binding.cocktailImage.load(cocktail.cocktailThumbnail)
        binding.cocktailName.text = cocktail.cocktailName
        binding.cocktailIsAlcholic.text = cocktail.cocktailIsAlcoholic
        binding.cocktailRecipeInstructionsIt.text = cocktail.cocktailInstructionsIT
        binding.cocktailIngredientsList.text = cocktail.ingredients.toString()
    }

    private fun textVisibility() {
        if (binding.cocktailIngredientsText.visibility == View.VISIBLE) return
        binding.cocktailIngredientsText.visibility = View.VISIBLE
        binding.cocktailRecipeText.visibility = View.VISIBLE
    }

}