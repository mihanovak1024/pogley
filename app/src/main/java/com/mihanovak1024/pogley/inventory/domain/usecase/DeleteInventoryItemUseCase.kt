package com.mihanovak1024.pogley.inventory.domain.usecase

import com.mihanovak1024.pogley.inventory.domain.model.InventoryItem
import com.mihanovak1024.pogley.inventory.domain.repository.InventoryItemRepository

class DeleteInventoryItemUseCase(
    private val repository: InventoryItemRepository
) {

    suspend operator fun invoke(inventoryItem: InventoryItem) {
        repository.deleteInventoryItem(inventoryItem)
    }

}