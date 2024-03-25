package com.example.test_miguel.presentation.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppNavigationBarItems(val route: String, val label: String, val icon: ImageVector) {
    data object Home : AppNavigationBarItems("home", "Home", Icons.Filled.Home)
    data object Pages : AppNavigationBarItems("product", "Products", Icons.Filled.ShoppingCart)
}