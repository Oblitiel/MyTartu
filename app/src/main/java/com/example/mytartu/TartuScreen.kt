// Hecho Por Gabriel González, Nerea Ramirez, Marco Galan y Diego Pastor

package com.example.mytartu


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.mytartu.ui.TartuViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mytartu.data.DataSource
import com.example.mytartu.ui.BaseMenuScreen
import com.example.mytartu.ui.TartuUiState

//TODO: Aqui van los enumerados de las rutas para el nav controler
enum class TartuScreen(){
    Hotel,
    Restaurant,
    Park,
    Mall,

    Details
}

//TODO: Aqui va todo lo del nav controler y el scafold
@Composable
fun TartuApp(){

    val navController = rememberNavController()
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
//    val currentScreen = TartuScreen.valueOf(
//        backStackEntry?.destination?.route ?: TartuScreen.Hotel.name
//    )
    val currentScreen = TartuScreen.Hotel.name

    val viewModel: TartuViewModel = TartuViewModel()

    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TartuTopBar(
                uiState
            )
        }
    ) { innerPadding ->


        NavHost(
            navController = navController,
            startDestination = currentScreen,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Pantalla Detalles
            composable(route = TartuScreen.Details.name) {

            }

            // Pantallade hotel
            composable(route = TartuScreen.Hotel.name) {
                BaseMenuScreen(
                    viewModel = viewModel,
                    options = DataSource.getHotels(),
                )
                Button(
                    onClick = {navController.navigate(TartuScreen.Restaurant.name)}
                ) {
                    Text("Prueba")
                }
            }

            // Pantalla de restaurante
            composable(route = TartuScreen.Restaurant.name) {
                BaseMenuScreen(
                    viewModel = viewModel,
                    options = DataSource.getRestaurants(),
                )
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

//TODO: App´s Ttoppbbarr
@Composable
fun TartuTopBar(
    uiState: TartuUiState
){
    var currentTitle by remember { mutableIntStateOf(1) }
    val titleResult = when (currentTitle) {
        1 -> tartuViewModel.uiState.currentRecomendation
        else -> tartuViewModel.uiState.value.currentSection
    }
        if (tartuViewModel.uiState.value.isShowingDetails == true){
            currentTitle = 1
        } else {
            currentTitle = 69
        }
    Text(
        text = "" + currentTitle

    )
}