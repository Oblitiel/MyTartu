// Hecho Por Gabriel González, Nerea Ramirez, Marco Galan y Diego Pastor

package com.example.mytartu

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.mytartu.ui.TartuViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

//TODO: Aqui van los enumerados de las rutas para el nav controler
enum class TartuScreen(){
    // Recomendaciones
    HotelRecom,
    RestaurantRecom,
    ParkRecom,
    MallRecom,
    // Detalles de las recomendaciones
    Hotel,
    Restaurant,
    Park,
    Mall
}

//TODO: Aqui va todo lo del nav controler y el scafold
@Composable
fun TartuApp(){

    val navController = rememberNavController()
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = TartuScreen.valueOf(
        backStackEntry?.destination?.route ?: TartuScreen.HotelRecom.name
    )
    val viewModel: TartuViewModel = viewModel()

    Scaffold(
        topBar = {
            TartuTopBar()
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = currentScreen,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Pantalla sugerencias de hoteles
            composable(route = TartuScreen.HotelRecom.name) {

            }

            // Pantalla sugerencias de restaurantes
            composable(route = TartuScreen.RestaurantRecom.name) {

            }

            // Pantalla sugerencias de parques
            composable(route = TartuScreen.ParkRecom.name) {

            }

            // Pantalla sugerencias de centros comerciales
            composable(route = TartuScreen.MallRecom.name) {

            }

            // Pantallade hotel
            composable(route = TartuScreen.Hotel.name) {

            }

            // Pantalla de restaurante
            composable(route = TartuScreen.Restaurant.name) {

            }

            // Pantalla de parque
            composable(route = TartuScreen.Park.name) {

            }

            // Pantalla de centro comercial
            composable(route = TartuScreen.Mall.name) {

            }
        }
    }
}

//TODO: Aqui va pues la top bar de la app bruuhh
@Composable
fun TartuTopBar(){

}