package com.football.mastermind.quiz.app.views

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.football.mastermind.quiz.app.ui.theme.Yellow

@Composable
fun MainButton(modifier: Modifier = Modifier, title: Int, onButtonClicked: () -> Unit) {
    Button(
        onClick = { onButtonClicked.invoke() },
        modifier = Modifier.clip(RoundedCornerShape(20.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = Yellow)
    ) {
        Text(
            text = stringResource(id = title),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}