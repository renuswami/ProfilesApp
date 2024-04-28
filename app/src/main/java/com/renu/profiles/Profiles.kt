package com.renu.profiles

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun Profiles(profileViewModel: ProfileViewModel) {

    LazyColumn(){

        items(profileViewModel.profile.value) {

            Card {
                TextField(
                    value = TextFieldValue(it.firstName),
                    onValueChange = {},
                    label = { Text("First No : ") },
                )
            }
        }
    }
}