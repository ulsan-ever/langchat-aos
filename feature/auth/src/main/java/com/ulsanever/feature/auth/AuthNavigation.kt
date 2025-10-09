package com.ulsanever.feature.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ulsanever.feature.auth.login.LoginScreen
import kotlinx.serialization.Serializable

@Serializable data object AuthRoute
@Serializable data object AuthBaseRoute

fun NavGraphBuilder.authSection(
    onLoginClick: () -> Unit,
) {
    navigation<AuthBaseRoute>(startDestination = AuthRoute) {
        composable<AuthRoute> {
            LoginScreen(onLoginClick)
        }
    }
}