package com.example.mytartu.data

import com.example.mytartu.R
import com.example.mytartu.TartuScreen
import com.example.mytartu.model.RecomendationItem

object DataSource {

    val  defaultRecomendationItem = RecomendationItem(
        id = 1,
        imageResourceId = R.drawable.hotel_tartu,
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
                id = 11,
                imageResourceId = R.drawable.toomemagi_park,
                name = R.string.parque_toomemagi,
                description = R.string.parque_toomemagi_desc,
                details = R.string.parque_toomemagi_details
            ),
            RecomendationItem(
                id = 12,
                imageResourceId = R.drawable.raadi_park,
                name = R.string.parque_raadi,
                description = R.string.parque_raadi_desc,
                details = R.string.parque_raadi_details
            ),
            RecomendationItem(
                id = 13,
                imageResourceId = R.drawable.botanical_garden,
                name = R.string.jardin_botanico_tartu,
                description = R.string.jardin_botanico_tartu_desc,
                details = R.string.jardin_botanico_tartu_details
            ),
            RecomendationItem(
                id = 14,
                imageResourceId = R.drawable.emajogi_riverbank,
                name = R.string.parque_emajogi,
                description = R.string.parque_emajogi_desc,
                details = R.string.parque_emajogi_details
            ),
            RecomendationItem(
                id = 15,
                imageResourceId = R.drawable.laululava_park,
                name = R.string.parque_laululava,
                description = R.string.parque_laululava_desc,
                details = R.string.parque_laululava_details
            )
        )
    }
    fun getShoppingMalls() : List<RecomendationItem>{
        return listOf(
            RecomendationItem(
                id = 16,
                imageResourceId = R.drawable.lounakeskus,
                name = R.string.lounakeskus,
                description = R.string.lounakeskus_desc,
                details = R.string.lounakeskus_details
            ),
            RecomendationItem(
                id = 17,
                imageResourceId = R.drawable.tasku_centre,
                name = R.string.tasku_centre,
                description = R.string.tasku_centre_desc,
                details = R.string.tasku_centre_details
            ),
            RecomendationItem(
                id = 18,
                imageResourceId = R.drawable.kvartal,
                name = R.string.kvartal,
                description = R.string.kvartal_desc,
                details = R.string.kvartal_details
            ),
            RecomendationItem(
                id = 19,
                imageResourceId = R.drawable.eeden,
                name = R.string.eeden,
                description = R.string.eeden_desc,
                details = R.string.eeden_details
            ),
            RecomendationItem(
                id = 20,
                imageResourceId = R.drawable.tartu_kaubamaja,
                name = R.string.tartu_kaubamaja,
                description = R.string.tartu_kaubamaja_desc,
                details = R.string.tartu_kaubamaja_details
            )
        )
    }
}