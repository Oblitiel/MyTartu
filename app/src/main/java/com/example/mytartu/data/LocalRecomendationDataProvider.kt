package com.example.mytartu.data

import com.example.mytartu.R
import com.example.mytartu.model.RecomendationItem

object LocalRecomendationDataProvider {

    fun getHotels() : List<RecomendationItem>{
        return listOf(
            RecomendationItem(
                id = 1,
                imageResourceId = R.drawable.la_bochi,
                name = R.string.hotels,
                description = R.string.hotels,
                details = R.string.hotels
            ),
            RecomendationItem(
                id = 5,
                imageResourceId = R.drawable.la_bochi,
                name = R.string.hotels,
                description = R.string.hotels,
                details = R.string.hotels
            )
        )
    }
    fun getRestaurants() : List<RecomendationItem>{
        return listOf(
            RecomendationItem(
                id = 2,
                imageResourceId = R.drawable.la_bochi,
                name = R.string.restaurants,
                description = R.string.restaurants,
                details = R.string.restaurants
            )
        )
    }
    fun getParks() : List<RecomendationItem>{
        return listOf(
            RecomendationItem(
                id = 3,
                imageResourceId = R.drawable.la_bochi,
                name = R.string.parks,
                description = R.string.parks,
                details = R.string.parks
            )
        )
    }
    fun getShoppingMalls() : List<RecomendationItem>{
        return listOf(
            RecomendationItem(
                id = 4,
                imageResourceId = R.drawable.la_bochi,
                name = R.string.malls,
                description = R.string.malls,
                details = R.string.malls
            )
        )
    }
}