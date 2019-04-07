package com.github.teren4m.words.screens.word.data

import com.github.teren4m.words.screens.word.data.model.Word
import io.reactivex.Completable
import io.reactivex.Observable

interface IWordsRepository {

    fun getAllWords(): Observable<List<Word>>

    fun addWord(word: Word): Completable

    fun editWord(word: Word): Completable

}