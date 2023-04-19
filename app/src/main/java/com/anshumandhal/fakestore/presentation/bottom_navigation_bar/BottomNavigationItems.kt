package com.anshumandhal.fakestore.presentation.bottom_navigation_bar

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItems(
    val name: String,
    val route: String,
    val icon: ImageVector,
    val badgeCount: Int = 0
)
