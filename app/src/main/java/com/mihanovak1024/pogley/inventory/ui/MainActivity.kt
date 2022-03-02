package com.mihanovak1024.pogley.inventory.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mihanovak1024.pogley.inventory.ui.create_edit.CreateEditInventoryItemScreen
import com.mihanovak1024.pogley.inventory.ui.inventory_items.InventoryItemsScreen
import com.mihanovak1024.pogley.inventory.ui.util.Screen
import com.mihanovak1024.pogley.ui.theme.PogleyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

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
                        startDestination = Screen.InventoryItemsScreen.route
                    ) {
                        composable(route = Screen.InventoryItemsScreen.route) {
                            InventoryItemsScreen(
                                navController = navController
                            )
                        }
                        composable(route = Screen.CreateEditInventoryItemScreen.route) {
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