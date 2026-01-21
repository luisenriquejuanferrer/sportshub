package com.luisenrique.sportshub.di

import com.luisenrique.sportshub.domain.repository.ClassificationRepository
import com.luisenrique.sportshub.data.repositoryimpl.ClassificationRepositoryImpl
import com.luisenrique.sportshub.data.repositoryimpl.ClubRepositoryImpl
import com.luisenrique.sportshub.data.repositoryimpl.PlayerRepositoryImpl
import com.luisenrique.sportshub.data.repositoryimpl.TeamRepositoryImpl
import com.luisenrique.sportshub.data.repositoryimpl.UserRepositoryImpl
import com.luisenrique.sportshub.domain.repository.ClubRepository
import com.luisenrique.sportshub.domain.repository.PlayerRepository
import com.luisenrique.sportshub.domain.repository.TeamRepository
import com.luisenrique.sportshub.domain.repository.UserRepository
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
    abstract fun bindClubRepository(
        impl: ClubRepositoryImpl
    ): ClubRepository

    @Binds
    abstract fun bindPlayerRepository(
        impl: PlayerRepositoryImpl
    ): PlayerRepository

    @Binds
    abstract fun bindTeamRepository(
        impl: TeamRepositoryImpl
    ): TeamRepository

    @Binds
    abstract fun bindUserRepository(
        impl: UserRepositoryImpl
    ): UserRepository



}