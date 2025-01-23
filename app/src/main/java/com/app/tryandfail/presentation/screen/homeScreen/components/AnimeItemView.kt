package com.app.tryandfail.presentation.screen.homeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.app.tryandfail.R
import com.app.tryandfail.domain.models.AnimeItemModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AnimeItemView(animeItemModel: AnimeItemModel,onClick: (Int) -> Unit) {
    Row(modifier = Modifier.fillMaxSize().padding(4.dp).background(color = Color.White, shape = RoundedCornerShape(12.dp)).clickable {
        onClick.invoke(animeItemModel.malId)
    }) {
        GlideImage(
            model = animeItemModel.images.jpg.imageUrl,
            contentDescription = "Thumbnail",
            modifier = Modifier.padding(4.dp).size(100.dp),
        )
        Column {
            Text(text = "Title: ${animeItemModel.title}")
            Text(text = "Rate: ${animeItemModel.rating}")
            Text(text = "Episodes: ${animeItemModel.rating}")
        }
    }
}