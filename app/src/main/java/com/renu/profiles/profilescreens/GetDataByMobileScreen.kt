package com.renu.profiles.profilescreens

import ProfileTopAppBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.renu.profiles.profiledata.ProfileData
import com.renu.profiles.viewmodels.DataByMobileViewModel

@Composable
fun GetDataByMobile(dataByMobileViewModel: DataByMobileViewModel, nav: NavHostController) {


    val profile =
        Box() {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                TextField(
                    value = dataByMobileViewModel.mobile.value,
                    onValueChange = { dataByMobileViewModel.mobile.value = it },
                    label = { Text("Mobile No : ") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    )
                )
                Button(onClick = {
                    dataByMobileViewModel.profileData.value =
                        dataByMobileViewModel.profileData.value.copy(
                            mobile = dataByMobileViewModel.mobile.value
                        )

                    dataByMobileViewModel.getDataByMobile()
                    dataByMobileViewModel.mobile.value = ""

                    nav.navigate("GetDataByMobile")
                }) {
                    Text(text = "GetData")
                }

                dataByMobileViewModel.dataByMobile.value.forEach { profile ->
                    ProfileCard(profile)

                }
            }
        }
}

@Composable
fun ProfileCard(profile: ProfileData) {
    Card(
        modifier = Modifier
            .fillMaxSize(10f)
            .padding(32.dp)
            .background(Color.Magenta, shape = RoundedCornerShape(8.dp))
            .height(380.dp), // Adjust height as needed

    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ProfileTextField("First Name : ", profile.firstName)
            ProfileTextField("Last Name : ", profile.lastName)
            ProfileTextField("Email : ", profile.email)
            ProfileTextField("Mobile Number : ", profile.mobile)
            ProfileTextField("Address : ", profile.address)
        }
    }
}
