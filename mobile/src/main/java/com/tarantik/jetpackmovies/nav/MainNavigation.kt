package com.tarantik.jetpackmovies.nav

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tarantik.core.base.theme.JetpackMoviesTheme
import com.tarantik.jetpackmovies.R
import com.tarantik.jetpackmovies.movieslist.ui.screen.movieslist.MoviesListScreen

sealed class Destination(
    val route: String,
    @StringRes val resourceId: Int,
    @DrawableRes val iconResId: Int
) {
    data object Movies :
        Destination("movies", R.string.movies, com.tarantik.core.base.R.drawable.ic_movie)

    data object Account :
        Destination("account", R.string.account, com.tarantik.core.base.R.drawable.ic_account)
}

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    val destinations = listOf(
        Destination.Movies,
        Destination.Account
    )

    Scaffold(
        bottomBar = {
            BottomAppBar(
                contentPadding = PaddingValues(0.dp)
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                destinations.forEach { destination ->
                    NavigationBarItem(
                        icon = {
                            Box {
                                Icon(
                                    painterResource(id = destination.iconResId),
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        },
                        label = { Text(stringResource(destination.resourceId)) },
                        selected = currentDestination?.hierarchy?.any { it.route == destination.route } == true,
                        onClick = {
                            navController.navigate(destination.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        },
                        colors = navigationBarItemColors()
                    )
                }
            }
        },
        contentWindowInsets = WindowInsets(0.dp,0.dp,0.dp,0.dp)
    ) {innerPadding ->
        NavHost(
            navController,
            startDestination = Destination.Movies.route,
            Modifier.padding(innerPadding)
        ) {
            composable(Destination.Movies.route) {
                MoviesListScreen(
                    hiltViewModel(),
                )
            }
            composable(Destination.Account.route) {
                Text(text = "ASD")
            }
        }
    }
}

@Composable
private fun navigationBarItemColors() = NavigationBarItemDefaults.colors(
    selectedTextColor = JetpackMoviesTheme.colors.onSurface.secondary,
    unselectedTextColor = JetpackMoviesTheme.colors.onSurface.primary,
    selectedIconColor = JetpackMoviesTheme.colors.onSurface.secondary,
    unselectedIconColor = JetpackMoviesTheme.colors.onSurface.primary,
    indicatorColor = JetpackMoviesTheme.colors.onSurface.inverseOnSurface,
)