package com.github.teren4m.words.di

import com.github.teren4m.words.screens.word.list.domain.IWordUseCase
import com.github.teren4m.words.screens.word.list.domain.WordUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class UseCaseViewModel {

    @Binds
    abstract fun provideCreateWordUseCase(useCase: WordUseCase): IWordUseCase

}