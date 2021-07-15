package com.example.recipecompose.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.example.recipecompose.R
import com.example.recipecompose.domain.model.Recipe
//import com.example.recipecompose.util.DEFAULT_RECIPE_IMAGE
//import com.example.recipecompose.util.loadPicture

@Composable
fun RecipeCard(
    recipe: Recipe,
    onClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                top = 8.dp,
                bottom = 8.dp
            )
            .fillMaxSize(),
        elevation = 8.dp
    ) {
        Column() {
            recipe.featuredImage?.let { url ->
//                val image =loadPicture(url = url, defaultImage = DEFAULT_RECIPE_IMAGE).value



                Image(
                    bitmap = ImageBitmap.imageResource(id = R.drawable.empty_plate),
                    contentDescription = "Localized description",
                    modifier = Modifier
                        .fillMaxSize()
                        .height(225.dp),
                    contentScale = ContentScale.Crop

                )
            }

            recipe.title?.let { title ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp, top = 12.dp, bottom = 12.dp)
                ) {
                    Text(
                        text = title,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(align = Alignment.Start),
                        style = MaterialTheme.typography.h5
                    )
                    Text(
                        text = recipe.rating.toString(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(align = Alignment.End)
                            .align(alignment = Alignment.CenterVertically),
                        style = MaterialTheme.typography.h6
                    )
                }
            }
        }
    }
}