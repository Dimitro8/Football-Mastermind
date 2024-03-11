package com.football.mastermind.quiz.app.screens.test.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.football.mastermind.quiz.app.R
import com.football.mastermind.quiz.app.constants.Routes
import com.football.mastermind.quiz.app.views.MainButton

@Composable
fun TestDialogView(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit = {},
    title: String,
    navController: NavHostController
) {
    Dialog(
        onDismissRequest = onDismiss,
        content = {
            Column(
                modifier = modifier
                    .background(color = Color.LightGray, shape = RoundedCornerShape(20.dp))
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.your_result),
                    color = Color.Black,
                    fontSize = 50.sp
                )
                Text(
                    text = "$title/9",
                    color = Color.Black,
                    fontSize = 50.sp,
                    modifier = Modifier.padding(bottom = 130.dp)
                )
                MainButton(title = R.string.to_menu) {
                    navController.navigate(Routes.START_SCREEN_ROUTE)
                }
            }
        }
    )
}