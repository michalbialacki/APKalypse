package com.mibia.apkalypse.core.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun AppButton(
    onClick : () -> Unit,
    modifier : Modifier = Modifier,
    text : String = "Generic button",
    enabled : Boolean = true
){
    Button(
        modifier = modifier,
        onClick = { onClick() },
        enabled = enabled
        ) {
        Text(
            text = text
        )
    }
}