// Hecho Por Gabriel González, Nerea Ramirez, Marco Galan y Diego Pastor
package com.example.mytartu.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun RecomendationScreen(
    uiState: TartuUiState,
    windowSize : WindowWidthSizeClass,
) {

    Row {
        Column (
            modifier = Modifier.weight(1F).fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ){
            if (windowSize == WindowWidthSizeClass.Compact) {
                Image(
                    painterResource(uiState.currentRecomendation.imageResourceId),
                    stringResource(uiState.currentRecomendation.name),
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxSize(0.5f),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop
                )
            }
            Card(modifier = Modifier
                .padding(horizontal = 10.dp)
                .padding(top = 15.dp)) {
                Text(
                    stringResource(uiState.currentRecomendation.name),
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                )

                Text(
                    stringResource(uiState.currentRecomendation.description),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth(),

                    )
            }
            Text(
                stringResource(uiState.currentRecomendation.details),
                modifier = Modifier.padding(20.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        if (windowSize != WindowWidthSizeClass.Compact){
            Image(
                painterResource(uiState.currentRecomendation.imageResourceId),
                stringResource( uiState.currentRecomendation.name ),
                modifier = Modifier
                    .fillMaxHeight()
                    .width(512.dp)
                    .weight(1F),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop
            )
        }
    }
}