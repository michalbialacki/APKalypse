package com.mibia.apkalypse.core.ui.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test

class ErrorStateTest(){

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun appButtonClickTest() {

        var retryTestRes = false
        composeTestRule.setContent {
            ErrorState(message = "...") {
                retryTestRes = !retryTestRes
            }
        }
        composeTestRule.onNodeWithContentDescription("Retry").performClick()
        assertEquals(true,retryTestRes)
    }

}
