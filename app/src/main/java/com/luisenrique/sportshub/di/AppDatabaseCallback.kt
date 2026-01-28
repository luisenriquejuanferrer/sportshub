package com.luisenrique.sportshub.di

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.luisenrique.sportshub.data.local.SampleData
import com.luisenrique.sportshub.data.local.SportsHubDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class AppDatabaseCallback @Inject constructor(
    private val scope: CoroutineScope,
    private val dbProvider: Provider<SportsHubDatabase>
) : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        scope.launch {
            val database = dbProvider.get()
            val payload = SampleData.create()

            // Independent entities first
            database.leagueDao().upsertAll(payload.leagues)
            database.clubDao().upsertAll(payload.clubs)
            database.userDao().upsertAll(listOf(payload.user))

            // Dependent entities
            database.teamDao().upsertAll(payload.teams)

            // Entities that depend on other tables
            database.playerDao().upsertAll(payload.players)
            database.matchDao().upsertAll(payload.matches)
            database.classificationDao().upsertAll(payload.classifications)
            // favorites require a DAO method, leave commented for now
            // payload.favorites.forEach { database.favoriteTeamDao().addFavouriteTeam(it) }
        }
    }
}