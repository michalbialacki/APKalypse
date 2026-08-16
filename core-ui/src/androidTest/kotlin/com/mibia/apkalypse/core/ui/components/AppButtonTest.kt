package com.mibia.apkalypse.core.ui.components

import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test

class AppButtonTest(

){
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun appButtonClickTest() {
        var clickTestRes = false
        composeTestRule.setContent {
            AppButton(
                onClick = { clickTestRes = true },
                text = "..."
            )
        }
        composeTestRule
            .onNodeWithText("...")
            .performClick()
        assertEquals(true,clickTestRes)
    }

    @Test
    fun checkButtonDisability(){
        composeTestRule.setContent {
            AppButton(
                onClick = {},
                text = "...",
                enabled = false
            )
        }
        composeTestRule
            .onNodeWithText("...")
            .assertIsNotEnabled()
    }



}