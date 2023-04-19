package com.anshumandhal.fakestore.presentation.favorite_list.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.anshumandhal.fakestore.presentation.ScreenNavigation
import com.anshumandhal.fakestore.presentation.product_list.ProductListViewModel
import com.anshumandhal.fakestore.presentation.product_list.composables.ProductListItem

@Composable
fun FavoriteListScreen(
    navController: NavController,
    productListViewModel: ProductListViewModel = hiltViewModel()
) {

    val state = productListViewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(items = state.products) { product ->
                ProductListItem(
                    product = product,
                    onItemClick = {
                        navController.navigate(ScreenNavigation.ProductDetailScreen.route + "/${product.id}")
                    }
                )

            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .align(Alignment.Center)
            )
        }
    }
}