package com.ulsanever.core.data.repository

import com.ulsanever.core.network.auth.AuthDataSource
import javax.inject.Inject


class AuthRepository @Inject constructor(
    private val datasource: AuthDataSource
) {

    fun login(socialAccessToken: String) {
        datasource.login()
    }
}