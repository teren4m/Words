package com.github.teren4m.words.words.list.item

import com.github.teren4m.base.mvvm.ItemListViewModel
import com.github.teren4m.words.words.list.model.WordItem

class HebrewWordViewModel(
    private val hebrewWord: WordItem.Hebrew
) : IHebrewWordViewModel, ItemListViewModel {

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

    override fun isViewModelType(obj: Any): Boolean =
        obj is IHebrewWordViewModel

}