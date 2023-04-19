package com.anshumandhal.fakestore.data.repository

import com.anshumandhal.fakestore.data.remote.FakeStoreApi
import com.anshumandhal.fakestore.data.remote.dto.ProductDto
import com.anshumandhal.fakestore.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val fakeStoreApi: FakeStoreApi
) : ProductRepository {
    override suspend fun getProducts(): List<ProductDto> {
        return fakeStoreApi.getProducts()
    }

    override suspend fun getProductById(productId: String): ProductDto {
        return fakeStoreApi.getProductById(productId)
    }
}