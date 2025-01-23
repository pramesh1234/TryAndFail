package com.app.tryandfail.presentation.screen.detailScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun DetailHeader(onBackClick: () -> Unit) {
    Row(modifier = Modifier .height(56.dp)) {
        Spacer(modifier = Modifier.width(12.dp))
        Icon( imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back icon", modifier = Modifier.align(Alignment.CenterVertically).clickable {
           onBackClick.invoke()
        })
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = "Detail", style = MaterialTheme.typography.titleLarge, textAlign = TextAlign.Center, modifier = Modifier.align(Alignment.CenterVertically)

           )
    }


}