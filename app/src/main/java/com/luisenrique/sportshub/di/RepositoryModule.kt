package com.luisenrique.sportshub.di

import com.luisenrique.sportshub.domain.repository.ClassificationRepository
import com.luisenrique.sportshub.data.repository.ClassificationRepositoryImpl
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
}