package com.anshumandhal.fakestore.presentation.product_list

import com.anshumandhal.fakestore.domain.model.Product

data class ProductsListState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String = ""

)
