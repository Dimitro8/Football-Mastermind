package com.football.mastermind.quiz.app.screens

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.football.mastermind.quiz.app.MainActivity
import com.football.mastermind.quiz.app.R
import com.football.mastermind.quiz.app.SplashActivity
import com.football.mastermind.quiz.app.views.LoadingAnimation
import kotlinx.coroutines.delay

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(modifier: Modifier = Modifier, activity: SplashActivity) {

    LaunchedEffect(key1 = true) {
        delay(1500)
        val destination = Intent(activity, MainActivity::class.java)
        activity.startActivity(destination)
    }

    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.ic_splash_bg),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 100.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = stringResource(id = R.string.loading),
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 48.sp,
                )
                LoadingAnimation(circleSize = 4.dp, modifier = Modifier.padding(bottom = 2.dp))
            }
        }
    }
}