package com.luisenrique.sportshub.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.luisenrique.sportshub.data.local.dao.ClassificationDao
import com.luisenrique.sportshub.data.local.dao.ClubDao
import com.luisenrique.sportshub.data.local.dao.FavoriteTeamDao
import com.luisenrique.sportshub.data.local.dao.LeagueDao
import com.luisenrique.sportshub.data.local.dao.MatchDao
import com.luisenrique.sportshub.data.local.dao.PlayerDao
import com.luisenrique.sportshub.data.local.dao.TeamDao
import com.luisenrique.sportshub.data.local.dao.UserDao
import com.luisenrique.sportshub.data.local.entities.ClassificationEntity
import com.luisenrique.sportshub.data.local.entities.ClubEntity
import com.luisenrique.sportshub.data.local.entities.FavoriteTeamEntity
import com.luisenrique.sportshub.data.local.entities.LeagueEntity
import com.luisenrique.sportshub.data.local.entities.MatchEntity
import com.luisenrique.sportshub.data.local.entities.PlayerEntity
import com.luisenrique.sportshub.data.local.entities.TeamEntity
import com.luisenrique.sportshub.data.local.entities.UserEntity

@Database(
    entities = [
        ClassificationEntity::class,
        MatchEntity::class,
        LeagueEntity::class,
        FavoriteTeamEntity::class,
        ClubEntity::class,
        PlayerEntity::class,
        TeamEntity::class,
        UserEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class SportsHubDatabase : RoomDatabase() {
    abstract fun classificationDao(): ClassificationDao
    abstract fun matchDao(): MatchDao
    abstract fun leagueDao(): LeagueDao
    abstract fun favoriteTeamDao(): FavoriteTeamDao
    abstract fun clubDao(): ClubDao
    abstract fun teamDao(): TeamDao
    abstract fun userDao(): UserDao
    abstract fun playerDao(): PlayerDao
}