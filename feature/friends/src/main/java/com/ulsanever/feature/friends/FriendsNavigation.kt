package com.ulsanever.feature.friends

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

@Serializable data object FriendsRoute
@Serializable data object FriendsBaseRoute

fun NavController.navigateToFriends() = navigate(route = FriendsRoute)

fun NavGraphBuilder.friendsSection() {
    navigation<FriendsBaseRoute>(startDestination = FriendsRoute) {
        composable<FriendsRoute> {
            FriendsScreen()
        }
    }
}