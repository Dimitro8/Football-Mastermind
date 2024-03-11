package com.football.mastermind.quiz.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.football.mastermind.quiz.app.constants.Routes
import com.football.mastermind.quiz.app.screens.StartScreen
import com.football.mastermind.quiz.app.screens.test.TestScreen
import com.football.mastermind.quiz.app.ui.theme.FootballMastermindTheme
import com.football.mastermind.quiz.app.views.BackgroundImageView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FootballMastermindTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BackgroundImageView()
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Routes.START_SCREEN_ROUTE
                    ) {
                        composable(Routes.START_SCREEN_ROUTE) {
                            StartScreen(
                                navController = navController,
                                innerPaddingValues = innerPadding
                            )
                        }
                        composable(Routes.TEST_SCREEN_ROUTE) {
                            TestScreen(
                                navController = navController,
                                innerPaddingValues = innerPadding
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FootballMastermindTheme {
    }
}