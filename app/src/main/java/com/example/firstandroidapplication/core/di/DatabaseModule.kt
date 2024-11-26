package com.example.firstandroidapplication.core.di

import android.content.Context
import com.example.firstandroidapplication.core.data.AppDatabase
import com.example.firstandroidapplication.core.data.TranslationHistoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun provideHistoryDao(db: AppDatabase): TranslationHistoryDao {
        return db.translationHistoryDao()
    }
}