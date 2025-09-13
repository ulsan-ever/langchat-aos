package com.ulsanever.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

/**
 * LangChat의 background color와 tonal elevation을 모델링하는 class
 */
@Immutable
data class BackgroundTheme(
    val color: Color = Color.Unspecified,
    val tonalElevation: Dp = Dp.Unspecified,
)

/**
 * [BackgroundTheme]을 위한 Composition local
 */
val LocalBackgroundTheme = staticCompositionLocalOf { BackgroundTheme() }