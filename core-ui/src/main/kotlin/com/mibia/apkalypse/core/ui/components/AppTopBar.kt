package com.mibia.apkalypse.core.ui.components

import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(
    ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title : String,
    modifier : Modifier = Modifier,
    navigationIconButtonClickMethod : () -> Unit,
    actionIconButton : @Composable () -> Unit
){
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = {
                navigationIconButtonClickMethod()
            }){
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Primary navigation action"
                )
            }
        },
        actions = {
            actionIconButton()
        },
    )
}