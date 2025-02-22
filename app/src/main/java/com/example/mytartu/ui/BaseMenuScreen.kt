// Hecho Por Gabriel González, Nerea Ramirez, Marco Galan y Diego Pastor
package com.example.mytartu.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mytartu.model.RecomendationItem

//TODO: esto es la apariencia basica de los menus de las apps
@Composable
fun BaseMenuScreen(

){


}

@Composable
fun MenuItem(
    recomendation: RecomendationItem,
    onItemClick: (RecomendationItem) -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        onClick = {onItemClick(RecomendationItem)},
        modifier = modifier
    ){
        Row(){
            Image()
            Column {
                Text()
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
    LazyRow {
        items(recomendations, key = { recomendationItem -> recomendationItem.id }) { recomendationItem ->
            MenuItem(
                recomendation = recomendationItem,
                onItemClick = onClick
            )
        }
    }
}