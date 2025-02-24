package com.example.mytartu.data

import com.example.mytartu.R
import com.example.mytartu.TartuScreen
import com.example.mytartu.model.RecomendationItem

object DataSource {

    val  defaultRecomendationItem = RecomendationItem(
        id = 1,
        imageResourceId = R.drawable.la_bochi,
        name = R.string.hotel_tartu,
        description = R.string.hotel_tartu_desc,
        details = R.string.hotel_tartu_details
    )

    val defaultScreen = TartuScreen.Hotel

    fun getHotels() : List<RecomendationItem>{
        return listOf(
            RecomendationItem(
                id = 1,
                imageResourceId = R.drawable.hotel_tartu,
                name = R.string.hotel_tartu,
                description = R.string.hotel_tartu_desc,
                details = R.string.hotel_tartu_details
            ),

            RecomendationItem(
                id = 2,
                imageResourceId = R.drawable.hotel_dorpat,
                name = R.string.hotel_dorpat,
                description = R.string.hotel_dorpat_desc,
                details = R.string.hotel_dorpat_details
            ),

            RecomendationItem(
                id = 3,
                imageResourceId = R.drawable.hektor_design_hostel,
                name = R.string.hektor_design_hostel,
                description = R.string.hektor_design_hostel_desc,
                details = R.string.hektor_design_hostel_details
            ),

            RecomendationItem(
                id = 4,
                imageResourceId = R.drawable.hotel_soho,
                name = R.string.hotell_soho,
                description = R.string.hotell_soho_desc,
                details = R.string.hotell_soho_details
            ),

            RecomendationItem(
                id = 5,
                imageResourceId = R.drawable.bob_w_duo_lofts,
                name = R.string.bob_w_duo_lofts,
                description = R.string.bob_w_duo_lofts_desc,
                details = R.string.bob_w_duo_lofts_details
            ),
        )
    }
    fun getRestaurants() : List<RecomendationItem>{
        return listOf(
            RecomendationItem(
                id = 6,
                imageResourceId = R.drawable.restaurant_aparaat,
                name = R.string.restoran_aparaat,
                description = R.string.restoran_aparaat_desc,
                details = R.string.restoran_aparaat_details
            ),
            RecomendationItem(
                id = 7,
                imageResourceId = R.drawable.gunpowder_cellar,
                name = R.string.gunpowder_cellar,
                description = R.string.gunpowder_cellar_desc,
                details = R.string.gunpowder_cellar_details
            ),
            RecomendationItem(
                id = 8,
                imageResourceId = R.drawable.restaurant_munchen,
                name = R.string.restaurant_munchen,
                description = R.string.restaurant_munchen_desc,
                details = R.string.restaurant_munchen_details
            ),
            RecomendationItem(
                id = 9,
                imageResourceId = R.drawable.humal_bistro,
                name = R.string.humal_bistro,
                description = R.string.humal_bistro_desc,
                details = R.string.humal_bistro_details
            ),
            RecomendationItem(
                id = 10,
                imageResourceId = R.drawable.la_dolce_vita,
                name = R.string.la_dolce_vita,
                description = R.string.la_dolce_vita_desc,
                details = R.string.la_dolce_vita_details
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