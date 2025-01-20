package com.example.navigationcompose

sealed class NavItem(val icon: Int, val label: String, val route: String, val content: Int) {

    object Home : NavItem(
        icon = R.drawable.ic_home_disable, label = "Home", route = "home", R.drawable.img_home
    )

    object Search : NavItem(
        icon = R.drawable.ic_search_disable,
        label = "Search",
        route = "search",
        R.drawable.img_search
    )

    object Analytics : NavItem(
        icon = R.drawable.ic_pie_chart_disable,
        label = "Analytics",
        route = "analytics",
        R.drawable.img_analytics
    )

    object Clock :
        NavItem(
            icon = R.drawable.ic_clock_disable, label = "Clock", route = "clock",
            R.drawable.img_clock
        )

    object Profile :
        NavItem(
            icon = R.drawable.ic_user_disable, label = "Profile", route = "profile",
            R.drawable.img_profile
        )

}
