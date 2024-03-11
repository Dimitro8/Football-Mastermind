package com.football.mastermind.quiz.app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.football.mastermind.quiz.app.screens.SplashScreen
import com.football.mastermind.quiz.app.ui.theme.FootballMastermindTheme

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FootballMastermindTheme {
                SplashScreen(activity = this)
            }
        }
    }
}