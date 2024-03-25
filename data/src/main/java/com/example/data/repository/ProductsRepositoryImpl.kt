package com.example.data.repository

import arrow.core.Either
import com.example.data.mapper.toNetworkError
import com.example.data.remote.ProductsApi
import com.example.domain.model.NetworkError
import com.example.domain.model.Product
import com.example.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val productsApi: ProductsApi
): ProductsRepository {
    override suspend fun getProducts(): Either<NetworkError, List<Product>> {
        return Either.catch {
            productsApi.getProducts()
        }.mapLeft { it.toNetworkError() }
    }
}