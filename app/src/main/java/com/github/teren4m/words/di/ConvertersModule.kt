package com.github.teren4m.words.di

import com.github.teren4m.words.screens.word.data.converters.IWordDTOToWordConverter
import com.github.teren4m.words.screens.word.data.converters.IWordToWordDTOConverter
import com.github.teren4m.words.screens.word.data.converters.WordDTOToWordConverter
import com.github.teren4m.words.screens.word.data.converters.WordToWordDTOConverter
import dagger.Binds
import dagger.Module

@Module
abstract class ConvertersModule {

    @Binds
    abstract fun provideWordToWordDTOConverter(converter: WordToWordDTOConverter): IWordToWordDTOConverter

    @Binds
    abstract fun provideWordDTOToWordConverter(converter: WordDTOToWordConverter): IWordDTOToWordConverter
}