package com.mibia.apkalypse.core.ui.components

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

private val isProgressIndicator =
    SemanticsMatcher.keyIsDefined(SemanticsProperties.ProgressBarRangeInfo)

class LoadingIndicatorTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun loadingIndicator_rendersProgressIndicator() {
        composeTestRule.setContent {
            LoadingIndicator()
        }

        composeTestRule.onNode(isProgressIndicator).assertExists()
    }

    @Test
    fun loadingIndicator_showsMessage_whenProvided() {
        composeTestRule.setContent {
            LoadingIndicator(message = "Loading data...")
        }

        composeTestRule.onNodeWithText("Loading data...").assertExists()
    }

    @Test
    fun loadingIndicator_hidesMessage_whenNull() {
        composeTestRule.setContent {
            LoadingIndicator(message = null)
        }

        composeTestRule.onNode(isProgressIndicator).assertExists()
    }

    @Test
    fun loadingIndicator_hidesMessage_whenBlank() {
        composeTestRule.setContent {
            LoadingIndicator(message = "   ")
        }

        composeTestRule.onNodeWithText("   ").assertDoesNotExist()
    }
}
