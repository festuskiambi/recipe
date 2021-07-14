package com.example.recipecompose.presentation.ui.recipe

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipecompose.domain.model.Recipe
import com.example.recipecompose.repository.IRecipeRepository
import kotlinx.coroutines.launch
import androidx.hilt.lifecycle.ViewModelInject

import javax.inject.Named


