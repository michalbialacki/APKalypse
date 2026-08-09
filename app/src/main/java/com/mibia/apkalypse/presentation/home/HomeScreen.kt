package com.mibia.apkalypse.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun HomeScreen(
    //viewmodel placeholder
    onFeaturePicked : (String) -> Unit, //wybranie feature przekierowuje dalej
    featureList : List<String> = listOf("TBA")
){
    //
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Demo screen"
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth(0.75f)

        ) {
            items(items = featureList){ label ->
                Button(
                    onClick = { onFeaturePicked(label)}, //nawigacja na feature
                    modifier = Modifier
                        .fillParentMaxWidth()
                ) {
                    Text(text = label)
                }
            }
        }

    }
}