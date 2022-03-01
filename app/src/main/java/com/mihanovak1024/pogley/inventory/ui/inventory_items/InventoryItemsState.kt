package com.mihanovak1024.pogley.inventory.ui.inventory_items

import com.mihanovak1024.pogley.inventory.domain.model.InventoryItem

data class InventoryItemsState(
    val items: List<InventoryItem> = emptyList()
)