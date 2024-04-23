package com.renu.profiles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import com.renu.profiles.ui.theme.ProfilesTheme

class ProfileInfoActivity : ComponentActivity() {
    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ProfilesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfileInfo()
                }
            }
        }
    }


    @Composable
    fun ProfileInfo() {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(onClick = { profileViewModel.getData() }) {
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
}

