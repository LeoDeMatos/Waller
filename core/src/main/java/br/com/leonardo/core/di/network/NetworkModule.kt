package br.com.leonardo.core.di.network

import android.content.Context
import br.com.leonardo.core.UnplashAPI
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

//
//  NetworkModule
//  Waller
//
//  Created by Leonardo de Matos on 2019-01-26.
//  Copyright © 2019 Leonardo de Matos. All rights reserved.
//

private const val BASE_UNPLASH_URL = "https://api.unsplash.com/"

@Module
class NetworkModule(val context: Context) {

    @Provides
    @Reusable
    fun provideUnplashAPI(retrofit: Retrofit): UnplashAPI {
        return retrofit.create(UnplashAPI::class.java) as UnplashAPI
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_UNPLASH_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(rewriteInterceptor: Interceptor): OkHttpClient {
        val okClientBuilder = OkHttpClient.Builder()

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        okClientBuilder.addInterceptor(httpLoggingInterceptor)
        okClientBuilder.addNetworkInterceptor(rewriteInterceptor)
        // Set the cache location and size (5 MB)
        okClientBuilder.cache(Cache(File(context.cacheDir,
            "apiResponses"), (5 * 1024 * 1024).toLong()))

        okClientBuilder.connectTimeout(15, TimeUnit.SECONDS)
        okClientBuilder.readTimeout(15, TimeUnit.SECONDS)
        okClientBuilder.writeTimeout(15, TimeUnit.SECONDS)

        return okClientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideInterceptor(): Interceptor = Interceptor { chain ->
        val originalResponse = chain.proceed(chain.request())
        val cacheControl = originalResponse.header("Cache-Control")
        if (
            cacheControl == null ||
            cacheControl.contains("no-store") ||
            cacheControl.contains("no-cache") ||
            cacheControl.contains("must-revalidate") ||
            cacheControl.contains("max-age=0")) {

            return@Interceptor originalResponse.newBuilder()
                .header("Cache-Control", "public, max-age=" + 5000)
                .build()
        } else {
            originalResponse
        }
    }
}
