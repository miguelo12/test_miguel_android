package com.example.test_miguel.presentation.components.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.test_miguel.presentation.components.TestTopAppBar
import com.example.test_miguel.presentation.screen.home.HomeScreen
import com.example.test_miguel.presentation.screen.product.ProductsScreen

@Composable
fun AppNavigationHost(navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = AppNavigationBarItems.Home.route,
    ) {
        homeGraph(navController, modifier)
        productGraph(navController, modifier)
    }
}


fun NavGraphBuilder.homeGraph(navController: NavHostController, modifier: Modifier) {
    navigation(startDestination = "home1", route = AppNavigationBarItems.Home.route) {
        composable("home1") {
            Scaffold(
                bottomBar = { AppNavigationBar(navController = navController) } ,
                content = { HomeScreen(modifier = modifier.padding(it)) }
            )
        }
        //composable("home1") {
        //    HomeScreen(modifier = modifier, onNavigateToGo = {
        //        navController.navigate("home2")
        //    })
        //}
        //composable("home2") {
        //    ProductsScreen(modifier = modifier)
        //}
    }
}

fun NavGraphBuilder.productGraph(navController: NavHostController, modifier: Modifier) {
    navigation(startDestination = "product1", route = AppNavigationBarItems.Pages.route) {
        composable("product1") {
            Scaffold(
                topBar = {
                    TestTopAppBar(title = "Products")
                },
                content = { ProductsScreen(modifier = modifier.padding(it)) }
            )
        }
    }
}