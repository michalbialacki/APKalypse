package com.mibia.apkalypse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mibia.apkalypse.presentation.navigation.NavigationGraph
import com.mibia.apkalypse.ui.theme.APKalypseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            APKalypseTheme {
                NavigationGraph()
            }
        }
    }
}
