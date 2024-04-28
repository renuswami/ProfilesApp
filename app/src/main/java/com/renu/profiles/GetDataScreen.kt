package com.renu.profiles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController

@Composable
fun GetData(profileViewModel: ProfileViewModel, nav: NavHostController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = {
            nav.navigate("ListOfData")
            profileViewModel.getData()

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