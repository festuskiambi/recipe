package com.example.recipecompose.repository

import com.example.recipecompose.domain.model.Recipe

interface IRecipeRepository {
    suspend fun search(token: String, page: Int, query: String): List<Recipe>

    suspend fun get(token: String, id: Int): Recipe
}