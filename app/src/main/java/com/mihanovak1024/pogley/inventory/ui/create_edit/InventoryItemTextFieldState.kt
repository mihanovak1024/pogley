package com.mihanovak1024.pogley.inventory.ui.create_edit

data class InventoryItemTextFieldState(
    val text: String = "",
    val hintStringId: Int = -1,
) {
    val shouldShowHint: Boolean
        get() = text.isEmpty() && hintStringId > 0
}