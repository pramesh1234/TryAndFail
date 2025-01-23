package com.app.tryandfail.presentation.screen.homeScreen

import android.util.Log
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Composition
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.app.tryandfail.common.Screen
import com.app.tryandfail.presentation.screen.homeScreen.components.AnimeItemView
import com.app.tryandfail.presentation.screen.homeScreen.components.HomeHeader
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@Composable
fun HomeScreen(navController: NavController){
    MaterialTheme {

        Scaffold(topBar = {
            HomeHeader()
        },
            content = { paddingValue ->
                val viewModel = hiltViewModel<HomeViewModel>()
                val list by viewModel.topAnimeList.collectAsState(initial = emptyList())
                Column(modifier = Modifier.padding(paddingValue)) {
                  LazyColumn {
                      items(list.size){
                          AnimeItemView(animeItemModel = list[it]){ id->
                              navController.navigate(Screen.DetailScreen.route+"/$id")
                          }
                      }
                  }
                }
            }
        )
    }


}