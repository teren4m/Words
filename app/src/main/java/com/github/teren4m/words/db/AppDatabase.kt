package com.github.teren4m.words.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.teren4m.words.db.words.WordDTO
import com.github.teren4m.words.db.words.WordsDAO

@Database(
    entities = [
        WordDTO::class
    ], version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getWordsDAO(): WordsDAO

}