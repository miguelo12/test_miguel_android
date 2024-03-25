package com.example.test_miguel.presentation.screen.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.test_miguel.presentation.components.LoadingDialog
import com.example.test_miguel.presentation.screen.product.components.ProductCard

@Composable
internal fun ProductsScreen(
    modifier: Modifier,
    onNavigateToGo: () -> Unit = {},
    viewModel: ProductsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    LoadingDialog(isLoading = state.isLoading)
    ProductsContent(modifier = modifier, state = state)
}

@Composable
fun ProductsContent(
    state: ProductsViewState,
    modifier: Modifier
) {
    LazyVerticalStaggeredGrid(
        modifier = modifier,
        columns = StaggeredGridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalItemSpacing = 10.dp
    ) {
        items(state.products) {product ->
            ProductCard(product = product)
        }
    }
}