package com.luisenrique.sportshub.di

import android.content.Context
import androidx.room.Room
import com.luisenrique.sportshub.data.local.SportsHubDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDb(
        @ApplicationContext context: Context
    ): SportsHubDatabase {

        lateinit var instance: SportsHubDatabase

        instance = Room.databaseBuilder(
            context,
            SportsHubDatabase::class.java,
            "sportshub.db"
        )
            .addCallback(
                AppDatabaseCallback(
                    scope = CoroutineScope(SupervisorJob() + Dispatchers.IO),
                    dbProvider = { instance }
                )
            )
            .build()

        return instance
    }

    @Provides fun provideClassificationDao(db: SportsHubDatabase) = db.classificationDao()
    @Provides fun provideClubDao(db: SportsHubDatabase) = db.clubDao()
    @Provides fun providePlayerDao(db: SportsHubDatabase) = db.playerDao()
    @Provides fun provideTeamDao(db: SportsHubDatabase) = db.teamDao()
    @Provides fun provideUserDao(db: SportsHubDatabase) = db.userDao()
}
