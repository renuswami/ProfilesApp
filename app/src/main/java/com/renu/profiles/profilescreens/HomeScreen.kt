package com.renu.profiles.profilescreens

import ProfileTopAppBar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController

@Composable
fun Home(nav: NavHostController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = {
            nav.navigate("profileForm")
        }) {
            Text(text = "Set Information")
        }
        Button(onClick = {
            nav.navigate("GetAllData")
        }) {
            Text(text = "Get Information")
        }
    }
}