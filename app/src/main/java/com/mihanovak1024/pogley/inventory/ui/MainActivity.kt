package com.mihanovak1024.pogley.inventory.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mihanovak1024.pogley.inventory.ui.inventoryitems.InventoryItemsScreen
import com.mihanovak1024.pogley.inventory.ui.util.Screen
import com.mihanovak1024.pogley.ui.theme.PogleyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

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
                    }

                }
            }
        }
    }
}