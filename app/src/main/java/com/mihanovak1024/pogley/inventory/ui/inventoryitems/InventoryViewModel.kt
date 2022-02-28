package com.mihanovak1024.pogley.inventory.ui.inventoryitems

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mihanovak1024.pogley.inventory.domain.usecase.InventoryItemUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class InventoryViewModel @Inject constructor(
    private val inventoryItemUseCases: InventoryItemUseCases
) : ViewModel() {

    private val _state = mutableStateOf(InventoryItemsState())
    val state: State<InventoryItemsState> = _state

    private var getInventoryItemsJob: Job? = null

    init {
        getInventoryItems()
    }

    private fun getInventoryItems() {
        // TODO: try to optimise this
        getInventoryItemsJob?.cancel()
        getInventoryItemsJob = inventoryItemUseCases.getInventoryItems()
            .onEach { items ->
                _state.value = state.value.copy(
                    items = items
                )
            }
            .launchIn(viewModelScope)
    }
}