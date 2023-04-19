package com.anshumandhal.fakestore

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Shop
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.anshumandhal.delete.ui.theme.FakeStoreCleanArchitectureTheme
import com.anshumandhal.fakestore.presentation.ScreenNavigation
import com.anshumandhal.fakestore.presentation.bottom_navigation_bar.BottomNavigationItems
import com.anshumandhal.fakestore.presentation.bottom_navigation_bar.composables.BottomNavigationBar
import com.anshumandhal.fakestore.presentation.favorite_list.composables.FavoriteListScreen
import com.anshumandhal.fakestore.presentation.product_details.composables.ProductDetailScreen
import com.anshumandhal.fakestore.presentation.product_list.composables.ProductListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FakeStoreCleanArchitectureTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavigationItems(
                                    name = "Products",
                                    route = "product_list_screen",
                                    icon = Icons.Default.Shop
                                ),
                                BottomNavigationItems(
                                    name = "Favorites",
                                    route = "favorite_list_screen",
                                    icon = Icons.Default.Favorite
                                )
                            ),
                            navController = navController
                        ) {
                            navController.navigate(it.route)
                        }
                    }
                ) {
                    Navigation(navController = navController )
                }

            }
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreenNavigation.ProductListScreen.route
    ) {
        composable(
            route  = ScreenNavigation.ProductListScreen.route
        ) {
            ProductListScreen(navController = navController)
        }
        composable(
            route  = ScreenNavigation.ProductDetailScreen.route + "/{productId}"
        ) {
            ProductDetailScreen()
        }
        composable(
            route  = ScreenNavigation.FavoriteListScreen.route
        ) {
            FavoriteListScreen(navController = navController)
        }
    }
}

