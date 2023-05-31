package com.example.weatherappmphasis.di

import com.example.weatherappmphasis.data.remote.api.WeatherService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Singleton
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    @Singleton
    @Provides
    fun provideInterceptorWeatherApiKey() = Interceptor { chain ->
        val request = chain.request()
        val url = request.url().newBuilder()
            .addQueryParameter("appid", "6c8a745c21f02472f186a66b96caeb44")
            .addQueryParameter("country", "US")
            .addQueryParameter("units","imperial")
            .build()
        val newRequest = request.newBuilder().url(url).build()
        chain.proceed(newRequest)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        interceptor: Interceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Singleton
    @Provides
    fun provideWeatherService(retrofit: Retrofit): WeatherService =
        retrofit.create(WeatherService::class.java)

}