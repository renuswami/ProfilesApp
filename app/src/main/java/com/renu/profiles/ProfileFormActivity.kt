package com.renu.profiles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import com.renu.profiles.ui.theme.ProfilesTheme

class ProfileFormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ProfilesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfileForm()
                }
            }
        }
    }


    @Composable
    fun ProfileForm() {
        val profileViewModel: ProfileViewModel by viewModels()

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val firstName = remember { mutableStateOf("")}
            val lastName = remember { mutableStateOf("")}
            val email = remember { mutableStateOf("")}
            val mobile = remember { mutableStateOf("")}
            val address = remember { mutableStateOf("")}

            TextField(
                value = firstName.value,
                onValueChange = {firstName.value = it },
                placeholder = { Text(text = "Enter Your First Name")},
                label = { Text("First Name : ") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                textStyle = TextStyle(Color.Black, fontWeight = FontWeight.Bold)
            )
            TextField(
                value = lastName.value,
                onValueChange = {lastName.value = it },
                placeholder = { Text(text = "Enter Your Last Name")},
                label = { Text("Last Name : ") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                textStyle = TextStyle(Color.Black, fontWeight = FontWeight.Bold)
            )
            TextField(
                value = email.value,
                onValueChange = {email.value = it },
                placeholder = { Text(text = "Enter Your Email Id")},
                label = { Text("Email : ") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                textStyle = TextStyle(Color.Black, fontWeight = FontWeight.Bold)
            )
            TextField(
                value = mobile.value,
                onValueChange = {mobile.value = it },
                placeholder = { Text(text = "Enter Your Mobile No")},
                label = { Text("Mobile No : ") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                textStyle = TextStyle(Color.Black, fontWeight = FontWeight.Bold)
            )
            TextField(
                value = address.value,
                onValueChange = {address.value = it },
                placeholder = { Text(text = "Enter Your Address")},
                label = { Text("Address : ") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                textStyle = TextStyle(Color.Black, fontWeight = FontWeight.Bold)
            )

            Button(onClick = { profileViewModel.setData() }) {
                Text(text = "Set Data")
            }

        }
    }
}

