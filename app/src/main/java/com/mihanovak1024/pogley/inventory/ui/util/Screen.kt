package com.mihanovak1024.pogley.inventory.ui.util

sealed class Screen(private val route: String) {

    object InventoryItemsScreen : Screen("inventory_items_screen")
    object CreateEditInventoryItemScreen : Screen("create_edit_inventory_items_screen")

    fun getRouteDefinition(vararg arguments: String): String {
        return if (arguments.isEmpty()) {
            route
        } else {
            route + "?" + arguments.joinToString(separator = "&") { "$it={$it}" }
        }
    }

    fun getRoute(vararg arguments: Pair<String, String>): String {
        return if (arguments.isEmpty()) {
            route
        } else {
            route + "?" + arguments.joinToString(separator = "&") { "${it.first}=${it.second}" }
        }
    }
}