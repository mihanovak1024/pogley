package com.mihanovak1024.pogley.inventory.ui.inventoryitems

import com.mihanovak1024.pogley.inventory.domain.model.InventoryItem

data class InventoryItemsState(
    val items: List<InventoryItem> = emptyList()
)