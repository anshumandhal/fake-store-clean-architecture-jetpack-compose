package com.anshumandhal.fakestore.presentation.product_details.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.anshumandhal.fakestore.presentation.product_details.ProductDetailsViewModel

@Composable
fun ProductDetailScreen(
    viewModel: ProductDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    state.productDetails?.let { product ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
                    .height(250.dp)
            ) {
                AsyncImage(
                    model = product.image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.padding(bottom = 8.dp))
            Text(
                text = product.title,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
                maxLines = 2
            )
            Text(
                text = "${product.ratingNumber}/5 (${product.ratingCount})",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp
                ),
                maxLines = 1
            )
            Spacer(modifier = Modifier.padding(bottom = 4.dp))
            Text(
                text = "$ ${product.price}",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp
                ),
                maxLines = 1
            )
            Spacer(modifier = Modifier.padding(bottom = 8.dp))
            Text(
                text = (product.description),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp
                )
            )
            Spacer(modifier = Modifier.padding(bottom = 8.dp))
            Text(
                text = (product.category),
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )
            )
        }
    }
}