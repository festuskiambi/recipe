package com.example.recipecompose.presentation.ui.recipe_list

import android.graphics.drawable.Icon
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.*
import androidx.compose.material.TextFieldDefaults.textFieldColors
import androidx.compose.ui.ExperimentalComposeUiApi

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.recipecompose.presentation.composables.RecipeCard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class RecipeListFragment: Fragment() {

    private val viewModel: RecipeListViewModel by viewModels()

    @ExperimentalComposeUiApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                val recipes = viewModel.recipes.value

                val query = viewModel.query.value
                val keyboardController = LocalSoftwareKeyboardController.current


                Column {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth(),
                        color = MaterialTheme.colors.primary,
                        elevation = 10.dp
                    ) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            TextField(
                                modifier = Modifier
                                    .fillMaxWidth(.9f)
                                    .padding(8.dp),
                                value = query,
                                onValueChange = {newValue ->
                                    viewModel.onQueryChanged(newValue)
                                },
                                label = {
                                    Text(text = "Search")
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text,
                                    imeAction = ImeAction.Search,
                                ),
                                keyboardActions = KeyboardActions(onSearch = {
                                    viewModel.newSearch(query)
                                    keyboardController?.hide()
                                }),
                                leadingIcon = {
                                    Icon(Icons.Filled.Search,"Search icon")
                                },
                                textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
                                colors = textFieldColors(backgroundColor = MaterialTheme.colors.surface)
                                )

                        }
                    }
                    LazyColumn{
                        itemsIndexed(
                            items = recipes
                        ){index, recipe ->
                            RecipeCard(recipe = recipe, onClick = {})
                        }
                    }
                }

            }
        }
    }

}