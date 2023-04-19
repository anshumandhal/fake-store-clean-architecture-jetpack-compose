package com.anshumandhal.fakestore.data.remote.dto


import com.anshumandhal.fakestore.domain.model.Product
import com.google.gson.annotations.SerializedName

data class ProductDto(
    @SerializedName("category")
    val category: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("rating")
    val rating: Rating,
    @SerializedName("title")
    val title: String
)

fun ProductDto.toProduct(): Product {
    return Product(
        category = category,
        description = description,
        id = id,
        image = image,
        price = price,
        title = title,
        ratingCount = rating.count,
        ratingNumber = rating.rate
    )
}






