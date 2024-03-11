package com.football.mastermind.quiz.app.screens.test.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.football.mastermind.quiz.app.R


@Composable
fun TestTopBar(modifier: Modifier = Modifier, onBackPressed: (() -> Unit)) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        TopBarNavigationIcon(onBackPressed = onBackPressed)
    }
}

@Composable
private fun TopBarNavigationIcon(onBackPressed: (() -> Unit)) {
    Icon(
        painter = painterResource(id = R.drawable.ic_left_arrow),
        contentDescription = null,
        tint = Color.White,
        modifier = Modifier
            .size(40.dp)
            .background(
                color = Color.Black,
                shape = RoundedCornerShape(40.dp)
            )
            .padding(all = 10.dp)
            .clickable { onBackPressed.invoke() }
    )
}