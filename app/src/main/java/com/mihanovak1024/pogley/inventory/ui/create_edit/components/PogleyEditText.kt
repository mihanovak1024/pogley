package com.mihanovak1024.pogley.inventory.ui.create_edit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PogleyEditText(
    value: String,
    onValueChanged: (String) -> Unit,
    hint: String,
    shouldShowHint: Boolean,
    modifier: Modifier = Modifier,
) {
    PogleyEditTextWithHint(
        hint = hint,
        shouldShowHint = shouldShowHint,
        modifier = modifier
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChanged,
            textStyle = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .fillMaxWidth(),
            visualTransformation = { TransformedText(it.capitalize(), OffsetMapping.Identity) }
        )
    }
}

@Composable
fun PogleyEditNumber(
    value: Int,
    onValueChanged: (Int) -> Unit,
    hint: String,
    shouldShowHint: Boolean,
    modifier: Modifier,
) {
    PogleyEditTextWithHint(
        hint = hint,
        shouldShowHint = shouldShowHint,
        modifier = modifier
    ) {
        BasicTextField(
            value = if (value >= 0) value.toString() else "",
            onValueChange = { value -> onValueChanged(if (value.isNotEmpty()) value.toInt() else -1) },
            textStyle = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

@Composable
private fun PogleyEditTextWithHint(
    hint: String,
    shouldShowHint: Boolean,
    modifier: Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, MaterialTheme.colorScheme.onSecondaryContainer, RoundedCornerShape(20))
            .background(MaterialTheme.colorScheme.secondaryContainer, RoundedCornerShape(20))
            .padding(10.dp)
    ) {
        content()
        if (shouldShowHint) {
            Text(
                text = hint,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Preview
@Composable
fun PogleyEditTextPreview() {
    MaterialTheme {
        PogleyEditText(
            value = "",
            onValueChanged = { },
            hint = "Insert name...",
            shouldShowHint = true,
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
        )
    }
}