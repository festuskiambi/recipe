package com.example.recipecompose.network.repository

import com.example.recipecompose.domain.model.Recipe
import com.example.recipecompose.network.RecipeService
import com.example.recipecompose.network.model.RecipeDtoMapper

class RecipeRepositoryImpl(
    private val service: RecipeService,
    private val mapper: RecipeDtoMapper
) : IRecipeRepository {
    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(
            service.search(
                token = token,
                page = page,
                query = query
            ).recipes
        )
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(service.get(token = token, id))
    }
}