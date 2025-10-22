package com.ulsanever.feature.auth.login

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import com.ulsanever.core.designsystem.component.LangChatButton
import com.ulsanever.core.designsystem.theme.KakaoYellow
import com.ulsanever.core.designsystem.theme.LangChatTheme
import com.ulsanever.core.designsystem.theme.ThemePreviews
import com.ulsanever.feature.auth.R
import com.ulsanever.feature.auth.login.provider.KakaoLoginProvider
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import timber.log.Timber
import com.ulsanever.core.designsystem.R as designR

@Composable
internal fun LoginScreen(
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Kakao button
        LangChatButton(
            onClick = {
                coroutineScope.launch {
                    try {
                        val kakaoAccessToken = KakaoLoginProvider.login(context)
                        // TODO: ViewModel로 토큰 전달
                    } catch (e: Exception) {
                        // TODO: ViewModel로 오류 전달 후 상태 수집하기
                        if (e is ClientError && e.reason == ClientErrorCause.Cancelled) {
                            Timber.d("카카오 로그인 취소")
                        } else {
                            Toast.makeText(
                                context,
                                context.getString(R.string.feature_auth_login_error),
                                Toast.LENGTH_LONG
                            ).show()
                            Timber.e(e, "카카오 로그인 실패")
                        }
                    }
                }
            },
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
private fun LoginScreenPreview() {
    LangChatTheme {
        LoginScreen(onLoginClick = {})
    }
}