package com.mihanovak1024.pogley.inventory.domain.usecase

import com.mihanovak1024.pogley.inventory.domain.model.InventoryItem
import com.mihanovak1024.pogley.inventory.domain.repository.InventoryItemRepository
import kotlinx.coroutines.flow.Flow

class GetInventoryItemsUseCase(
    private val inventoryItemRepository: InventoryItemRepository
) {

    operator fun invoke(): Flow<List<InventoryItem>> {
        return inventoryItemRepository.getInventoryItems()
    }
}