package com.anshumandhal.fakestore.presentation.product_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anshumandhal.fakestore.common.Response
import com.anshumandhal.fakestore.domain.use_case.get_product_details.GetProductsDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val getProductDetailsUseCase: GetProductsDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {
        savedStateHandle.get<String>("productId")?.let { productId ->
            getProductDetails(productId)
        }
    }

    private val _state = mutableStateOf(ProductDetailsState())
    val state: State<ProductDetailsState> = _state

    private fun getProductDetails(productId: String) {
        getProductDetailsUseCase(productId).onEach { response ->
            when(response) {
                is Response.Success -> {
                    _state.value = ProductDetailsState(productDetails = response.data)
                }
                is Response.Error -> {
                    _state.value = ProductDetailsState(error = response.message ?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}