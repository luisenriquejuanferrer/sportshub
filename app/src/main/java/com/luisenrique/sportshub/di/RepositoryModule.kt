package com.luisenrique.sportshub.di

import com.luisenrique.sportshub.BuildConfig
import com.luisenrique.sportshub.data.repositoryimpl.ClassificationRepositoryApiImpl
import com.luisenrique.sportshub.data.repositoryimpl.ClassificationRepositoryImpl
import com.luisenrique.sportshub.data.repositoryimpl.ClubRepositoryImpl
import com.luisenrique.sportshub.data.repositoryimpl.FavoriteTeamRepositoryImpl
import com.luisenrique.sportshub.data.repositoryimpl.LeagueRepositoryImpl
import com.luisenrique.sportshub.data.repositoryimpl.MatchRepositoryImpl
import com.luisenrique.sportshub.data.repositoryimpl.PlayerRepositoryImpl
import com.luisenrique.sportshub.data.repositoryimpl.TeamRepositoryImpl
import com.luisenrique.sportshub.data.repositoryimpl.UserRepositoryImpl
import com.luisenrique.sportshub.domain.repository.ClassificationRepository
import com.luisenrique.sportshub.domain.repository.ClubRepository
import com.luisenrique.sportshub.domain.repository.FavoriteTeamRepository
import com.luisenrique.sportshub.domain.repository.LeagueRepository
import com.luisenrique.sportshub.domain.repository.MatchRepository
import com.luisenrique.sportshub.domain.repository.PlayerRepository
import com.luisenrique.sportshub.domain.repository.TeamRepository
import com.luisenrique.sportshub.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    companion object {
        @Provides
        fun provideClassificationRepository(
            roomImpl: ClassificationRepositoryImpl,
            apiImpl: ClassificationRepositoryApiImpl
        ): ClassificationRepository =
            if (BuildConfig.USE_API) apiImpl else roomImpl
    }

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

    @Binds
    abstract fun bindPlayerRepository(
        impl: PlayerRepositoryImpl
    ): PlayerRepository

    @Binds
    abstract fun bindUserRepository(
        impl: UserRepositoryImpl
    ): UserRepository
}
