package com.luisenrique.sportshub.di

import com.luisenrique.sportshub.data.repository.ClassificationRepositoryImpl
import com.luisenrique.sportshub.data.repository.ClubRepositoryImpl
import com.luisenrique.sportshub.data.repository.FavoriteTeamRepositoryImpl
import com.luisenrique.sportshub.data.repository.LeagueRepositoryImpl
import com.luisenrique.sportshub.data.repository.MatchRepositoryImpl
import com.luisenrique.sportshub.data.repository.TeamRepositoryImpl
import com.luisenrique.sportshub.domain.repository.ClassificationRepository
import com.luisenrique.sportshub.domain.repository.ClubRepository
import com.luisenrique.sportshub.domain.repository.FavoriteTeamRepository
import com.luisenrique.sportshub.domain.repository.LeagueRepository
import com.luisenrique.sportshub.domain.repository.MatchRepository
import com.luisenrique.sportshub.domain.repository.TeamRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindClassificationRepository(
        impl: ClassificationRepositoryImpl
    ): ClassificationRepository

    @Binds
    abstract fun bindMatchRepository(
        impl: MatchRepositoryImpl
    ): MatchRepository

    @Binds
    abstract fun bindLeagueRepository(
        impl: LeagueRepositoryImpl
    ): LeagueRepository

    @Binds
    abstract fun bindFavoriteTeamRepository(
        impl: FavoriteTeamRepositoryImpl
    ): FavoriteTeamRepository

    @Binds
    abstract fun bindClubRepository(
        impl: ClubRepositoryImpl
    ): ClubRepository

    @Binds
    abstract fun bindTeamRepository(
        impl: TeamRepositoryImpl
    ): TeamRepository
}
