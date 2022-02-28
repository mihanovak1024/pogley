package com.mihanovak1024.pogley.inventory.data.repository

import com.mihanovak1024.pogley.inventory.domain.model.InventoryItem
import com.mihanovak1024.pogley.inventory.domain.repository.InventoryItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class InventoryItemRepositoryImpl @Inject constructor(

) : InventoryItemRepository {

    private val temporaryList = mutableListOf(InventoryItem("lele123"), InventoryItem("456lele"))

    override fun getInventoryItems(): Flow<List<InventoryItem>> {
        return flowOf(temporaryList)
    }

    override suspend fun addInventoryItem(inventoryItem: InventoryItem) {
        temporaryList.find { it.id == inventoryItem.id }?.let {
            temporaryList.remove(it)
        }
        temporaryList.add(inventoryItem)
    }

}