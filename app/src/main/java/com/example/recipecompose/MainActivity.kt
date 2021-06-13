package com.example.recipecompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(color = Color(0xFFF2F2F2))
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())


            ) {
                Image(
                    bitmap = ImageBitmap
                        .imageResource(
                            id = R.drawable.happy_meal
                        ),
                    modifier = Modifier.height(300.dp),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Localized description"

                )

                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Happy Meal",
                            fontSize = 26.sp
                        )
                        Text(
                            text = "Kes 1000",
                            fontSize = 16.sp,
                            color = Color.Green,
                            modifier = Modifier.align(alignment = Alignment.CenterVertically)
                        )
                    }

                    Spacer(modifier = Modifier.padding(top = 10.dp))
                    Text(
                        text = "800 Calories",
                        fontSize = 17.sp
                    )
                    Spacer(modifier = Modifier.padding(top = 10.dp))

                    Button(
                        onClick = {  },
                        modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                    ) {
                        Text(text = "Order Now")
                    }

                }
            }
        }
    }
}