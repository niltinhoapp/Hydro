
package com.hydro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hydro.presentation.WaterGoalScreen
import com.hydro.presentation.WaterConsumptionScreen
import com.hydro.ui.theme.HydroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HydroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WaterGoalScreen(
                        modifier = Modifier.padding(innerPadding),
                        navigationController = NavController()
                    )
                }
            }
        }
    }
}

// Navigation.kt
package com.hydro.navigation

import androidx.navigation.NavController

object Navigation {
    val navController = NavController()
}

// WaterGoalScreen.kt
package com.hydro.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hydro.navigation.Navigation

@Composable
fun WaterGoalScreen(modifier: Modifier = Modifier, navigationController: NavController) {
    Scaffold(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            Text("Meta de Água")
            Button(onClick = {
                navigationController.navigate("consumption")
            }) {
                Text("Ir para Consumo")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WaterGoalScreenPreview() {
    HydroTheme {
        WaterGoalScreen(navigationController = Navigation.navController)
    }
}

// WaterConsumptionScreen.kt
package com.hydro.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hydro.navigation.Navigation

@Composable
fun WaterConsumptionScreen(modifier: Modifier = Modifier, navigationController: NavController) {
    Scaffold(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            Text("Consumo de Água")
            Button(onClick = {
                navigationController.navigate("goal")
            }) {
                Text("Ir para Meta")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WaterConsumptionScreenPreview() {
    HydroTheme {
        WaterConsumptionScreen(navigationController = Navigation.navController)
    }
}


