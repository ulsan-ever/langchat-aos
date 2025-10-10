package com.ulsanever.feature.auth.login.provider

import android.content.Context

interface SocialLoginProvider {
    fun startLogin(
        context: Context,
        onResult: () -> Unit,
    )
}