package com.github.teren4m.words.screens.word

import com.github.teren4m.base.adapter.Id
import com.github.teren4m.words.screens.word.list.model.WordItem
import javax.inject.Inject

class HebrewWordViewModel @Inject constructor(
    private val hebrewWord: WordItem.Hebrew
) : IWordViewModel, Id {

    override fun getId(): String =
        hebrewWord.word.uuid

    override val root: String by lazy {
        hebrewWord.word.root
    }

    override val partOfSpeech: String by lazy {
        hebrewWord.word.partOfSpeech
    }

    override val translation: String by lazy {
        hebrewWord.word.translation
    }

    override val word: String by lazy {
        hebrewWord.word.word + "/" + hebrewWord.word.transcription
    }

    override fun equals(other: Any?): Boolean {
        return hebrewWord.word == other
    }

    override fun hashCode(): Int {
        return hebrewWord.word.hashCode()
    }

}