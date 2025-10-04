package com.ulsanever.langchat.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ulsanever.langchat.navigation.LangChatNavHost

@Composable
fun LangChatApp(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    Scaffold(
        modifier = modifier,
        topBar = {
            /* TODO */
        },
        bottomBar = {
            /* TODO */
        },
    ) { padding ->
        LangChatNavHost(
            navController = navController,
            modifier = Modifier.padding(padding),
        )
    }
}