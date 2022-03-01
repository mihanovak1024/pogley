package com.mihanovak1024.pogley.inventory.ui.inventoryitems.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mihanovak1024.pogley.R
import com.mihanovak1024.pogley.inventory.domain.model.InventoryItem
import com.mihanovak1024.pogley.ui.theme.PogleyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventoryItemEntry(
    inventoryItem: InventoryItem,
    onDeleteClick: () -> Unit
) {

    OutlinedCard(
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        Row {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = inventoryItem.name,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = "${stringResource(id = R.string.quantity)} ${inventoryItem.quantity}",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = inventoryItem.description,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 20.dp),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            IconButton(
                onClick = onDeleteClick,
            ) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "delete",
                    modifier = Modifier.padding(20.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Preview
@Composable
fun InventoryItemEntryPreview() {
    PogleyTheme {
        InventoryItemEntry(inventoryItem = InventoryItem(
            id = "123",
            name = "Screw Head(2x2)",
            quantity = 10,
            description = "Screws for wood environments with good grip that stays put for all eternity."
        ), onDeleteClick = {})
    }
}