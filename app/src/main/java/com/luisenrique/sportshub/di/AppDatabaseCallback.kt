package com.luisenrique.sportshub.di

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.luisenrique.sportshub.data.local.SampleData
import com.luisenrique.sportshub.data.local.SportsHubDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppDatabaseCallback(
    private val scope: CoroutineScope,
    private val dbProvider: () -> SportsHubDatabase
) : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        scope.launch(Dispatchers.IO) {
            val database = dbProvider()
            val payload = SampleData.create()

            database.clubDao().upsertAll(payload.clubs)
            database.classificationDao().upsertAll(payload.classifications)
            database.leagueDao().upsertAll(payload.leagues)
            database.teamDao().upsertAll(payload.teams)
            database.playerDao().upsertAll(payload.players)
            database.matchDao().upsertAll(payload.matches)
            database.userDao().upsertAll(payload.user)
            //payload.favorites.forEach { database.userDao().addFavouriteTeam(it) }
        }
    }
}