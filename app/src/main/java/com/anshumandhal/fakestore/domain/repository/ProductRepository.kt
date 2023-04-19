package com.anshumandhal.fakestore.domain.repository

import com.anshumandhal.fakestore.data.remote.dto.ProductDto

interface ProductRepository {

    suspend fun getProducts() : List<ProductDto>

    suspend fun getProductById(productId: String) : ProductDto


}