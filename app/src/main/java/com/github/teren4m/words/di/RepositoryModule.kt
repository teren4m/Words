package com.github.teren4m.words.di

import com.github.teren4m.words.screens.word.data.IWordsRepository
import com.github.teren4m.words.screens.word.data.WordsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideWordRepository(repo: WordsRepository): IWordsRepository

}