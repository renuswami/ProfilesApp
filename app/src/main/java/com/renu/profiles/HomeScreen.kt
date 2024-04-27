package com.renu.profiles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController

@Composable
fun Home(profileViewModel: ProfileViewModel, nav: NavHostController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = {nav.navigate("profileForm") }) {
            Text(text = "Set Info")
        }
        Button(onClick = {nav.navigate("profileInfo") }) {
            Text(text = "Get Info")
        }
    }


}