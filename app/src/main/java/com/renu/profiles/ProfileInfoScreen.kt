package com.renu.profiles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController


@Composable
fun ProfileInfo(profileViewModel: ProfileViewModel, nav: NavHostController) {


    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        items(profileViewModel.profile.value) {

            Card {

                TextField(
                    value = TextFieldValue(it.firstName),
                    onValueChange = {},
                    label = { Text("First Name : ") },
                )
                TextField(
                    value = TextFieldValue(it.lastName),
                    onValueChange = {},
                    label = { Text("Last Name : ") },
                )
                TextField(
                    value = TextFieldValue(it.email),
                    onValueChange = {},
                    label = { Text("Email : ") },
                )
                TextField(
                    value = TextFieldValue(it.mobile),
                    onValueChange = {},
                    label = { Text("Mobile Number : ") },
                )
                TextField(
                    value = TextFieldValue(it.address),
                    onValueChange = {},
                    label = { Text("Address : ") },
                )
            }
        }
    }
}

