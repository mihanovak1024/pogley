package com.mihanovak1024.pogley.inventory.domain.model

data class InventoryItem(
    val id: String,
    val name: String,
    val quantity: Int,
    val description: String = ""
)