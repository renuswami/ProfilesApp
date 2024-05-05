package com.renu.profiles.profilescreens

import ProfileTopAppBar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.renu.profiles.viewmodels.ProfileViewModel


@Composable
fun ProfileInfo(profileViewModel: ProfileViewModel) {


    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(bottom = 16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ProfileTopAppBar()

        profileViewModel.profile.value.forEach { profile ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 8.dp),
                shape = RoundedCornerShape(16.dp),
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)

                ) {
                    ProfileTextField("First Name : ", profile.firstName)
                    ProfileTextField("Email : ", profile.email)
                    ProfileTextField("Mobile Number : ", profile.mobile)
                }
            }
        }
    }
}


@Composable
fun ProfileTextField(label: String, value: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )
    }
}

