package com.mihanovak1024.pogley.inventory.ui.inventoryitems.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mihanovak1024.pogley.inventory.domain.model.InventoryItem

// TODO: To MaterialYou
@Composable
fun InventoryItemEntry(
    inventoryItem: InventoryItem,
    onDeleteClick: () -> Unit
) {
    val deleteIconWidth = 60.dp

    Card(
        modifier = Modifier
            .fillMaxSize(),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row {
            Text(
                text = inventoryItem.id,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )
            Box(
                modifier = Modifier
                    .width(deleteIconWidth)
                    .background(Color.Red)
                    .padding(20.dp)
            ) {
                IconButton(onClick = onDeleteClick) {
                    Icon(imageVector = Icons.Filled.Delete, contentDescription = "delete", tint = Color.White)
                }
            }
        }
    }
}