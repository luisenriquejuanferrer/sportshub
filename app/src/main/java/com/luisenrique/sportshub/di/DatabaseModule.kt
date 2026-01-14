package com.luisenrique.sportshub.di

import android.content.Context
import androidx.room.Room
import com.luisenrique.sportshub.data.local.SportsHubDatabase
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
    fun provideDb(@ApplicationContext context: Context): SportsHubDatabase =
        Room.databaseBuilder(context, SportsHubDatabase::class.java, "sportshub.db")
            .build()

    @Provides
    fun provideClassificationDao(db: SportsHubDatabase) =
        db.classificationDao()
}