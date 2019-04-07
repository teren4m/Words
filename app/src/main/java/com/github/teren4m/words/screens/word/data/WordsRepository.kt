package com.github.teren4m.words.screens.word.data

import com.github.teren4m.words.db.words.WordsDAO
import com.github.teren4m.words.screens.word.data.converters.IWordDTOToWordConverter
import com.github.teren4m.words.screens.word.data.converters.IWordToWordDTOConverter
import com.github.teren4m.words.screens.word.data.model.Word
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class WordsRepository @Inject constructor(
    private val wordsDAO: WordsDAO,
    private val wordToWordDTOConverter: IWordToWordDTOConverter,
    private val wordDTOToWordConverter: IWordDTOToWordConverter
) : IWordsRepository {

    override fun getAllWords(): Observable<List<Word>> =
        wordsDAO.allWords()
            .map {
                it.map(wordDTOToWordConverter::convert)
            }

    override fun addWord(word: Word): Completable =
        wordsDAO.insertWord(
            wordToWordDTOConverter.convert(word)
        )

    override fun editWord(word: Word): Completable =
        Completable.complete()

}