package com.sofiaverdugo.event_app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sofiaverdugo.event_app.models.EventRepo
import com.sofiaverdugo.event_app.viewmodels.EventVM
import com.sofiaverdugo.event_app.views.DetailScreen
import com.sofiaverdugo.event_app.views.EventsScreen

val viewModel =  EventVM(EventRepo())

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "events",
        modifier = modifier
    ) {
        composable("events") {
            EventsScreen(
                viewModel,
                onEventClick = { id ->
                    navController.navigate("detail/$id")
                }
            )
        }
        composable(
            route = "detail/{id}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType }
            )
        ) { entrada ->
            val id = entrada.arguments?.getInt("id") ?: 1
            DetailScreen(
                viewModel,
                eventId = id,
                onBack = { navController.popBackStack() }
            )
        }
    }
}