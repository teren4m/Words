package com.github.teren4m.words.words.word

import com.github.teren4m.words.words.list.model.WordItem
import javax.inject.Inject

class HebrewWordViewModel @Inject constructor(
    private val hebrewWord: WordItem.Hebrew
) : IWordViewModel {

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

}