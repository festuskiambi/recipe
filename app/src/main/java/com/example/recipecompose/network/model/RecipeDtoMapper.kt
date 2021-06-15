package com.example.recipecompose.network.model

import com.example.recipecompose.domain.model.Recipe
import com.example.recipecompose.domain.util.DomainMapper

class RecipeDtoMapper : DomainMapper<RecipeDto, Recipe> {
    override fun mapToDomainModel(model: RecipeDto): Recipe {
        return Recipe(
            id = model.pk,
            title = model.title,
            featuredImage = model.featuredImage,
            publisher = model.publisher,
            rating = model.rating,
            sourceUrl = model.sourceUrl,
            description = model.description,
            cookingInstructions = model.cookingInstructions,
            dateAdded = model.dateAdded,
            ingredients = model.ingredients ?: listOf(),
            dateUpdated = model.dateUpdated
        )
    }

    override fun mapFromDomainModel(domainModel: Recipe): RecipeDto {
        return RecipeDto(
            pk = domainModel.id,
            title = domainModel.title,
            featuredImage = domainModel.featuredImage,
            publisher = domainModel.publisher,
            rating = domainModel.rating,
            sourceUrl = domainModel.sourceUrl,
            description = domainModel.description,
            cookingInstructions = domainModel.cookingInstructions,
            dateAdded = domainModel.dateAdded,
            ingredients = domainModel.ingredients,
            dateUpdated = domainModel.dateUpdated
        )
    }
}