package com.anshumandhal.fakestore.domain.use_case.get_products

import com.anshumandhal.fakestore.common.Response
import com.anshumandhal.fakestore.data.remote.dto.toProduct
import com.anshumandhal.fakestore.domain.model.Product
import com.anshumandhal.fakestore.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {

    operator fun invoke(): Flow<Response<List<Product>>> = flow {
        try {
            val products = repository.getProducts().map {
                it.toProduct()
            }
            emit(Response.Success(products))
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