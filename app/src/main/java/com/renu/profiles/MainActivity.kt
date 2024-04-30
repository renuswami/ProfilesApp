package com.renu.profiles

import ProfileTopAppBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.renu.profiles.ui.theme.ProfilesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val profileViewModel = ProfileViewModel()
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
                            GetDataByMobile(profileViewModel = profileViewModel, nav = nav)
                        }

                        composable("ListOfData"){
                            ProfileInfo(profileViewModel = profileViewModel, nav = nav)
                        }

                        composable("ProfilesTopAppBar"){
                            ProfileTopAppBar(nav = nav)
                        }
                    }
                }
            }
        }
    }
}
