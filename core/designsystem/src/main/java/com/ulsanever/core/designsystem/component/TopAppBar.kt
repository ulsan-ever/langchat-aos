package com.ulsanever.core.designsystem.component

import androidx.annotation.StringRes
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.ulsanever.core.designsystem.icon.LangChatIcons
import com.ulsanever.core.designsystem.theme.LangChatTheme
import com.ulsanever.core.designsystem.theme.ThemePreviews

/**
 * LangChat 상단바. Material 3 [CenterAlignedTopAppBar] 래핑
 *
 * @param navigationIcon 상단바 시작 부분 아이콘
 * @param navigationIconContentDescription 상단바 시작 부분 아이콘 설명. 아이콘만 존재하므로, 설명 필수
 * @param actionIcon 상단바 끝 부분 아이콘
 * @param actionIconContentDescription 상단바 끝 부분 아이콘 설명
 * @param modifier 상단바 modifier
 * @param colors 상단바 색상
 * @param onNavigationClick 상단바 시작 부분 아이콘 클릭 시 호출되는 콜백
 * @param onActionClick 상단바 끝 부분 아이콘 클릭 시 호출되는 콜백
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LangChatTopAppBar(
    @StringRes titleRes: Int,
    navigationIcon: ImageVector,
    navigationIconContentDescription: String,
    actionIcon: ImageVector,
    actionIconContentDescription: String,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    onNavigationClick:() -> Unit = {},
    onActionClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(id = titleRes)) },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = navigationIconContentDescription,
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        },
        actions = {
            IconButton(onClick = onActionClick) {
                Icon(
                    imageVector = actionIcon,
                    contentDescription = actionIconContentDescription,
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        },
        colors = colors,
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@ThemePreviews
@Composable
private fun LangChatTopAppBarPreview() {
    LangChatTheme {
        LangChatTopAppBar(
            titleRes = android.R.string.untitled,
            navigationIcon = LangChatIcons.Search,
            navigationIconContentDescription = "Navigation icon",
            actionIcon = LangChatIcons.Settings,
            actionIconContentDescription = "Action icon",
        )
    }
}