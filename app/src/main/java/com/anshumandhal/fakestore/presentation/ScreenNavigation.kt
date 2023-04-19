package com.anshumandhal.fakestore.presentation

sealed class ScreenNavigation(val route: String) {
    object ProductListScreen : ScreenNavigation("product_list_screen")
    object ProductDetailScreen : ScreenNavigation("product_detail_screen")
    object FavoriteListScreen : ScreenNavigation("favorite_list_screen")
}
