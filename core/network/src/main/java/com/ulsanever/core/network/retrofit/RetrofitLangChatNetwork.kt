package com.ulsanever.core.network.retrofit

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

private interface RetrofitLangChatNetworkApi {
    @GET(value = "api/kakao/authorize")
    suspend fun loginWithKakao(
        @Query("token") token: String,
    ): NetworkResponse<Boolean>
}

private const val NIA_BASE_URL = "" // BuildConfig.LANGCHAT_BASE_URL

@Serializable
private data class NetworkResponse<T>(
    val data: T,
)

class RetrofitLangChatNetwork @Inject constructor(
    networkJson: Json,
    okhttpCallFactory: dagger.Lazy<Call.Factory>
) {

    private val networkApi = Retrofit.Builder()
        .baseUrl(NIA_BASE_URL)
        // We use callFactory lambda here with dagger.Lazy<Call.Factory>
        // to prevent initializing OkHttp on the main thread.
        .callFactory { okhttpCallFactory.get().newCall(it) }
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType()),
        )
        .build()
        .create(RetrofitLangChatNetworkApi::class.java)
}