package com.football.mastermind.quiz.app.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.football.mastermind.quiz.app.R
import com.football.mastermind.quiz.app.ui.theme.BlackAlpha60

@Composable
fun BackgroundImageView(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_bg),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds,
        colorFilter = ColorFilter.tint(color = BlackAlpha60, blendMode = BlendMode.Darken)
    )
}
