package com.mihanovak1024.pogley.inventory.ui.util

sealed class Screen(val route: String) {
    object InventoryItemsScreen : Screen("inventory_items_screen")
}