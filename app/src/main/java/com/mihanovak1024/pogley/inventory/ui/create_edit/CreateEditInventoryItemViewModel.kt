package com.mihanovak1024.pogley.inventory.ui.create_edit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mihanovak1024.pogley.R
import com.mihanovak1024.pogley.inventory.domain.model.InventoryItem
import com.mihanovak1024.pogley.inventory.domain.usecase.InventoryItemUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CreateEditInventoryItemViewModel @Inject constructor(
    private val inventoryItemUseCases: InventoryItemUseCases
) : ViewModel() {

    private val _name = mutableStateOf(
        InventoryItemTextFieldState(
            hintStringId = R.string.insert_name
        )
    )
    val name: State<InventoryItemTextFieldState> = _name

    private val _quantity = mutableStateOf(
        InventoryItemTextFieldState(
            hintStringId = R.string.insert_quantity
        )
    )
    val quantity: State<InventoryItemTextFieldState> = _quantity

    private val _description = mutableStateOf(
        InventoryItemTextFieldState(
            hintStringId = R.string.insert_description
        )
    )
    val description: State<InventoryItemTextFieldState> = _description

    val isExistingInventoryItem = mutableStateOf(false)

    // TODO: populate this from navigation route InvetnoryItemId query param
    private var editedInventoryItemId: String? = null
        set(value) {
            isExistingInventoryItem.value = value != null
            field = value
        }

    fun onEvent(event: AddInventoryItemEvent) {
        when (event) {
            is AddInventoryItemEvent.InsertName -> _name.value = name.value.copy(
                text = event.name
            )
            is AddInventoryItemEvent.InsertQuantity -> _quantity.value = quantity.value.copy(
                text = event.quantity
            )
            is AddInventoryItemEvent.InsertDescription -> _description.value = description.value.copy(
                text = event.description
            )
            is AddInventoryItemEvent.Save -> {
                if (_name.value.text.isNotEmpty() &&
                    _description.value.text.isNotEmpty() &&
                    _quantity.value.text.isNotEmpty()
                ) {
                    Timber.d("Saved")
                    viewModelScope.launch {
                        inventoryItemUseCases.addInventoryItem(
                            InventoryItem(
                                id = editedInventoryItemId ?: createUniqueId(),
                                name = _name.value.text,
                                quantity = _quantity.value.text.toInt(),
                                description = _description.value.text
                            )
                        )
                    }
                } else {
                    Timber.d("Not saved")
                }
            }
        }
    }

    // TODO: temporary, later on Database will generate one itself
    private fun createUniqueId(): String = "${System.currentTimeMillis()}"

}