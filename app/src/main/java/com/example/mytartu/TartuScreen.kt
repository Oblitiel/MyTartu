// Hecho Por Gabriel González, Nerea Ramirez, Marco Galan y Diego Pastor

package com.example.mytartu


import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mytartu.data.DataSource
import com.example.mytartu.model.RecomendationItem
import com.example.mytartu.ui.BaseMenuScreen
import com.example.mytartu.ui.RecomendationScreen
import com.example.mytartu.ui.TartuUiState
import com.example.mytartu.ui.TartuViewModel

enum class TartuScreen(@StringRes val tittle: Int) {
    Hotel(R.string.hotels),
    Restaurant(R.string.restaurants),
    Park(R.string.parks),
    Mall(R.string.malls),

    Details(R.string.details)
}

@Composable
fun TartuApp(
    windowSize : WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {

    val navController = rememberNavController()
    val currentScreen = DataSource.defaultScreen.name

    val viewModel = TartuViewModel()
    val uiState by viewModel.uiState.collectAsState()

    val onItemClick : (RecomendationItem) -> Unit= {recomendation ->
        viewModel.updateCurrentRecomendation(recomendation)
        navController.navigate(TartuScreen.Details.name)
    }

    Scaffold(
        topBar = {
            TartuTopBar(
                uiState = uiState,
                onBackClick = {
                    navController.navigate(uiState.prepSection.name)
                    viewModel.updateCurrentSection(uiState.prepSection)
                }
            )
        },
        bottomBar = {
            TartuNavigationBar(
                onClick = { screen: TartuScreen ->
                    navController.navigate(screen.name)
                    viewModel.updateCurrentSection(screen)
                },
                uiState = uiState
            )
        },
        modifier = modifier

    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = currentScreen,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Pantalla Detalles
            composable(route = TartuScreen.Details.name) {
                RecomendationScreen(
                    uiState,
                    windowSize
                )
            }

            // Pantalla de hotel
            composable(route = TartuScreen.Hotel.name) {
                BaseMenuScreen(
                    options = DataSource.getHotels(),
                    onItemClick = onItemClick,
                    windowSize = windowSize
                )
            }

            // Pantalla de restaurante
            composable(route = TartuScreen.Restaurant.name) {
                BaseMenuScreen(
                    options = DataSource.getRestaurants(),
                    onItemClick = onItemClick,
                    windowSize = windowSize
                )
            }

            // Pantalla de parque
            composable(route = TartuScreen.Park.name) {
                BaseMenuScreen(
                    options = DataSource.getParks(),
                    onItemClick = onItemClick,
                    windowSize = windowSize
                )
            }

            // Pantalla de centro comercial
            composable(route = TartuScreen.Mall.name) {
                BaseMenuScreen(
                    options = DataSource.getShoppingMalls(),
                    onItemClick = onItemClick,
                    windowSize = windowSize
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TartuTopBar(
    uiState: TartuUiState,
    onBackClick : () -> Unit,
    modifier: Modifier = Modifier
) {

    CenterAlignedTopAppBar(
        modifier = modifier,
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            //titleContentColor = Color.White,
        ),
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (uiState.isShowingDetails){
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
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
                Spacer(
                    modifier = Modifier.weight(1F)
                )
                Image(
                    painter = painterResource(R.drawable.tartu_icon),
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(R.dimen.icon_size))
                )
            }
        }
    )
}

@Composable
fun TartuNavigationBar(
    onClick: (TartuScreen) -> Unit,
    modifier: Modifier = Modifier,
    uiState: TartuUiState
) {
    NavigationBar (
        modifier = modifier.fillMaxWidth()
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconButton(
                onClick = { onClick(TartuScreen.Hotel) }
            ) {
                Icon(painterResource(R.drawable.hotel_icon), contentDescription = stringResource(R.string.hotels), tint = chooseIconTint(uiState, TartuScreen.Hotel ))
            }
            IconButton(
                onClick = { onClick(TartuScreen.Restaurant) }
            ) {
                Icon(painterResource(R.drawable.restaurant_icon), contentDescription = stringResource(R.string.restaurants), tint = chooseIconTint(uiState, TartuScreen.Restaurant ))
            }
            IconButton(
                onClick = { onClick(TartuScreen.Park) }
            ) {
                Icon(painterResource(R.drawable.park_icon), contentDescription = stringResource(R.string.parks), tint = chooseIconTint(uiState, TartuScreen.Park ))
            }
            IconButton(
                onClick = { onClick(TartuScreen.Mall) }
            ) {
                Icon(
                    painterResource(R.drawable.mall_icon),
                    contentDescription = stringResource(R.string.malls),
                    tint = chooseIconTint(uiState, TartuScreen.Mall )
                )
            }
        }
    }
}

fun chooseIconTint(uiState: TartuUiState, currIcon: TartuScreen): Color {
    if (uiState.currentSection == TartuScreen.Details){
        if (uiState.prepSection == currIcon){ return Color(0xFF0072CE) }

        return Color.DarkGray
    }

    if (uiState.currentSection == currIcon){ return Color(0xFF0072CE) }

    return Color.DarkGray

}

