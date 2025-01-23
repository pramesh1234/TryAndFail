package com.app.tryandfail.di

import com.app.tryandfail.data.remote.AnimeService
import com.app.tryandfail.data.repositoryImpl.AnimeRepositoryImpl
import com.app.tryandfail.domain.repository.AnimeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataModule {
    @Provides
    fun provideAnimeRepository(animeService: AnimeService): AnimeRepository {
        return AnimeRepositoryImpl(animeService)
    }

}