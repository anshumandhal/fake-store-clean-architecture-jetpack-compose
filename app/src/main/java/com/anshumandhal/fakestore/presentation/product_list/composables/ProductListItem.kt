package com.anshumandhal.fakestore.presentation.product_list.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.anshumandhal.fakestore.domain.model.Product

@Composable
fun ProductListItem(
    product: Product,
    onItemClick: (Product) -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemClick(product) }
        .padding(16.dp)) {

        Box(
            modifier = Modifier
                .height(80.dp)
                .width(80.dp)
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        ) {
            Text(
                text = product.title,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp
                ),
                maxLines = 2
            )
            Text(
                text = "${product.ratingNumber}/5 (${product.ratingCount})",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp
                ),
                maxLines = 1
            )
            Spacer(modifier = Modifier.padding(bottom = 4.dp))
            Text(
                text = (product.price).toString(),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp
                ),
                maxLines = 1
            )

        }

    }

}