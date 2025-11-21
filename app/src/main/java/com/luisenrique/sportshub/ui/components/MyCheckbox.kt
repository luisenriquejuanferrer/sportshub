package com.luisenrique.sportshub.ui.components

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun MyCheckBox(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: CheckboxColors = CheckboxDefaults.colors(),
) {
    var checked by remember { mutableStateOf(true) }

    Checkbox(
        checked = checked,
        onCheckedChange = { checked = it },
        modifier = modifier,
        enabled = enabled,
        colors = colors
    )
}