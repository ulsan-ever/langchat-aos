package com.ulsanever.core.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ulsanever.core.designsystem.theme.LangChatTheme
import com.ulsanever.core.designsystem.theme.ThemePreviews

/**
 * LangChat 버튼. Material 3 [Button] 래핑
 *
 * @param onClick 버튼 클릭 시 호출되는 콜백
 * @param modifier 버튼 modifier
 * @param enabled 버튼 활성화 여부
 * @param contentPadding 버튼 container와 content 사이 padding
 * @param content 버튼 content
 */
@Composable
fun LangChatButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.onBackground,
    ),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(8.dp),
        colors = colors,
        contentPadding = contentPadding,
        content = content,
    )
}

/**
 * LangChat 텍스트, 아이콘 버튼
 *
 * @param onClick 버튼 클릭 시 호출되는 콜백
 * @param modifier 버튼 modifier
 * @param enabled 버튼 활성화 여부
 * @param text 버튼 텍스트 내용
 * @param leadingIcon 버튼 아이콘. 'null' 이면 아이콘 없음
 */
@Composable
fun LangChatButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.onBackground,
    ),
    text: String,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    LangChatButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        contentPadding = PaddingValues(
            start = 16.dp,
            top = 16.dp,
            end = 16.dp,
            bottom = 16.dp
        )
    ) {
        if (leadingIcon != null) {
            Box(Modifier.sizeIn(maxHeight = ButtonDefaults.IconSize)) {
                leadingIcon()
            }
        }
        Box(
            Modifier.padding(start = if (leadingIcon != null) ButtonDefaults.IconSpacing else 0.dp),
        ) {
            Text(text = text)
        }
    }
}

@ThemePreviews
@Composable
private fun LangChatButtonPreview() {
    LangChatTheme {
        LangChatButton(onClick = {}, text = "테스트 버튼")
    }
}