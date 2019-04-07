package com.github.teren4m.words.db.words

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface WordsDAO {

    @Query("SELECT * FROM words")
    fun allWords(): Observable<List<WordDTO>>

    @Insert
    fun insertWord(wordDTO: WordDTO): Completable
}