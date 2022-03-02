package com.mihanovak1024.pogley.inventory.domain.usecase

data class InventoryItemUseCases(
    val getInventoryItems: GetInventoryItemsUseCase,
    val getInventoryItemById: GetInventoryItemByIdUseCase,
    val addInventoryItem: AddInventoryItemUseCase,
    val deleteInventoryItem: DeleteInventoryItemUseCase,
)