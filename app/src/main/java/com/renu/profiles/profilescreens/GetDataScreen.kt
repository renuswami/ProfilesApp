package com.renu.profiles.profilescreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import com.renu.profiles.viewmodels.ProfileViewModel

@Composable
fun GetData(profileViewModel: ProfileViewModel, nav: NavHostController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = {
            nav.navigate("ListOfData")
            profileViewModel.fatchData()

        }) {
            Text(text = "Get All Data")
        }
        Button(onClick = {
            nav.navigate("GetDataByMobile")
        }) {
            Text(text = "Get Data by Mobile")
        }
    }
}