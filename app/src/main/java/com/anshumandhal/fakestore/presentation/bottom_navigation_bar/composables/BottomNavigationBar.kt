package com.anshumandhal.fakestore.presentation.bottom_navigation_bar.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.anshumandhal.fakestore.presentation.bottom_navigation_bar.BottomNavigationItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationItems>,
    navController: NavController,
    onItemCLick: (BottomNavigationItems) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    NavigationBar {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            NavigationBarItem(selected = selected,
                onClick = {
                    onItemCLick(item)
                },
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        if (item.badgeCount > 0) {
                            BadgedBox(badge = {
                                Text(text = item.badgeCount.toString())
                            } ) {
                                Icon(imageVector = item.icon , contentDescription = null )
                            }
                        } else {
                            Icon(imageVector = item.icon , contentDescription = null )
                        }
                        if (selected) {
                            Text(text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            )
        }
    }

}

