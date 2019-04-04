package com.github.teren4m.words.words.data

import com.github.teren4m.words.words.data.model.Word
import io.reactivex.Completable
import io.reactivex.Single

interface IWordsRepository {

    fun getAllWords(): Single<List<Word>>

    fun addWord(word: Word): Completable

    fun editWord(word: Word): Completable

}