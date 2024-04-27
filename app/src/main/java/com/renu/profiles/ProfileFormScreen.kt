package com.renu.profiles

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavHostController


@Composable
fun ProfileForm(profileViewModel: ProfileViewModel, nav: NavHostController) {

    val scrollState = rememberScrollState()

        Column(

            modifier = Modifier.fillMaxSize()
                .horizontalScroll(scrollState),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextField(
                value = profileViewModel.firstName.value,
                onValueChange = { profileViewModel.firstName.value = it },
                label = { Text("First Name : ") }
            )
            TextField(
                value = profileViewModel.lastName.value,
                onValueChange = { profileViewModel.lastName.value = it },
                label = { Text("Last Name : ") }
            )
            TextField(
                value = profileViewModel.email.value,
                onValueChange = { profileViewModel.email.value = it },
                label = { Text("Email : ") }

            )
            TextField(
                value = profileViewModel.mobile.value,
                onValueChange = { profileViewModel.mobile.value = it },
                label = { Text("Mobile No : ") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                )
            )
            TextField(
                value = profileViewModel.address.value,
                onValueChange = { profileViewModel.address.value = it },
                label = { Text("Address : ") }
            )


            Button(onClick = {

                profileViewModel.profileData.value = profileViewModel.profileData.value.copy(
                    firstName = profileViewModel.firstName.value,
                    lastName = profileViewModel.lastName.value,
                    email = profileViewModel.email.value,
                    mobile = profileViewModel.mobile.value,
                    address = profileViewModel.address.value,

                    )

                profileViewModel.setData()
                profileViewModel.firstName.value = ""
                profileViewModel.lastName.value = ""
                profileViewModel.email.value = ""
                profileViewModel.mobile.value = ""
                profileViewModel.address.value = ""

            }) {
                Text(text = "Save")
            }
        }
    }

