package com.example.unsplashapp.di

import com.example.unsplashapp.common.Constants.BASE_URL
import com.example.unsplashapp.data.remote.unsplash.UnsplashApi
import com.example.unsplashapp.data.repository_impl.PhotoRepositoryImpl
import com.example.unsplashapp.domain.repository.PhotoRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUnsplashApi() : UnsplashApi {
        // Moshiのインスタンスを生成
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                MoshiConverterFactory.create(moshi)
            )
            .build()
            .create(UnsplashApi::class.java) // UnsplashApiのinterfaceを実装したクラスを生成
    }

    @Provides
    @Singleton
    fun providePhotoRepository(api: UnsplashApi) : PhotoRepository {
        return PhotoRepositoryImpl(api)
    }

}