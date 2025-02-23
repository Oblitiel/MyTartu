// Hecho Por Gabriel González, Nerea Ramirez, Marco Galan y Diego Pastor
package com.example.mytartu.ui

import com.example.mytartu.TartuScreen
import com.example.mytartu.data.DataSource
import com.example.mytartu.model.RecomendationItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TartuViewModel {
    private val _uiState = MutableStateFlow(TartuUiState())
    val uiState: StateFlow<TartuUiState> = _uiState.asStateFlow()
}


class TartuUiState {
    var currentRecomendation : RecomendationItem  = DataSource.defaultRecomendationItem
    var currentSection : TartuScreen = DataSource.defaultScreen
}