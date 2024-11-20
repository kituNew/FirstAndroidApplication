package com.example.firstandroidapplication.core.di

//import android.telecom.Call
import com.example.firstandroidapplication.core.TranslationApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Call
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetWorkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .build()
    }

    @Provides
    @Singleton
    fun provideTranslationApi(retrofit: Retrofit):TranslationApi {
        return retrofit.create(TranslationApi::class.java)
    }
}