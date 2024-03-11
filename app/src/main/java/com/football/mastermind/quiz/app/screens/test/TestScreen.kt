package com.football.mastermind.quiz.app.screens.test

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.football.mastermind.quiz.app.screens.test.view.TestTopBar
import com.football.mastermind.quiz.app.screens.test.view.TestView
import com.football.mastermind.quiz.app.views.BackgroundImageView

@Composable
fun TestScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    innerPaddingValues: PaddingValues
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        topBar = {
            TestTopBar {
                navController.popBackStack()
            }
        },
        content = { innerPadding ->
            BackgroundImageView()
            TestView(modifier = Modifier, navController = navController)
        }
    )
}