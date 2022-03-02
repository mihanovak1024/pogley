package com.mihanovak1024.pogley.inventory.ui.create_edit

sealed class InventoryItemTextFieldState(
    val hintStringId: Int,
) {
    val shouldShowHint: Boolean
        get() = !isValueValid && hintStringId > 0
    abstract val isValueValid: Boolean

    data class InventoryItemNumberFieldState(val number: Int = -1, val hintId: Int = -1) : InventoryItemTextFieldState(hintId) {
        override val isValueValid: Boolean
            get() = number >= 0
    }

    data class InventoryItemStringFieldState(val text: String = "", val hintId: Int = -1) : InventoryItemTextFieldState(hintId) {
        override val isValueValid: Boolean
            get() = text.isNotEmpty()
    }


}