package com.renu.profiles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController

@Composable
fun ProfileInfo(profileViewModel: ProfileViewModel, nav: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.Magenta),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            nav.navigate("ProfileInfo")
            profileViewModel.getData()
        }) {
            Text(text = "Get Data")
        }

        val data = profileViewModel.profileData.value
        TextField(
            value = TextFieldValue(data.firstName),
            onValueChange = {},
            label = { Text("First Name : ") },
        )
        TextField(
            value = TextFieldValue(data.lastName),
            onValueChange = {},
            label = { Text("Last Name : ") },
        )
        TextField(
            value = TextFieldValue(data.email),
            onValueChange = {},
            label = { Text("Email Id : ") },
        )
        TextField(
            value = TextFieldValue(data.mobile),
            onValueChange = {},
            label = { Text("Mobile No : ") },
        )
        TextField(
            value = TextFieldValue(data.address),
            onValueChange = {},
            label = { Text("Address : ") },
        )


    }
}