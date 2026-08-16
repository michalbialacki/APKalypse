package com.mibia.apkalypse.core.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

@Composable
fun ErrorState(
    message : String,
    errorIcon : @Composable () -> Unit = {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = "Error happens",
            modifier = Modifier.testTag("ERROR_STATE_TAG")
        )
    },
    retryMethod : () -> Unit
){
    Box(){
        Column() {
            Row() {
                Box(){
                    Text(text = message)
                }
                Box(){
                    errorIcon()
                }
            }
            IconButton(
                onClick = { retryMethod() }
            ){
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Retry"
                )
            }
        }
    }
}
