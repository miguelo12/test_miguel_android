package com.example.data.remote

import com.example.domain.model.Product
import retrofit2.http.GET

interface ProductsApi {
    @GET("products")
    suspend fun getProducts(): List<Product>
}