package com.renu.profiles

import ProfileTopAppBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.renu.profiles.profilescreens.GetData
import com.renu.profiles.profilescreens.GetDataByMobile
import com.renu.profiles.profilescreens.Home
import com.renu.profiles.profilescreens.ProfileForm
import com.renu.profiles.profilescreens.ProfileInfo
import com.renu.profiles.ui.theme.ProfilesTheme
import com.renu.profiles.viewmodels.DataByMobileViewModel
import com.renu.profiles.viewmodels.ProfileViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val profileViewModel = ProfileViewModel()
            val dataByMobileViewModel = DataByMobileViewModel()
            ProfilesTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val nav = rememberNavController()

                    NavHost(navController = nav, startDestination = "Start") {
                        composable("Start") {
                            Home(nav = nav)
                        }
                        composable("profileForm") {
                            ProfileForm(profileViewModel = profileViewModel, nav = nav)

                        }
                        composable("GetAllData") {
                            GetData(profileViewModel = profileViewModel, nav = nav)
                        }

                        composable("GetDataByMobile"){
                            GetDataByMobile(dataByMobileViewModel = dataByMobileViewModel, nav = nav)
                        }

                        composable("ListOfData"){
                            ProfileInfo(profileViewModel = profileViewModel)
                        }
                    }
                }
            }
        }
    }
}
