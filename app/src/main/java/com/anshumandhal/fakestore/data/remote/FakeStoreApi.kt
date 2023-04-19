package com.anshumandhal.fakestore.data.remote

import com.anshumandhal.fakestore.data.remote.dto.ProductDto
import retrofit2.http.GET
import retrofit2.http.Path

interface FakeStoreApi {


    @GET("/products")
    suspend fun getProducts() : List<ProductDto>

    @GET("/products/{productId}")
    suspend fun getProductById(@Path("productId") productId : String) : ProductDto
}