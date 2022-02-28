package com.mihanovak1024.pogley.inventory.domain

import com.mihanovak1024.pogley.inventory.domain.model.InventoryItem

sealed class InventoryItemEvent {
    data class Delete(val inventoryItem: InventoryItem) : InventoryItemEvent()
}