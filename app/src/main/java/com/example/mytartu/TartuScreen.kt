// Hecho Por Gabriel González, Nerea Ramirez, Marco Galan y Diego Pastor

package com.example.mytartu


import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.tooling.preview.Preview
import com.example.mytartu.ui.TartuViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
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

            // Pantalla de hotel
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
fun TartuTopBar(uiState: TartuUiState){
    var currentTitle by remember { mutableIntStateOf(1) }
    val titleResult = when (currentTitle) {
        1 -> uiState.currentRecomendation
        else -> uiState.currentSection
    }
        if (uiState.isShowingDetails == true){
            currentTitle = 1
        } else {
            currentTitle = 69
        }
    Text(
        text = "" + currentTitle
    )
}

@Composable
fun TartuBottomBar(navController: NavController) {
    val items = listOf("Inicio", "Buscar", "Favoritos", "Perfil")
    val icons = listOf(Icons.Default.Home, Icons.Default.Face, Icons.Default.Favorite, Icons.Default.ShoppingCart)

    IconButton(
        onClick = {navController.navigate(TartuScreen.Hotel.name)}) {
        Icon(Icons.Default.Home, contentDescription = "Hoteles")
    }
    IconButton(onClick = {navController.navigate(TartuScreen.Restaurant.name)}) {
        Icon(Icons.Default.Face, contentDescription = "Restaurantes")
    }
    IconButton(onClick = {navController.navigate(TartuScreen.Park.name)}) {
        Icon(Icons.Default.Favorite, contentDescription = "Parques")
    }
    IconButton(onClick = {navController.navigate(TartuScreen.Mall.name)}) {
        Icon(Icons.Default.ShoppingCart, contentDescription = "Centros_comerciales")
    }
}
