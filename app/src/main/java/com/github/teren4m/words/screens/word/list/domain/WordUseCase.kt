package com.github.teren4m.words.screens.word.list.domain

import com.github.teren4m.base.randomUuid
import com.github.teren4m.words.screens.word.data.IWordsRepository
import com.github.teren4m.words.screens.word.data.model.Word
import com.github.teren4m.words.screens.word.list.domain.exception.*
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class WordUseCase @Inject constructor(
    private val wordsRepository: IWordsRepository
) : IWordUseCase {

    override fun getAllWords(): Observable<List<Word>> =
        wordsRepository.getAllWords()

    override fun createWord(
        word: String?,
        transcription: String?,
        root: String?,
        partOfSpeech: String?,
        translation: String?
    ): Completable =
        when {
            word.isNullOrEmpty() -> Completable.error(WordEmptyException())

            transcription.isNullOrEmpty() -> Completable.error(TranscriptionEmptyException())

            root.isNullOrEmpty() -> Completable.error(RootEmptyException())

            partOfSpeech.isNullOrEmpty() -> Completable.error(PartOfSpeechEmptyException())

            translation.isNullOrEmpty() -> Completable.error(TranslationEmptyException())

            else -> wordsRepository.addWord(
                Word(
                    randomUuid(),
                    word,
                    transcription,
                    root,
                    partOfSpeech,
                    translation
                )
            )
        }

}