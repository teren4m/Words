package com.github.teren4m.words.di

import com.github.teren4m.words.words.data.IWordsRepository
import com.github.teren4m.words.words.data.WordsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideWordRepository(repo: WordsRepository): IWordsRepository

}