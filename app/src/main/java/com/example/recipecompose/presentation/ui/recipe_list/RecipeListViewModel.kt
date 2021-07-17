package com.example.recipecompose.presentation.ui.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipecompose.domain.model.Recipe
import com.example.recipecompose.repository.IRecipeRepository
import kotlinx.coroutines.launch
import javax.inject.Named

class RecipeListViewModel
@ViewModelInject
constructor(
    private val repository: IRecipeRepository,
    @Named("auth_token")
    private val token: String,
) : ViewModel() {

    val recipes: MutableState<List<Recipe>> = mutableStateOf(ArrayList())
    val query: MutableState<String> = mutableStateOf("Chicken")

    init {
        newSearch("")
    }

   fun newSearch(query: String) {
        viewModelScope.launch {
            val result = repository.search(
                token = token,
                page = 1,
                query = query
            )
            recipes.value = result
        }
    }

    fun onQueryChanged(query: String) {
        this.query.value = query
    }

}