package com.ulsanever.langchat.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.ulsanever.feature.auth.AuthBaseRoute
import com.ulsanever.feature.auth.authSection
import com.ulsanever.feature.friends.friendsSection
import com.ulsanever.feature.friends.navigateToFriends

@Composable
fun LangChatNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = AuthBaseRoute,
    ) {
        authSection(
            onLoginClick = navController::navigateToFriends,
        )
        friendsSection()
    }
}