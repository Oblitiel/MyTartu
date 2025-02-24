// Hecho Por Gabriel González, Nerea Ramirez, Marco Galan y Diego Pastor

package com.example.mytartu


import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mytartu.data.DataSource
import com.example.mytartu.ui.BaseMenuScreen
import com.example.mytartu.ui.TartuUiState
import com.example.mytartu.ui.TartuViewModel

//TODO: Aqui van los enumerados de las rutas para el nav controler
enum class TartuScreen(@StringRes val tittle: Int) {
    Hotel(R.string.hotels),
    Restaurant(R.string.restaurants),
    Park(R.string.parks),
    Mall(R.string.malls),

    Details(R.string.details)
}

//TODO: Aqui va todo lo del nav controler y el scafold
@Composable
fun TartuApp(
    modifier: Modifier = Modifier
) {

    val navController = rememberNavController()
//    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = DataSource.defaultScreen.name

    val viewModel: TartuViewModel = TartuViewModel()
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TartuTopBar(
                uiState
            )
        },
        bottomBar = {
            TartuBottomBar(
                onClick = { screen: TartuScreen ->
                    navController.navigate(screen.name)
                    viewModel.updateCurrentSection(screen)
                }
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
                BaseMenuScreen(
                    viewModel = viewModel,
                    options = DataSource.getParks(),
                )
            }

            // Pantalla de centro comercial
            composable(route = TartuScreen.Mall.name) {
                BaseMenuScreen(
                    viewModel = viewModel,
                    options = DataSource.getShoppingMalls(),
                )
            }
        }
    }
}

//TODO: App´s Ttoppbbarr
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TartuTopBar(uiState: TartuUiState) {

    CenterAlignedTopAppBar(
        modifier = Modifier,
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            //titleContentColor = Color.White,
        ),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(R.drawable.tartu_icon),
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(R.dimen.icon_size))
                )
                Text(
                    text = if (uiState.isShowingDetails) {
                        stringResource(
                            uiState.currentSection.tittle,
                            stringResource(uiState.currentRecomendation.name)
                        )
                    } else {
                        stringResource(uiState.currentSection.tittle)
                    }
                )
            }
        }
    )
}

//TODO: App´s BbottommBarr
@Composable
fun TartuBottomBar(
    onClick: (TartuScreen) -> Unit
) {
    NavigationBar {
        Row(
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconButton(
                onClick = { onClick(TartuScreen.Hotel) }
            ) {
                Icon(Icons.Default.Home, contentDescription = stringResource(R.string.hotels))
            }
            IconButton(
                onClick = { onClick(TartuScreen.Restaurant) }
            ) {
                Icon(Icons.Default.Face, contentDescription = stringResource(R.string.restaurants))
            }
            IconButton(
                onClick = { onClick(TartuScreen.Park) }
            ) {
                Icon(Icons.Default.Favorite, contentDescription = stringResource(R.string.parks))
            }
            IconButton(
                onClick = { onClick(TartuScreen.Mall) }
            ) {
                Icon(
                    Icons.Default.ShoppingCart,
                    contentDescription = stringResource(R.string.malls)
                )
            }
        }
    }
}

@Preview
@Composable
fun TopBarPreviewAlt() {
    val viewModel: TartuViewModel = TartuViewModel()
    val uiState by viewModel.uiState.collectAsState()

    viewModel.showDetails(true)
    viewModel.updateCurrentSection(TartuScreen.Details)

    TartuTopBar(uiState)
}

@Preview
@Composable
fun GeneralPreview() {
    TartuApp()
}