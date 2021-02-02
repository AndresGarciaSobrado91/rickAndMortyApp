package com.example.rickandmortyapp.di.module

import android.content.Context
import com.example.rickandmortyapp.MyApp
import com.example.rickandmortyapp.data.remote.api.ApiService
import com.example.rickandmortyapp.data.repository.CharacterRepository
import com.example.rickandmortyapp.domain.GetCharactersUseCase
import com.example.rickandmortyapp.util.ui.LoadingViewManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    open fun provideContext(application: MyApp): Context = application

    @Provides
    @Singleton
    open fun provideCharacterRepository(
        apiService: ApiService
    ): CharacterRepository = CharacterRepository(apiService)

    @Singleton
    @Provides
    open fun provideLoadingViewManager(): LoadingViewManager = LoadingViewManager()

    @Singleton
    @Provides
    open fun prvideGetCharactersUseCase(
        characterRepository: CharacterRepository
    ): GetCharactersUseCase = GetCharactersUseCase(characterRepository)
}