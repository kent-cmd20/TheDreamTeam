package com.example.thedreamteam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.thedreamteam.ui.theme.TheDreamTeamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheDreamTeamTheme {
                val navController = rememberNavController() // Create the NavController

                // Set up navigation graph
                NavHost(navController = navController, startDestination = "main") {
                    composable("main") {
                        MainScreen(navController)
                    }
                    composable("screen3") {
                        Screen3(onNavigateBack = { navController.popBackStack() })
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.width(200.dp).height(200.dp),
            painter = painterResource(R.drawable.pogi),
            contentDescription = null
        )
        Text("Kent Justine Asilo")
        CustomButton(label = "Button 1")
        CustomButton(label = "Button 2")
        CustomButton(label = "Button 3") {
            navController.navigate("screen3")
        }
        CustomButton(label = "Button 4")
        CustomButton(label = "Button 5")
    }
}

@Composable
fun CustomButton(label: String, onClick: (() -> Unit)? = null) {
    Button(onClick = { onClick?.invoke() }) {
        Text(text = label)
    }
}
