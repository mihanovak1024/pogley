package com.mihanovak1024.pogley.inventory.domain.usecase

import com.mihanovak1024.pogley.inventory.domain.model.InventoryItem
import com.mihanovak1024.pogley.inventory.domain.repository.InventoryItemRepository

class AddInventoryItemUseCase(
    private val inventoryItemRepository: InventoryItemRepository
) {

    suspend operator fun invoke(inventoryItem: InventoryItem) {
        inventoryItemRepository.addInventoryItem(inventoryItem)
    }
}