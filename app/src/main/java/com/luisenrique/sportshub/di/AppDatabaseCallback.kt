package com.luisenrique.sportshub.di

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.luisenrique.sportshub.data.local.SampleData
import com.luisenrique.sportshub.data.local.SportsHubDatabase
import com.luisenrique.sportshub.domain.model.User
import com.luisenrique.sportshub.data.local.mapper.toEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppDatabaseCallback(
    private val scope: CoroutineScope,
    private val dbProvider: () -> SportsHubDatabase
) : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        scope.launch {
            val database = dbProvider()
            val payload = SampleData.create()
            database.userDao().upsertAll(
                listOf(payload.user.toEntity())
            )
        }
    }
}
