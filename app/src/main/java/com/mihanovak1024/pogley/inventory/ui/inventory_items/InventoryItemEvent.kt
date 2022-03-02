package com.mihanovak1024.pogley.inventory.ui.inventory_items

import com.mihanovak1024.pogley.inventory.domain.model.InventoryItem

sealed class InventoryItemEvent {
    data class Delete(val inventoryItem: InventoryItem) : InventoryItemEvent()
}