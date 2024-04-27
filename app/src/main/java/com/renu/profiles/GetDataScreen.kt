package com.renu.profiles

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController

@Composable
fun GetDataByMobile(profileViewModel: ProfileViewModel, nav: NavHostController) {


    Column {
        Button(onClick = {
            nav.navigate("profileForm")

        }) {
            Text(text = "Get Data")
        }
        TextField(
            value = TextFieldValue(),
            onValueChange = {},
            label = { Text("Mobile : ") },
        )
        Button(onClick = {
            profileViewModel.getData()
        }) {
            Text(text = "GetData")
        }


    }
}