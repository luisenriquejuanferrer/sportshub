package com.luisenrique.sportshub.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale

@Composable
fun MyImage(
    painter: Painter,
    contentDescription: String,
    modifier: Modifier,
    alignment: Alignment,
    contentScale: ContentScale
) {
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier,
        alignment = alignment,
        contentScale = contentScale
    )
}