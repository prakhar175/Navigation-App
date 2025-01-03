package com.example.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.example.ui.theme.ExampleTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExampleTheme {
                Surface {
                    App()
                }
                }
            }
        }
    }

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "first") {
        composable("first") {
            FirstScreen(navigationToSecond = {name,age->9
                navController.navigate("second/$name/$age")
            })
        }

            composable("second/{name}/{age}") {
                val name = it.arguments?.getString("name") ?: "No name"
                val age = it.arguments?.getString("age")?.toIntOrNull() ?: 5
                Second(name,age,navigationToFirst = {
                    navController.navigate("first")
                })
            }
        }
    }



