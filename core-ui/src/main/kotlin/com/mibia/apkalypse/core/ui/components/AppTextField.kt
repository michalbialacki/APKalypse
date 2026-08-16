package com.mibia.apkalypse.core.ui.components

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppTextField(
    state: TextFieldState,
    modifier : Modifier = Modifier,
    validate : (String) -> Boolean
){

    val isError = validate(state.text.toString())
    TextField(
        state = state,
        modifier = modifier,
        isError = isError,
        supportingText = {
            if(isError){
                Text("Zawartosc nie spelnia wymagan")
            }
        }
    )

}