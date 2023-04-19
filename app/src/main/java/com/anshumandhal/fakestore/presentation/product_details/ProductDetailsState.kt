package com.anshumandhal.fakestore.presentation.product_details

import com.anshumandhal.fakestore.domain.model.Product

data class ProductDetailsState(
    val isLoading: Boolean = false,
    val productDetails: Product? = null,
    val error: String = ""
)
