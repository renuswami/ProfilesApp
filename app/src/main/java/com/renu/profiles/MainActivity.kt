package com.renu.profiles

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.renu.profiles.ui.theme.ProfilesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfilesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column (
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Button(onClick = {
                            val navigate = Intent(this@MainActivity, ProfileFormActivity::class.java)
                            startActivity(navigate)
                         }) {
                            Text(text = "Profile Form", fontSize = 18.sp)
                        }

                        Button(onClick = {
                            val navigate = Intent(this@MainActivity, ProfileInfoActivity::class.java)
                            startActivity(navigate)
                        }) {
                            Text(text = "Profile Info", fontSize = 18.sp)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Trial() {
    Text(text = "Renu")
}