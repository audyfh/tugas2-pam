package com.example.tugas2_pam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugas2_pam.ui.theme.Tugas2_PAMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tugas2_PAMTheme {

                val mainViewModel : MainViewModel by viewModels()
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "registScreen",
                        modifier = Modifier.padding(innerPadding)
                    ){
                        composable(route = "registScreen"){
                            RegistScreen(
                                mainViewModel = mainViewModel,
                                onSaveClick = {
                                    navController.navigate("profileScreen")
                                }
                            )
                        }
                        composable(route = "profileScreen"){
                            ProfileScreen(
                                mainViewModel = mainViewModel,
                                onEditClick = {
                                    navController.navigate("registScreen")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
