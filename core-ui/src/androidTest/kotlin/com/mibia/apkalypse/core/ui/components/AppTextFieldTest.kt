package com.mibia.apkalypse.core.ui.components

import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextClearance
import org.junit.Rule
import org.junit.Test

class AppTextFieldTest{
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun checkRenderTest(){
        composeTestRule.setContent {
            val textFieldState = rememberTextFieldState("...")
            AppTextField(
                state = textFieldState,
                validate = {textFieldState.text.toString().isNullOrEmpty()}
                )
        }
        composeTestRule
            .onNodeWithText("...")
            .assertIsDisplayed()
    }
    @Test
    fun textClearenceTest(){
        composeTestRule.setContent {
            val textFieldState = rememberTextFieldState("...")
            AppTextField(
                state = textFieldState,
                validate = {textFieldState.text.toString().isNullOrEmpty()}
            )
        }

        composeTestRule
            .onNodeWithText("...")
            .performTextClearance()
        composeTestRule
            .onNodeWithText("Zawartosc nie spelnia wymagan")
            .assertIsDisplayed()
    }
}