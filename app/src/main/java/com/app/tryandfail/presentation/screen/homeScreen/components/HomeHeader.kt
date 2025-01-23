package com.app.tryandfail.presentation.screen.homeScreen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun HomeHeader() {
        Row(modifier = Modifier .height(56.dp)) {
                Text(text = "Anime", style = MaterialTheme.typography.titleLarge, textAlign = TextAlign.Center, modifier = Modifier
                        .fillMaxWidth(1f)
                        .align(Alignment.CenterVertically))
        }


}