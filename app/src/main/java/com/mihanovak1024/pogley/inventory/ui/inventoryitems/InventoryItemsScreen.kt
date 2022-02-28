package com.mihanovak1024.pogley.inventory.ui.inventoryitems

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mihanovak1024.pogley.inventory.domain.InventoryItemEvent
import com.mihanovak1024.pogley.inventory.ui.inventoryitems.components.InventoryItemEntry
import timber.log.Timber

// TODO: update hilt view model after navigation is implemented
@Composable
fun InventoryItemsScreen(
    navController: NavController,
    viewModel: InventoryViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = MaterialTheme.colors.primary,
                onClick = { /*TODO during addScreen implementation*/ }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add new")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Text(text = "InventoryItemsList")
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                items(state.items) { item ->
                    InventoryItemEntry(
                        inventoryItem = item,
                        onDeleteClick = {
                            Timber.d("onDeleteClicked")
                            viewModel.onEvent(InventoryItemEvent.Delete(item))
                        }
                    )
                }
            }
        }
    }
}