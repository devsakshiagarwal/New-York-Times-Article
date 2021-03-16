package com.goyals.smartdubai.arch.di

import com.goyals.smartdubai.Configuration
import com.goyals.smartdubai.model.api.NyTimesMostPopularApi
import com.goyals.smartdubai.model.repository.NyTimesMostPopularRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
  @Singleton @Provides
  fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
      .client(okHttpClient)
      .baseUrl(Configuration.BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()

  @Singleton @Provides fun providesHttpClient(): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor().apply {
      level = HttpLoggingInterceptor.Level.BODY
    }
    return OkHttpClient().newBuilder()
      .addInterceptor(loggingInterceptor)
      .connectTimeout(45, TimeUnit.SECONDS)
      .writeTimeout(45, TimeUnit.SECONDS)
      .readTimeout(45, TimeUnit.SECONDS)
      .build()
  }

  @Provides fun providesNyTimesApi(retrofit: Retrofit): NyTimesMostPopularApi =
    retrofit.create(NyTimesMostPopularApi::class.java)

  @Provides
  fun provideNyTimesRepo(nyTimesMostPopularApi: NyTimesMostPopularApi) =
    NyTimesMostPopularRepo(nyTimesMostPopularApi)
}