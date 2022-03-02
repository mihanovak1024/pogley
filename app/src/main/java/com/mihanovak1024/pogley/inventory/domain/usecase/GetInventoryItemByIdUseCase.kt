package com.mihanovak1024.pogley.inventory.domain.usecase

import com.mihanovak1024.pogley.inventory.domain.model.InventoryItem
import com.mihanovak1024.pogley.inventory.domain.repository.InventoryItemRepository

class GetInventoryItemByIdUseCase(
    private val repository: InventoryItemRepository
) {

    suspend operator fun invoke(inventoryItemId: String): InventoryItem? {
        return repository.getInventoryItemById(inventoryItemId)
    }

}