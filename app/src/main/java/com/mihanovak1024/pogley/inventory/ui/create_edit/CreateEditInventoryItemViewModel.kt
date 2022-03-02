package com.mihanovak1024.pogley.inventory.ui.create_edit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mihanovak1024.pogley.R
import com.mihanovak1024.pogley.inventory.domain.model.InventoryItem
import com.mihanovak1024.pogley.inventory.domain.usecase.InventoryItemUseCases
import com.mihanovak1024.pogley.inventory.ui.MainActivity
import com.mihanovak1024.pogley.inventory.ui.create_edit.InventoryItemTextFieldState.InventoryItemNumberFieldState
import com.mihanovak1024.pogley.inventory.ui.create_edit.InventoryItemTextFieldState.InventoryItemStringFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateEditInventoryItemViewModel @Inject constructor(
    private val inventoryItemUseCases: InventoryItemUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _name = mutableStateOf(
        InventoryItemStringFieldState(
            hintId = R.string.insert_name
        )
    )
    val name: State<InventoryItemStringFieldState> = _name

    private val _quantity = mutableStateOf(
        InventoryItemNumberFieldState(
            hintId = R.string.insert_quantity
        )
    )
    val quantity: State<InventoryItemNumberFieldState> = _quantity

    private val _description = mutableStateOf(
        InventoryItemStringFieldState(
            hintId = R.string.insert_description
        )
    )
    val description: State<InventoryItemStringFieldState> = _description

    val isExistingInventoryItem = mutableStateOf(false)

    private val _addInventoryItemEvents = MutableSharedFlow<SaveInventoryItemEvents>()
    val addInventoryItemEvents = _addInventoryItemEvents.asSharedFlow()

    private var editedInventoryItemId: String? = null
        set(value) {
            isExistingInventoryItem.value = value != null
            field = value
        }

    init {
        savedStateHandle.get<String>(MainActivity.NAVIGATION_ARGUMENT_INVENTORY_ITEM_ID)?.let {
            if (it.isNotEmpty()) {
                viewModelScope.launch {
                    val inventoryItem = inventoryItemUseCases.getInventoryItemById(it)
                    if (inventoryItem != null) {
                        editedInventoryItemId = inventoryItem.id
                        _name.value = name.value.copy(
                            text = inventoryItem.name
                        )
                        _description.value = description.value.copy(
                            text = inventoryItem.description
                        )
                        _quantity.value = quantity.value.copy(
                            number = inventoryItem.quantity
                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: AddInventoryItemEvent) {
        when (event) {
            is AddInventoryItemEvent.InsertName -> _name.value = name.value.copy(
                text = event.name
            )
            is AddInventoryItemEvent.InsertQuantity -> _quantity.value = quantity.value.copy(
                number = event.quantity
            )
            is AddInventoryItemEvent.InsertDescription -> _description.value = description.value.copy(
                text = event.description
            )
            is AddInventoryItemEvent.Save -> {
                viewModelScope.launch {
                    if (_name.value.isValueValid &&
                        _description.value.isValueValid &&
                        _quantity.value.isValueValid
                    ) {
                        inventoryItemUseCases.addInventoryItem(
                            InventoryItem(
                                id = editedInventoryItemId ?: createUniqueId(),
                                name = _name.value.text,
                                quantity = _quantity.value.number,
                                description = _description.value.text
                            )
                        )
                        _addInventoryItemEvents.emit(SaveInventoryItemEvents.Saved)
                    } else {
                        _addInventoryItemEvents.emit(SaveInventoryItemEvents.NotSaved("Something went wrong"))
                    }
                }
            }
        }
    }

    // TODO: temporary, later on Database will generate one itself
    private fun createUniqueId(): String = "${System.currentTimeMillis()}"

}

sealed class SaveInventoryItemEvents {
    object Saved : SaveInventoryItemEvents()
    class NotSaved(val message: String) : SaveInventoryItemEvents()
}