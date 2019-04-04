package com.github.teren4m.words.di

import com.github.teren4m.words.words.data.converters.IWordDTOToWordConverter
import com.github.teren4m.words.words.data.converters.IWordToWordDTOConverter
import com.github.teren4m.words.words.data.converters.WordDTOToWordConverter
import com.github.teren4m.words.words.data.converters.WordToWordDTOConverter
import dagger.Binds
import dagger.Module

@Module
abstract class ConvertersModule {

    @Binds
    abstract fun provideWordToWordDTOConverter(converter: WordToWordDTOConverter): IWordToWordDTOConverter

    @Binds
    abstract fun provideWordDTOToWordConverter(converter: WordDTOToWordConverter): IWordDTOToWordConverter
}