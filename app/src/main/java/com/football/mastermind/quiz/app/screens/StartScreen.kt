package com.football.mastermind.quiz.app.screens

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.football.mastermind.quiz.app.R
import com.football.mastermind.quiz.app.constants.Routes
import com.football.mastermind.quiz.app.views.MainButton

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    innerPaddingValues: PaddingValues
) {
    val isNextClicked = rememberSaveable { mutableStateOf(false) }
    val activity = (LocalContext.current as? Activity)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(innerPaddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (!isNextClicked.value) {
            Text(
                text = stringResource(id = R.string.football_knowledge_test),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 35.dp),
                textAlign = TextAlign.Center
            )
            MainButton(title = R.string.next) {
                isNextClicked.value = true
            }
        } else {
            MainButton(title = R.string.start) {
                navController.navigate(Routes.TEST_SCREEN_ROUTE)
            }
            Spacer(modifier = Modifier.padding(5.dp))
            MainButton(title = R.string.exit) {
                activity?.finishAffinity()
            }
        }
    }
}