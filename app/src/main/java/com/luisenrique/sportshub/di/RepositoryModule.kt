package com.luisenrique.sportshub.di

import com.luisenrique.sportshub.data.repository.LeagueRepositoryImpl
import com.luisenrique.sportshub.data.repositoryimpl.ClassificationRepositoryImpl
import com.luisenrique.sportshub.data.repositoryimpl.MatchRepositoryImpl
import com.luisenrique.sportshub.data.repositoryimpl.PlayerRepositoryImpl
import com.luisenrique.sportshub.data.repositoryimpl.TeamRepositoryImpl
import com.luisenrique.sportshub.data.repositoryimpl.UserRepositoryImpl
import com.luisenrique.sportshub.domain.repository.ClassificationRepository
import com.luisenrique.sportshub.domain.repository.LeagueRepository
import com.luisenrique.sportshub.domain.repository.MatchRepository
import com.luisenrique.sportshub.domain.repository.PlayerRepository
import com.luisenrique.sportshub.domain.repository.TeamRepository
import com.luisenrique.sportshub.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTeamRepository(impl: TeamRepositoryImpl): TeamRepository = impl

    @Provides
    @Singleton
    fun providePlayerRepository(impl: PlayerRepositoryImpl): PlayerRepository = impl

    @Provides
    @Singleton
    fun provideMatchRepository(impl: MatchRepositoryImpl): MatchRepository = impl

    @Provides
    @Singleton
    fun provideClassificationRepository(impl: ClassificationRepositoryImpl): ClassificationRepository = impl

    @Provides
    @Singleton
    fun provideLeagueRepository(impl: LeagueRepositoryImpl): LeagueRepository = impl

    @Provides
    @Singleton
    fun provideUserRepository(impl: UserRepositoryImpl): UserRepository = impl
}
