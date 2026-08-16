package com.mibia.apkalypse.core.ui

import androidx.compose.material3.Text
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

/**
 * Sanity test potwierdzający, że środowisko Compose UI testów w :core-ui działa
 * (BOM, test runner, reguły). Testy realnych komponentów (AppButton, AppTextField, ...)
 * dochodzą wraz z ich implementacją.
 */
class ComposeTestInfraTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun composeTestRule_rendersContent() {
        composeTestRule.setContent {
            Text("core-ui test infra ok")
        }

        composeTestRule.onNodeWithText("core-ui test infra ok").assertExists()
    }
}
