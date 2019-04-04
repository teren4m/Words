package com.github.teren4m.words.words.data

import com.github.teren4m.words.db.words.WordsDAO
import com.github.teren4m.words.words.data.converters.IWordDTOToWordConverter
import com.github.teren4m.words.words.data.converters.IWordToWordDTOConverter
import com.github.teren4m.words.words.data.model.Word
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class WordsRepository @Inject constructor(
    private val wordsDAO: WordsDAO,
    private val wordToWordDTOConverter: IWordToWordDTOConverter,
    private val wordDTOToWordConverter: IWordDTOToWordConverter
) : IWordsRepository {

    override fun getAllWords(): Single<List<Word>> =
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