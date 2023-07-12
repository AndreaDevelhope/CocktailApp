package com.example.cocktailapp.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import coil.api.load
import com.example.cocktailapp.MyApplication
import com.example.cocktailapp.R
import com.example.cocktailapp.databinding.ActivityMainBinding
import com.example.cocktailapp.domain.models.Cocktail
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CocktailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            (application as MyApplication).cocktailViewModelFactory.create(CocktailViewModel::class.java)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.getCocktail.setOnClickListener {
            textVisibility()
            viewModel.getRandomCocktailFromApi()
        }
        lifecycleScope.launch {
            viewModel.cocktailFlow.collect {
                showDrink(it)
                Log.d("MainActivity", "$it")
            }
        }

        viewModel.firstTimeUserLiveData.observe(this) {
            showWelcomeText(it)
            Log.d("MainActivity", "$it")
        }

    }

    private fun showDrink(cocktail: Cocktail) {
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
        binding.welcomeText.visibility = View.GONE
    }

    private fun showWelcomeText(firstTimeUser: Boolean) {
        if (firstTimeUser) {
            binding.welcomeText.text = getString(R.string.welcome_text_first_time)
            Snackbar.make(
                binding.getCocktail,
                getString(R.string.click_the_button),
                Snackbar.LENGTH_LONG
            ).show()
        } else {
            binding.welcomeText.text = getString(R.string.welcome_text)
        }
    }

}