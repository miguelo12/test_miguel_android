package com.example.test_miguel.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.test_miguel.presentation.components.LoadingDialog
import com.example.test_miguel.presentation.screen.product.ProductsViewModel
import com.example.test_miguel.presentation.screen.product.ProductsViewState


@Composable
internal fun HomeScreen(
    modifier: Modifier,
    onNavigateToGo: () -> Unit = {},
    viewModel: ProductsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    LoadingDialog(isLoading = state.isLoading)
    HomeContent(modifier = modifier, state = state)
}

@Composable
fun HomeContent(
    state: ProductsViewState,
    modifier: Modifier
) {
    Row (modifier = modifier) {
        Column {
            Text("a")
        }
    }
}