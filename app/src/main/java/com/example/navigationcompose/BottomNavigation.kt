package com.example.navigationcompose

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.vision.andorid.composecookbookyt.ui.theme.Grey
import com.vision.andorid.composecookbookyt.ui.theme.Primary

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun MainEntryPoint() {

    val navController = rememberNavController()
    Scaffold(bottomBar = { MainBottomNavigation(navController = navController) }) {
        MainNavigation(navHostController = navController)
    }
}

@Composable
fun MainNavigation(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = NavItem.Home.route,
    ) {
        composable(NavItem.Home.route) {
            Screen(NavItem.Home.content)
        }
        composable(NavItem.Search.route) {
            Screen(NavItem.Search.content)
        }
        composable(NavItem.Clock.route) {
            Screen(NavItem.Clock.content)
        }
        composable(NavItem.Analytics.route) {
            Screen(NavItem.Analytics.content)
        }
        composable(NavItem.Profile.route) {
            Screen(NavItem.Profile.content)
        }
    }
}

@Composable
fun Screen(image: Int) {
    Image(
        painterResource(image),
        contentDescription = "",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}


@Composable
fun MainBottomNavigation(navController: NavController) {
    val items = listOf(
        NavItem.Home,
        NavItem.Search,
        NavItem.Analytics,
        NavItem.Clock,
        NavItem.Profile
    )
    BottomNavigation(backgroundColor = Color.White, contentColor = Color.White) {

        val navStack by navController.currentBackStackEntryAsState()
        val currentRoute = navStack?.destination?.route

        items.forEach { item ->

            BottomNavigationItem(
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(item.route)
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }, icon = {

                        Icon(
                            painterResource(item.icon),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                }, alwaysShowLabel = true,
                selectedContentColor = Primary,
                unselectedContentColor = Grey
            )
        }
    }
}























