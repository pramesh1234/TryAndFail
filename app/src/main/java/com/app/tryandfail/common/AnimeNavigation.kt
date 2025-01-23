package com.app.tryandfail.common


import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.app.tryandfail.presentation.screen.detailScreen.DetailScreen
import com.app.tryandfail.presentation.screen.homeScreen.HomeScreen

@Composable
fun AnimeNavigation() {
    val navController = rememberNavController()
        NavHost(navController = navController,startDestination= Screen.HomeScreen.route, modifier = Modifier.background(
            Color.White)) {
            composable(route= Screen.HomeScreen.route){
                HomeScreen(navController)
            }
            composable(
                route = Screen.DetailScreen.route+"/{id}", arguments = listOf(navArgument("id") { type = NavType.IntType })) {
                val id = it.arguments?.getInt("id")?:0
                DetailScreen(id,navController)
            }
        }
    }