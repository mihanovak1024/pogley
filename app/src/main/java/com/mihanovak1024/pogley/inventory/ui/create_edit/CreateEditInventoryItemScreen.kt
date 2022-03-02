package com.mihanovak1024.pogley.inventory.ui.create_edit

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mihanovak1024.pogley.R
import com.mihanovak1024.pogley.inventory.ui.create_edit.components.PogleyEditNumber
import com.mihanovak1024.pogley.inventory.ui.create_edit.components.PogleyEditText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateEditInventoryItemScreen(
    navController: NavController,
    viewModel: CreateEditInventoryItemViewModel = hiltViewModel(),
) {

    val nameState = viewModel.name
    val quantityState = viewModel.quantity
    val descriptionState = viewModel.description

    val isExistingInventoryItem = viewModel.isExistingInventoryItem

    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    // TODO: navigate back
                    viewModel.onEvent(AddInventoryItemEvent.Save)
                },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                text = { Text(text = stringResource(id = R.string.save_inventory_item), style = MaterialTheme.typography.labelLarge) },
                icon = { Icon(Icons.Filled.Save, "Save") },
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            val titleResourceId = if (isExistingInventoryItem.value) R.string.edit_inventory_item else R.string.new_inventory_item
            Text(
                text = stringResource(id = titleResourceId),
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp)
            ) {
                PogleyEditText(
                    value = nameState.value.text,
                    onValueChanged = { name: String -> viewModel.onEvent(AddInventoryItemEvent.InsertName(name)) },
                    hint = stringResource(id = nameState.value.hintStringId),
                    shouldShowHint = nameState.value.shouldShowHint,
                    modifier = Modifier
                        .weight(2f)
                )
                Spacer(modifier = Modifier.width(10.dp))
                PogleyEditNumber(
                    value = quantityState.value.number,
                    onValueChanged = { quantity: Int -> viewModel.onEvent(AddInventoryItemEvent.InsertQuantity(quantity)) },
                    hint = stringResource(id = quantityState.value.hintStringId),
                    shouldShowHint = quantityState.value.shouldShowHint,
                    modifier = Modifier
                        .weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            PogleyEditText(
                value = descriptionState.value.text,
                onValueChanged = { description: String -> viewModel.onEvent(AddInventoryItemEvent.InsertDescription(description)) },
                hint = stringResource(id = descriptionState.value.hintStringId),
                shouldShowHint = descriptionState.value.shouldShowHint
            )
        }
    }
}
