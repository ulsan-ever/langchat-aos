package com.ulsanever.feature.auth.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ulsanever.core.designsystem.component.LangChatButton
import com.ulsanever.core.designsystem.theme.KakaoYellow
import com.ulsanever.core.designsystem.theme.LangChatTheme
import com.ulsanever.core.designsystem.theme.ThemePreviews
import com.ulsanever.feature.auth.R
import com.ulsanever.core.designsystem.R as designR

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Kakao button
        LangChatButton(
            onClick = {},
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = KakaoYellow,
                contentColor = Color.Black,
            ),
            text = stringResource(R.string.feature_auth_start_kakao),
            leadingIcon = {
                Icon(
                    painter = painterResource(designR.drawable.ic_kakao_logo),
                    contentDescription = null
                )
            }
        )
    }
}

@ThemePreviews
@Composable
fun LoginScreenPreview() {
    LangChatTheme {
        LoginScreen(onLoginClick = {})
    }
}