package com.example.recipecompose.di

import com.example.recipecompose.network.RecipeService
import com.example.recipecompose.network.model.RecipeDtoMapper
import com.example.recipecompose.repository.IRecipeRepository
import com.example.recipecompose.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeMapper: RecipeDtoMapper,
    ): IRecipeRepository {
        return RecipeRepositoryImpl(
            service = recipeService,
            mapper = recipeMapper
        )
    }
}