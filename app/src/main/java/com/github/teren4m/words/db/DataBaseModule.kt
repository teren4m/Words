package com.github.teren4m.words.db

import androidx.room.Room
import com.github.teren4m.words.App
import com.github.teren4m.words.db.words.WordsDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideCallsDB(app: App): AppDatabase =
        Room.databaseBuilder(
            app,
            AppDatabase::class.java, "words-db"
        ).build()

    @Singleton
    @Provides
    fun provideWordsDAO(db: AppDatabase): WordsDAO =
        db.getWordsDAO()

}