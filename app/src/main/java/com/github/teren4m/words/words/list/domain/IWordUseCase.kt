package com.github.teren4m.words.words.list.domain

import com.github.teren4m.words.words.data.model.Word
import io.reactivex.Completable
import io.reactivex.Observable

interface IWordUseCase {

    fun createWord(
        word: String?,
        transcription: String?,
        root: String?,
        partOfSpeech: String?,
        translation: String?
    ): Completable

    fun getAllWords(): Observable<List<Word>>
}