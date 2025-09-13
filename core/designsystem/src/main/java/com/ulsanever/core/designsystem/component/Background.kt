package com.ulsanever.core.designsystem.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ulsanever.core.designsystem.theme.LangChatTheme
import com.ulsanever.core.designsystem.theme.LocalBackgroundTheme
import com.ulsanever.core.designsystem.theme.ThemePreviews

/**
 * LangChat 메인 배경
 */
@Composable
fun LangChatBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val color = LocalBackgroundTheme.current.color
    val tonalElevation = LocalBackgroundTheme.current.tonalElevation
    Surface(
        color = if (color == Color.Unspecified) Color.Transparent else color,
        tonalElevation = if (tonalElevation == Dp.Unspecified) 0.dp else tonalElevation,
        modifier = modifier.fillMaxSize(),
    ) {
        // 중첩 tonal elevation 문제 해결
        CompositionLocalProvider(LocalAbsoluteTonalElevation provides 0.dp) {
            content()
        }
    }
}

@ThemePreviews
@Composable
fun LangChatBackgroundPreview() {
    LangChatTheme(dynamicTheme = false) {
        LangChatBackground(modifier = Modifier.size(100.dp), content = {})
    }
}