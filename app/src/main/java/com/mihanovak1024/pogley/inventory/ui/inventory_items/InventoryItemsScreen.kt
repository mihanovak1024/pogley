package com.mihanovak1024.pogley.inventory.ui.inventory_items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mihanovak1024.pogley.R
import com.mihanovak1024.pogley.inventory.domain.InventoryItemEvent
import com.mihanovak1024.pogley.inventory.ui.inventory_items.components.InventoryItemEntry
import timber.log.Timber

@ExperimentalMaterial3Api
@Composable
fun InventoryItemsScreen(
    navController: NavController,
    viewModel: InventoryViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value

    Scaffold(
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        floatingActionButton = {
            FloatingActionButton(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
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
            Text(
                text = stringResource(id = R.string.your_inventory),
                style = MaterialTheme.typography.headlineMedium
            )
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