package com.app.tryandfail.presentation.screen.detailScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.app.tryandfail.presentation.screen.detailScreen.components.DetailHeader
import com.app.tryandfail.presentation.screen.detailScreen.components.TrailerPostView
import com.app.tryandfail.presentation.ui.theme.TryAndFailTheme


@Composable
fun DetailScreen(id: Int,navController: NavController) {
    TryAndFailTheme {


        Scaffold(
            topBar = {
                DetailHeader{
                    navController.navigateUp()
                }
            },
            content = { paddingValues ->
                val scrollState = rememberScrollState()

                val detailViewModel: DetailScreenViewModel = hiltViewModel()
                LaunchedEffect(key1 = true) {
                    detailViewModel.getTopAnimeList(id)
                }
                val animeDetail by detailViewModel.animeDetail.observeAsState()
                Column(
                    modifier = Modifier
                    .padding(paddingValues)
                        .padding(horizontal = 12.dp)
                        .verticalScroll(scrollState)
                ) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("${animeDetail?.genres?.get(0)?.type}")
                    animeDetail?.genres?.forEach { stringBuilder.append(" ,${it.name}") }
                    val genres = stringBuilder.toString()
                    TrailerPostView(
                        videoUrl = animeDetail?.trailer?.embedUrl,
                        postUrl = animeDetail?.images?.jpg?.imageUrl
                    )
                    Text(
                        text = animeDetail?.title.toString(),
                        Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                    )
                    Text(text = animeDetail?.synopsis.toString(), Modifier.padding(vertical = 4.dp))
                    Text(
                        text = "Total Episodes : ${animeDetail?.episodes.toString()}",
                        Modifier.padding(vertical = 4.dp)
                    )
                    Text(text = "Genres : $genres")
                    Text(text = "Rating : ${animeDetail?.rating}")
                }
            }
        )
    }
}