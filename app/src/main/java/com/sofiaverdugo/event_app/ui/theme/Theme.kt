package com.sofiaverdugo.event_app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val AppColorScheme = lightColorScheme(
    primary = PrimaryBlue,
    onPrimary = White,

    secondary = SecondaryGray,
    onSecondary = White,

    tertiary = TertiaryGray,
    onTertiary = White,

    background = LightBackground,
    onBackground = SecondaryGray,

    surface = White,
    onSurface = SecondaryGray,

    surfaceVariant = Color(0xFFE8EAF1),
    onSurfaceVariant = SecondaryGray
)

@Composable
fun EventappTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = AppColorScheme,
        typography = Typography,
        content = content
    )
}