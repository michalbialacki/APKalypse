package com.mibia.apkalypse.core.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoadingIndicator(
    modifier : Modifier = Modifier,
    message : String? = null
){
    Box(modifier){
        Column() {
            CircularProgressIndicator()
            if (!message.isNullOrBlank()){
                Text(message)
            }
        }
    }
}