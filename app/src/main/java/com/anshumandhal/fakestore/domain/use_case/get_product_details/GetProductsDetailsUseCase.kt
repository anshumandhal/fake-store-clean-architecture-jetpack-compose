package com.anshumandhal.fakestore.domain.use_case.get_product_details

import com.anshumandhal.fakestore.common.Response
import com.anshumandhal.fakestore.data.remote.dto.toProduct
import com.anshumandhal.fakestore.domain.model.Product
import com.anshumandhal.fakestore.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetProductsDetailsUseCase @Inject constructor(
    private val repository: ProductRepository
) {

    operator fun invoke(productId: String): Flow<Response<Product>> = flow {
        try {
            val product = repository.getProductById(productId).toProduct()
            emit(Response.Success(product))
        } catch (e: HttpException) {
            emit(
                Response.Error(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(
                Response.Error(
                    e.localizedMessage ?: "Check your internet connection"
                )
            )
        }
    }
}