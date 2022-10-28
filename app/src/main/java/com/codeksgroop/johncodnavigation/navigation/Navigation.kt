package com.codeksgroop.johncodnavigation.navigation

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
 import androidx.compose.material.*

import androidx.compose.runtime.Composable
 import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
 import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

 import com.codeksgroop.johncodnavigation.screens.*

sealed class NavDrawerItem(var route: String, var icon: Int, var title:String) {

    object Splash: NavDrawerItem("splash", com.codeksgroop.johncodnavigation.R.drawable.ic_splash, "Splash")
    object Home: NavDrawerItem("home", com.codeksgroop.johncodnavigation.R.drawable.ic_home, "Home")
    object Music: NavDrawerItem("music", com.codeksgroop.johncodnavigation.R.drawable.ic_music, "Music")
    object Movies: NavDrawerItem("Movies", com.codeksgroop.johncodnavigation.R.drawable.ic_movies, "Movies")
    object Books: NavDrawerItem("Books", com.codeksgroop.johncodnavigation.R.drawable.ic_book, "Books")
    object Profile: NavDrawerItem("Profile", com.codeksgroop.johncodnavigation.R.drawable.ic_profile, "Profile")
    object Settings: NavDrawerItem("Settings", com.codeksgroop.johncodnavigation.R.drawable.ic_settings, "Settings")

}

@Composable
    fun Navigation(navController: NavHostController) {
        NavHost(navController, startDestination = NavDrawerItem.Splash.route) {

            composable(NavDrawerItem.Splash.route) {
                SplashScreen(navController = navController)
            }
            composable(NavDrawerItem.Home.route) {
                HomeScreen()
            }
            composable(NavDrawerItem.Music.route) {
                MusicScreen()
            }
            composable(NavDrawerItem.Movies.route) {
                MoviesScreen()
            }
            composable(NavDrawerItem.Books.route) {
                BooksScreen()
            }
            composable(NavDrawerItem.Profile.route) {
                ProfileScreen()
            }
            composable(NavDrawerItem.Settings.route) {
                SettingsScreen()
            }
        }
    }

@Composable
fun DrawerItem(item: NavDrawerItem, selected: Boolean, onItemClick: (NavDrawerItem) -> Unit){
    val background = if (selected) android.R.color.black else android.R.color.transparent
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onItemClick(item) })
            .height(45.dp)
            .background(colorResource(id = background))
            .padding(start = 10.dp)
    ) {
        Image(
            painter = painterResource(id = item.icon),
            contentDescription = item.title,
            colorFilter = ColorFilter.tint(Color.White),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(35.dp)
                .width(35.dp)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            text = item.title,
            fontSize = 18.sp,
            color = Color.White
        )
    }
}



@Preview(showBackground = true)
@Composable
fun DrawerItemPreview() {
    DrawerItem(item = NavDrawerItem.Home, selected = false, onItemClick = {})
}





