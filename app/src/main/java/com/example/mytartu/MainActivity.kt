// Hecho Por Gabriel González, Nerea Ramirez, Marco Galan y Diego Pastor
package com.example.mytartu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.example.mytartu.ui.theme.MyTartuTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyTartuTheme {
                val windowSize = calculateWindowSizeClass(this)
                TartuApp(
                    windowSize = windowSize.widthSizeClass
                )
            }
        }
    }
}