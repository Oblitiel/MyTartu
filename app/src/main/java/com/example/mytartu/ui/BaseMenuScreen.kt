// Hecho Por Gabriel González, Nerea Ramirez, Marco Galan y Diego Pastor
package com.example.mytartu.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mytartu.R
import com.example.mytartu.model.RecomendationItem

//TODO: esto es la apariencia basica de los menus de las apps
@Composable
fun BaseMenuScreen(
    viewModel: TartuViewModel,
    options: List<RecomendationItem>,
    modifier: Modifier = Modifier,
    onItemClick: (RecomendationItem) -> Unit
){
    MenuList(
        recomendations = options,
        onClick = onItemClick,
        modifier = modifier
    )

}

@Composable
fun MenuListItem(
    recomendation: RecomendationItem,
    onItemClick: (RecomendationItem) -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        elevation = CardDefaults.cardElevation(),
        onClick = {onItemClick(recomendation)},
        modifier = modifier,
        shape = RoundedCornerShape(20.dp)
    ){
        Row(
            modifier = modifier.fillMaxWidth()
                .size(128.dp)
        ){
            Image(
                painter = painterResource(recomendation.imageResourceId),
                contentDescription = null,
                modifier = Modifier.size(128.dp),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop
            )
            Column (
                modifier = Modifier
                    .padding(
                        vertical = 8.dp,
                        horizontal = 16.dp
                    )
                    .weight(1f)
            ){
                Text(
                    text = stringResource(recomendation.name),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(4.dp)
                )
                Text(
                    text = stringResource(recomendation.description),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}

@Composable
fun MenuList(
    recomendations: List<RecomendationItem>,
    onClick: (RecomendationItem) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
){
    LazyColumn (
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        modifier = modifier.padding(16.dp)
    ){
        items(recomendations) { recomendation ->
            MenuListItem(
                recomendation = recomendation,
                onItemClick = onClick
            )
        }
    }
}