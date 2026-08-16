package com.mibia.apkalypse

import androidx.compose.ui.platform.LocalContext
import androidx.navigation.testing.TestNavHostController
import com.mibia.apkalypse.presentation.navigation.NavigationGraph
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.ComposeNavigator
import com.mibia.apkalypse.presentation.navigation.Home
import com.mibia.apkalypse.presentation.navigation.Placeholder
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationSanityTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var navController: TestNavHostController

    @Before
    fun setupNavHost() {
        composeTestRule.setContent {
            // Inicjalizacja kontrolera testowego
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            NavigationGraph(navController)
        }
    }

    @Test
    fun navHost_startDestination_isCorrect() {
        composeTestRule
            .onNodeWithText("Demo screen")
            .assertIsDisplayed()

        assertEquals(navController
            .currentBackStackEntry
            ?.destination
            ?.hasRoute<Home>(),
            true)
    }

    @Test
    fun navHost_clickNavigate_opensDetailScreen() {
        composeTestRule
            .onNodeWithText("TBA")
            .performClick()

        composeTestRule
            .onNodeWithText("New Feature")
            .assertIsDisplayed()

        assertEquals(navController
            .currentBackStackEntry
            ?.destination
            ?.hasRoute<Placeholder>(),
            true)    }
}
