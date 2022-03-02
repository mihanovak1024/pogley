package com.mihanovak1024.pogley.inventory.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mihanovak1024.pogley.inventory.ui.create_edit.CreateEditInventoryItemScreen
import com.mihanovak1024.pogley.inventory.ui.inventory_items.InventoryItemsScreen
import com.mihanovak1024.pogley.inventory.ui.util.Screen.CreateEditInventoryItemScreen
import com.mihanovak1024.pogley.inventory.ui.util.Screen.InventoryItemsScreen
import com.mihanovak1024.pogley.ui.theme.PogleyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    companion object {
        const val NAVIGATION_ARGUMENT_INVENTORY_ITEM_ID = "inventoryItemId"
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PogleyTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = InventoryItemsScreen.getRouteDefinition()
                    ) {
                        composable(route = InventoryItemsScreen.getRouteDefinition()) {
                            InventoryItemsScreen(
                                navController = navController
                            )
                        }
                        composable(
                            route = CreateEditInventoryItemScreen.getRouteDefinition(NAVIGATION_ARGUMENT_INVENTORY_ITEM_ID),
                            arguments = listOf(
                                navArgument(name = NAVIGATION_ARGUMENT_INVENTORY_ITEM_ID) {
                                    type = NavType.StringType
                                    defaultValue = ""
                                }
                            )
                        ) {
                            CreateEditInventoryItemScreen(
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}