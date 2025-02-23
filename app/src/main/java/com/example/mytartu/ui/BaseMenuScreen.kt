// Hecho Por Gabriel González, Nerea Ramirez, Marco Galan y Diego Pastor
package com.example.mytartu.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mytartu.R
import com.example.mytartu.data.LocalRecomendationDataProvider
import com.example.mytartu.model.RecomendationItem
import com.example.mytartu.ui.theme.MyTartuTheme

//TODO: esto es la apariencia basica de los menus de las apps
@Composable
fun BaseMenuScreen(
    options: List<RecomendationItem>
){


}

@Composable
fun MenuItem(
    recomendation: RecomendationItem,
    onItemClick: (RecomendationItem) -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        onClick = {onItemClick(recomendation)},
        modifier = modifier
    ){
        Row(
            modifier = modifier.fillMaxWidth()
        ){
            Image(
                painter = painterResource(recomendation.imageResourceId),
                contentDescription = null
            )
            Column {
                Text(stringResource(recomendation.name))
                Text(stringResource(recomendation.details))
            }
        }
    }
}

@Composable
fun MenuItemList(
    recomendations: List<RecomendationItem>,
    onClick: (RecomendationItem) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn (
        modifier = modifier
    ){
        items(recomendations, key = { recomendation -> recomendation.id }) { recomendation ->
            MenuItem(
                recomendation = recomendation,
                onItemClick = onClick
            )
        }
    }
}

//@Preview
//@Composable
//fun MenuItemPreview(){
//    MyTartuTheme {
//        MenuItem(
//            recomendation = LocalRecomendationDataProvider.getHotels()[0],
//            onItemClick = {}
//        )
//    }
//
//}

@Preview
@Composable
fun MenuListPreview(){
    MyTartuTheme{
        MenuItemList(
            recomendations = LocalRecomendationDataProvider.getHotels(),
            onClick = {}
        )
    }
}