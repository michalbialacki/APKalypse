package com.mibia.apkalypse.core.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test

class AppTopBarTest (){
    @get:Rule
    val composeTestRule = createComposeRule()

    val ACTION_ICON_TAG = "test_action_button"

    @Test
    fun appTopBarRenderTest() {
        composeTestRule.setContent {
            AppTopBar(
                title = "...",
                navigationIconButtonClickMethod = {},
                actionIconButton = {
                    IconButton(onClick = {}, modifier = Modifier.testTag("test_action_button")) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Send,
                            contentDescription = "TEST"
                        )
                    }
                }
            )
        }
        composeTestRule
            .onNodeWithText("...")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithTag("test_action_button")
            .assertIsDisplayed()
    }

    @Test
    fun clickTopBarTest(){
        var clickTestRes : Boolean = false
        var iconClickTestRes : Boolean = false
        composeTestRule.setContent {
            AppTopBar(
                title = "...",
                navigationIconButtonClickMethod = {clickTestRes = !clickTestRes},
                actionIconButton = {
                    IconButton(onClick = {iconClickTestRes = !iconClickTestRes}, modifier = Modifier.testTag(ACTION_ICON_TAG)) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Send,
                            contentDescription = "TEST"
                        )
                    }
                }
            )
        }
        composeTestRule.onNodeWithContentDescription("Primary navigation action").performClick()
        assertEquals(true, clickTestRes)
        composeTestRule.onNodeWithTag(ACTION_ICON_TAG).performClick()
        assertEquals(true, iconClickTestRes)

    }
}

