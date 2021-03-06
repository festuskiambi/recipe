package com.example.recipecompose.network.responses

import com.example.recipecompose.network.model.RecipeDto
import com.google.gson.annotations.SerializedName

class RecipeSearchResponse(

    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var recipes: List<RecipeDto>,
)