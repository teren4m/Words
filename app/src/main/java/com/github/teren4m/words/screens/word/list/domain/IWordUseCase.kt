package com.github.teren4m.words.screens.word.list.domain

import com.github.teren4m.words.screens.word.data.model.Word
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