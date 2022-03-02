package com.mihanovak1024.pogley.inventory.ui.create_edit

sealed class AddInventoryItemEvent {
    data class InsertName(val name: String) : AddInventoryItemEvent()
    data class InsertQuantity(val quantity: String) : AddInventoryItemEvent()
    data class InsertDescription(val description: String) : AddInventoryItemEvent()
    object Save : AddInventoryItemEvent()
}