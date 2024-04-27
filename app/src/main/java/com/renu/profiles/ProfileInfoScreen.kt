package com.renu.profiles

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController

@Composable
fun ProfileInfo(profileViewModel: ProfileViewModel, nav: NavHostController) {

    val scrollState = rememberScrollState()

        Column(

            modifier = Modifier.fillMaxSize()
                .horizontalScroll(scrollState),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

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
            Button(onClick = {
                profileViewModel.getData()
            }) {
                Text(text = "Get Data")
            }

    }
}