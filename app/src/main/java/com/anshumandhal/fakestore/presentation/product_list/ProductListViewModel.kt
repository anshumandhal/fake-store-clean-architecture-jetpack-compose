package com.anshumandhal.fakestore.presentation.product_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anshumandhal.fakestore.common.Response
import com.anshumandhal.fakestore.domain.use_case.get_products.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class   ProductListViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    init {
        getProducts()
    }

    private val _state = mutableStateOf(ProductsListState())
    val state: State<ProductsListState> = _state

    private fun getProducts() {
        getProductsUseCase().onEach { response ->  
            when(response) {
                is Response.Success -> {
                    _state.value = ProductsListState(products = response.data ?: emptyList())
                }
                is Response.Error -> {
                    _state.value = ProductsListState(error = response.message ?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}