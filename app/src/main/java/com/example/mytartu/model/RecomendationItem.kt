package com.example.mytartu.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class RecomendationItem(
    val id: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    @StringRes val description: Int,
    @StringRes val details: Int
)
