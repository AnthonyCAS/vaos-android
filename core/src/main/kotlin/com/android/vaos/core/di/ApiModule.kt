package com.android.vaos.core.di

import android.os.Build
import com.android.vaos.core.BuildConfig
import com.android.vaos.core.remote.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Named(STANDARD_CLIENT)
    fun provideStandardClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        setupClient(builder)
        return builder.build()
    }

    private fun setupClient(
        clientBuilder: OkHttpClient.Builder
    ) {
        clientBuilder.connectTimeout(DEFAULT_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
        clientBuilder.readTimeout(DEFAULT_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
        clientBuilder.writeTimeout(DEFAULT_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)

        clientBuilder.addInterceptor { chain ->
            val requestBuilder = chain.request().newBuilder()
            requestBuilder.addHeader("App-Version", APP_VERSION)
            requestBuilder.addHeader("User-Agent", USER_AGENT)
            requestBuilder.addHeader("Content-Type", "application/json")
            chain.proceed(requestBuilder.build())
        }
        clientBuilder.addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
    }

    @Provides
    @Singleton
    fun provideApiService(
        @Named(STANDARD_CLIENT) client: OkHttpClient
    ): ApiService {
        val apiBaseUrl = BuildConfig.SERVER_URL
        val retrofit = Retrofit.Builder()
            .baseUrl(apiBaseUrl)
            .client(client)
            .build()

        return retrofit.create()
    }

    companion object {
        const val STANDARD_CLIENT = "STANDARD_CLIENT"
        const val DEFAULT_TIMEOUT_SECONDS = DEFAULT_API_TIMEOUT_SECONDS
        private val USER_AGENT: String =
            "NelNet ${BuildConfig.VERSION_CODE} / Android ${Build.VERSION.RELEASE} " +
                    Build.VERSION.INCREMENTAL + " / " +
                    Build.MANUFACTURER + " " +
                    Build.MODEL
        private const val APP_VERSION = "android/${BuildConfig.VERSION_NAME}"
    }
}

internal const val DEFAULT_API_TIMEOUT_SECONDS = 30
